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
@RequestMapping("/user/updateUser")
public class UpdateUserController {
	
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//form binding for update user
	@RequestMapping(value="/update", method=RequestMethod.GET)
	private ModelAndView bindUpdateForm() {
		ModelAndView modelAndView = new ModelAndView("UpdateUser");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	private ModelAndView updateUser(HttpServletRequest request, @ModelAttribute("user") User user, ModelAndView modelAndView) {
		System.out.println(user.getAddress());
		
		//validation for update user form
		String result = null;
		try {
			userService.updateUserFormValidation(user.getCity(), user.getState(), user.getCountry(), user.getZipcode(), user.getPhone_number(), user.getBank_name(), user.getAccount_details());
		} catch (UserFormValidationException e) {
			result = e.getErrorMessage();
			e.printStackTrace();
		}
		
		if(result==null) {
			//get the email_address from httpSession
			HttpSession httpSession = request.getSession();
			String email_address = (String) httpSession.getAttribute("email_address");
			
			//update user details in database
			userService.updateUser(user.getAddress(), user.getCity(), user.getState(), user.getCountry(), user.getZipcode(), user.getPhone_number(), user.getBank_name(), user.getAccount_details(), email_address);
			
			//redirect to success page
			modelAndView = new ModelAndView("Success");
			result = email_address + ", User details has been updated successfully";
			modelAndView.addObject("result", result);
		} else {
			//redirect to error page
			modelAndView = new ModelAndView("ErrorPage");
			modelAndView.addObject("result", result);
		}
		return modelAndView;
	}
}