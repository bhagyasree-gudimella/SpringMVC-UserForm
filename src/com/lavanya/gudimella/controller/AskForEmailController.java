package com.lavanya.gudimella.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/user/emailInfo")
public class AskForEmailController {
	
	@Autowired
	private UserService userService;

	//form binding for asking email address
	@RequestMapping(value="/askForEmail", method=RequestMethod.GET)
	private ModelAndView bindUpdateForm() {
		ModelAndView modelAndView = new ModelAndView("AskForEmailAddress");
		User user = new User();
		modelAndView.addObject("email_address", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/askForEmail", method=RequestMethod.POST)
	private ModelAndView askForEmail(HttpServletRequest request, @ModelAttribute("email_address") User user, ModelAndView modelAndView) {
		System.out.println(user.getEmail_address());
	
		//email validation for update user
		String result = null;
		try {
			userService.validateEmail(user.getEmail_address());
		} catch (UserFormValidationException e) {
			result=e.getErrorMessage();
			e.printStackTrace();
		}
		
		if(result==null) {
			if(userService.findUser(user.getEmail_address())) {
				//add the email_address to httpSession
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("email_address", user.getEmail_address());
				
				//redirect to update user page if success
				modelAndView = new ModelAndView("redirect:/user/updateUser/update");
			} else {
				//redirect to error page
				modelAndView = new ModelAndView("ErrorPage");
				result = "User does not found in database";
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
