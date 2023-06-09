package com.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.User;
import com.task.exception.UserException;
import com.task.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository urep;

	@Override
	public User registerAUser(User user) throws UserException {
		return urep.save(user);
	}

	@Override
	public User updateUser(User user) throws UserException {
		Optional<User> opt=urep.findById(user.getUid());
		if(opt.isPresent()) {
			return urep.save(user);
		}
		throw new UserException("Please varify userid or register a new user");
	}

	@Override
	public User getUserById(Integer uid) throws UserException {
		Optional<User> opt=urep.findById(uid);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new UserException("Please varify userid or register a new user");
	}

	@Override
	public User deleteUserById(Integer uid) throws UserException {
		Optional<User> opt=urep.findById(uid);
		if(opt.isPresent()) {
			User u= opt.get();
			urep.delete(u);
		}
		throw new UserException("Please varify userid or register a new user");
	}

}
