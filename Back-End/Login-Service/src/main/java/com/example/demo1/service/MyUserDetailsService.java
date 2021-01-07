package com.example.demo1.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo1.model.User;
import com.example.demo1.repository.UserRepository;
@Service

public class MyUserDetailsService implements UserDetailsService {
@Autowired
UserRepository userRepository;
	
	@Override 
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByUserName(userName);
		
		//if user does not exists throw this userFriendlyMessage
		user.orElseThrow(()->new UsernameNotFoundException("User does not exists with the name"+userName));
	return 	user.map(MyUserDetails::new).get();
	}

}
