package com.lavanya.gudimella.controller;

import java.util.ArrayList; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.dto.User;
import com.lavanya.gudimella.service.UserService;

@RestController
@RequestMapping("/user/list")
public class UsersListController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/usersList", method = RequestMethod.GET)
	private ModelAndView getUsersList() {
		ModelAndView modelAndView = new ModelAndView("ViewUsersList");
		List<User> usersList = new ArrayList<User>();
		usersList = userService.getUsersList();
		modelAndView.addObject("usersList", usersList);
		return modelAndView;
	}
}
