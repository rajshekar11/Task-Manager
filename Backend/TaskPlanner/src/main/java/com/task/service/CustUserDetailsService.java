package com.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import com.task.repository.UserRepository;

public class CustUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository urep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<com.task.entity.User> opt= urep.findByEmail(username);

		if(opt.isPresent()) {
			
			com.task.entity.User u= opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			return new User(u.getEmail(), u.getPassword(), authorities);
			
		}else
			throw new BadCredentialsException("User Details not found with this username: "+username);
		
		
	}

}
