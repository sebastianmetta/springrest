package com.seba.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seba.springrest.model.User;
import com.seba.springrest.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		return userService.getAll();
	}

	@RequestMapping(value="{id}",method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable int id) {
		return userService.get(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void addUser(@RequestBody User user) {
		// @RequestBody indicate to the server that the json content of the
		// request is use to fill a new user instance.
		// @ResponseBody alone is required on void method to return no content
		// to the REST Client .
		userService.add(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void putComputer(@PathVariable int id, @RequestBody User user) {
		// Following the rest convention, the id of the entity to update is set
		// in the uri like in this example : PUT on
		// http://localhost:8080/springrest/user/6 .
		// Set the id in the uri and not in the json content respect the REST
		// convention.
		user.setId(id);
		userService.update(user);
	}

	 @RequestMapping(value="{id}", method = RequestMethod.DELETE)
	 @ResponseBody
	 public void deleteComputer(@PathVariable int id) {
	   userService.delete(id);
	 } 
	
}
