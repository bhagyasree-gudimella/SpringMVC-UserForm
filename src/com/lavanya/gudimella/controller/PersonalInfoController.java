package com.lavanya.gudimella.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.dto.User;
import com.lavanya.gudimella.exceptions.UserFormValidationException;
import com.lavanya.gudimella.service.UserService;

@RestController
@RequestMapping("/user/personalInfo")
@SessionAttributes("mUser")
public class PersonalInfoController {
	
	@Autowired
	private UserService userService;

	// form binding for personal info
	@RequestMapping(value = "/addPersonalInfo", method = RequestMethod.GET)
	private ModelAndView bindPersonalInfo() {
		ModelAndView modelAndView = new ModelAndView("PersonalInfo");
		User user = new User();
		modelAndView.addObject("mUser", user);
		return modelAndView;
	}

	@RequestMapping(value = "/addPersonalInfo", method=RequestMethod.POST)
	private ModelAndView addPersonalInfo(@ModelAttribute("mUser") User user, ModelAndView modelAndView) {
		//personal info form validation	handling exception
		String result = null;
		try {
			userService.personalInfoFormValidation(user.getFirst_name(), user.getMiddle_name(), user.getLast_name(), user.getEmail_address());
		} catch (UserFormValidationException e) {
			result = e.getErrorMessage();
			e.printStackTrace();
		}
		
		if(result==null) {
			//redirect to contact info controller if success
			modelAndView = new ModelAndView("redirect:/user/contactInfo/addContactInfo");
		} else {
			//redirect to error page
			modelAndView = new ModelAndView("ErrorPage");
			modelAndView.addObject("result", result);
		}
		return modelAndView;
	}
}
