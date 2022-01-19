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
@RequestMapping("/user/bankInfo")
public class BankInfoController {
	
	@Autowired
	private UserService userService;

	//form binding for bank info
	@RequestMapping(value="/addBankInfo", method=RequestMethod.GET)
	private ModelAndView bindBankInfo() {
		ModelAndView modelAndView = new ModelAndView("BankInfo");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/addBankInfo", method=RequestMethod.POST)
	private ModelAndView addBankInfo(@SessionAttribute("mUser") User mUser, @ModelAttribute("user") User user, ModelAndView modelAndView) {
		//bank info form validation
		String result = null;
		try {
			userService.bankInfoFormValidation(user.getBank_name(), user.getAccount_details(), user.getSsn_number());
		} catch (UserFormValidationException e) {
			result = e.getErrorMessage();
			e.printStackTrace();
		}
		
		if(result==null) {		
			//set the form values to session mUser
			mUser.setBank_name(user.getBank_name());
			mUser.setAccount_details(user.getAccount_details());
			mUser.setSsn_number(user.getSsn_number());
			
			//checking user values from session
			System.out.println("First Name : " +mUser.getFirst_name());
			System.out.println("Address : " +mUser.getAddress());
			System.out.println("Bank Name : " +mUser.getBank_name());
			
			//check user exists in database
			if(userService.findUser(mUser.getEmail_address())) {
				//redirect to error page
				modelAndView = new ModelAndView("ErrorPage");
				result = "User already found in database";
				modelAndView.addObject("result", result);
			} else {
				//add the user values to database
				userService.addUser(mUser);
				
				//redirect to registration success page if success
				modelAndView = new ModelAndView("RegistrationSuccess");
			}
		} else {
			//redirect to error page
			modelAndView = new ModelAndView("ErrorPage");
			modelAndView.addObject("result", result);
		}
		return modelAndView;
	}
}
