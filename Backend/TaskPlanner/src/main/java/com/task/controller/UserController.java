package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.User;
import com.task.exception.UserException;
import com.task.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/user")
	public ResponseEntity<User> registerAUser(@RequestBody User user) throws UserException{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User u=us.registerAUser(user);
		return new ResponseEntity<User>(u,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/userupdate")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException{
		User u=us.updateUser(user);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable("uid") Integer uid) throws UserException{
		User u=us.getUserById(uid);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{uid}")
	public ResponseEntity<User> deleteUserById(@PathVariable("uid") Integer uid) throws UserException{
		User u=us.deleteUserById(uid);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
}
