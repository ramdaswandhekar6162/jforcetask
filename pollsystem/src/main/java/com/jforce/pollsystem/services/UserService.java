package com.jforce.pollsystem.services;

import com.jforce.pollsystem.entity.User;

public interface UserService {
	
	public void save(User user);
	
	public User findByUserName(String username);

}
