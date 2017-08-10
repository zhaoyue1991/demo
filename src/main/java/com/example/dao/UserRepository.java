package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mdl.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	
	User findByUserNameOrEmail(String username, String email);
}
