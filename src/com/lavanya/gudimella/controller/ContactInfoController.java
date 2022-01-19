package com.lavanya.gudimella.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.dto.User;
import com.lavanya.gudimella.exceptions.UserFormValidationException;
import com.lavanya.gudimella.service.UserService;

@RestController
@RequestMapping("/user/contactInfo")
public class ContactInfoController {
	
	@Autowired
	private UserService userService;

	// form binding for bank info
	@RequestMapping(value = "/addContactInfo", method=RequestMethod.GET)
	private ModelAndView bindBankInfo() {
		ModelAndView modelAndView = new ModelAndView("ContactInfo");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/addContactInfo", method=RequestMethod.POST)
	private ModelAndView addBankInfo(@SessionAttribute("mUser") User mUser, @ModelAttribute("user") User user, ModelAndView modelAndView) {
		//contact info form validation handling exceptions
		String result = null;
		try {
			userService.contactInfoFormValidation(user.getAddress(), user.getCity(), user.getState(), user.getCountry(), user.getZipcode(), user.getPhone_number());
		} catch (UserFormValidationException e) {
			result = e.getErrorMessage();
			e.printStackTrace();
		}
		
		if(result==null) {
			System.out.println(mUser.getFirst_name());
			
			//set the form values to session - mUser
			mUser.setAddress(user.getAddress());
			mUser.setCity(user.getCity());
			mUser.setState(user.getState());
			mUser.setCountry(user.getCountry());
			mUser.setZipcode(user.getZipcode());
			mUser.setPhone_number(user.getPhone_number());
			
			//redirect to bank info controller if success
			modelAndView = new ModelAndView("redirect:/user/bankInfo/addBankInfo");
		} else {
			//redirect to error page
			modelAndView = new ModelAndView("ErrorPage");
			modelAndView.addObject("result", result);
		}
		return modelAndView;
	}
}
