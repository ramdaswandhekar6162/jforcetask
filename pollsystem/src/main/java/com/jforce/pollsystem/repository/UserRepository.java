package com.jforce.pollsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jforce.pollsystem.entity.User;


@Repository
public interface UserRepository extends JpaRepository<com.jforce.pollsystem.entity.User, Long> {
	
	User findByUsername(String username);

}
