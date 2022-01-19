package com.lavanya.gudimella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lavanya.gudimella.dto.User;
import com.lavanya.gudimella.exceptions.UserFormValidationException;
import com.lavanya.gudimella.service.UserService;

@RestController
@RequestMapping("/user/deleteUser")
public class DeleteUserController {
	
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//form binding for asking email address
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	private ModelAndView bindEmailForm() {
		ModelAndView modelAndView = new ModelAndView("DeleteUser");
		User user=new User();
		modelAndView.addObject("email_address", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	private ModelAndView askForEmail(@ModelAttribute("email_address") User user, ModelAndView modelAndView) {
		//validate the email address
		String result = null;
		try {
			userService.validateEmail(user.getEmail_address());
		} catch (UserFormValidationException e) {
			result = e.getErrorMessage();
			e.printStackTrace();
		}
		
		if(result==null) {
			if(userService.findUser(user.getEmail_address())) {
				//redirect to success page
				userService.deleteUser(user.getEmail_address());
				modelAndView = new ModelAndView("Success");
				result = user.getEmail_address() + ", have been deleted successfully";
				modelAndView.addObject("result", result);
			} else {
				//redirect to error page
				modelAndView = new ModelAndView("ErrorPage");
				result = "User does not exist in database";
				modelAndView.addObject("result", result);
			}
		} else {
			//redirect to error page
			modelAndView = new ModelAndView("ErrorPage");
			modelAndView.addObject("result", result);
		}
		return modelAndView;
	}
}
