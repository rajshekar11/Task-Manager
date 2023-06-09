package com.task.service;

import com.task.entity.User;
import com.task.exception.UserException;

public interface UserService {

	public User registerAUser(User user) throws UserException;
	
	public User updateUser(User user) throws UserException;
	
	public User getUserById(Integer uid) throws UserException;
	
	public User deleteUserById(Integer uid) throws UserException;
}
