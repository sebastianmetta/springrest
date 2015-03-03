package com.seba.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.seba.springrest.dao.UserDao;
import com.seba.springrest.model.User;

public class UserService {

	@Autowired
	private UserDao userDao;

	public UserService() {
		
	}
	
	public List<User> listUsers(){
		return userDao.list();
	}
	
	public void saveUser(User user) {
		userDao.save(user);
	}

	public User getUser(String username) {
		userDao.getByName(username);
		return null;
	}
	
	public User getUser(int userId) {
		return userDao.getById(userId);
	}
}
