package com.project.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.dao.User_repo;
import com.project.entity.User;

@Component
public class user_service implements UserDetailsService{
	
	@Autowired
	private User_repo repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user_data= repo.findByEmail(email);
		
		if(user_data==null) {
			
		 	throw new UsernameNotFoundException("user name not found");
			
		}
		else {
		return new user_details(user_data);
	}
	}
	
	

}
