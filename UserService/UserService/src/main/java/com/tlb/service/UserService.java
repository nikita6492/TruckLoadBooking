package com.tlb.service;

import com.tlb.entity.User;

public interface UserService {
	
	public User loginUser(User user);
	
	public User registerUser(User user);

}
