package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.User;

public interface User_repo extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
}
