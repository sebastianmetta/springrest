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

	public User get(String username) {
		System.out.println("Querying username: " + username);
		userDao.getByName(username);
		return null;
	}
	
	public User get(int userId) {
		System.out.println("Querying user id: " + userId);
		return userDao.getById(userId);
	}
	
	public List<User> getAll() {
		System.out.println("Querying all users");
		return userDao.getAll();
	}

	public void add(User user) {
		System.out.println("Assing user: " + user.toString());
		// TODO Implement me!
	}

	public void update(User user) {
		System.out.println("Updading user: " + user.toString());
		// TODO Implement me!
	}

	public void delete(int id) {
		System.out.println("Deleting user with id: " + id);
		// TODO Implement me!
	}
}
