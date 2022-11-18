package com.tlb.service;

import org.springframework.stereotype.Service;

import com.tlb.entity.User;


public interface UserService {
	
	public User loginUser(User user);
	
	public User registerUser(User user);

	public User fetchUserByEmailId(String emailId);

}
