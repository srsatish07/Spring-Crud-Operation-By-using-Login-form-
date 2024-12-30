package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.dao.User_repo;
import com.project.entity.User;

@Controller
public class maincontroller {
	
	@Autowired
	private User_repo daouser;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/process")
	public String process() {
		
		return "process";
	}
	
	
	@PostMapping("/register")
	public String signindata(@ModelAttribute User user, Model m) {
		System.out.println(user.getName());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User result=daouser.save(user);
		System.out.println(result);
		
		return "login";
	}
	

}
