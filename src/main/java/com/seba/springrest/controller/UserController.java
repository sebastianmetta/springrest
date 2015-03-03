package com.seba.springrest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seba.springrest.model.User;
import com.seba.springrest.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(UserController.class.getName());
	
	@RequestMapping(method=RequestMethod.GET, value="/user")
	public User user(@RequestParam(value="id", defaultValue="0") int userId) {
		logger.info("QUerying for user with id: " + userId);
		return userService.getUser(userId);
	}
	
}
