package com.tlb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlb.entity.User;
import com.tlb.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User loginUser(User user) {
		User userObj =userRepository.findByEmail(user.getEmail());
		return userObj;
		
	}
	
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

}
