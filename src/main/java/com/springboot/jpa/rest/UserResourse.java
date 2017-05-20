package com.springboot.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.dao.UserDao;
import com.springboot.jpa.domain.User;
import com.springboot.jpa.exception.BadRequestException;
import com.springboot.jpa.exception.UserNotFoundException;

@RestController
@RequestMapping(path = "users")
public class UserResourse {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<User> listAll() {
		List<User> allUsers = userDao.findAll();
		return allUsers;
	}
	
	@RequestMapping(path = "find", method = RequestMethod.GET)
	public User findUserByEmailAddress(@RequestParam(required = true, name = "email") String email) {
		User user = userDao.findByEmailAddress(email);
		if (null == user)
			throw new UserNotFoundException("User with email address = " + email + " not found");
		else 
			return user;
	}
	
	@RequestMapping(path = "{username}", method = RequestMethod.GET)
	public User findUserByUserName(@PathVariable("username") String username) {
		User user = userDao.findOne(username);
		if (null == user)
			throw new UserNotFoundException("User with username = " + username + " not found");
		else 
			return user;
	}
	
	@RequestMapping(path = "{username}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@PathVariable("username") String username, @RequestBody User user) {
		if (username.equals(user.getUsername())) {
			return userDao.save(user);
		}
		throw new BadRequestException("username is not matching with request body");
	}
}
