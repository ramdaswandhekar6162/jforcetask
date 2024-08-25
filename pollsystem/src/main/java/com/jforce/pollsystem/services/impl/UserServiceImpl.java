package com.jforce.pollsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.pollsystem.entity.User;
import com.jforce.pollsystem.repository.UserRepository;
import com.jforce.pollsystem.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
		userRepo.save(user);

	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		
		User userFounded = userRepo.findByUsername(username);
		return userFounded;
	}

}
