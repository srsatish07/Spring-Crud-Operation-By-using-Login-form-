package com.project.configure;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.entity.User;

public class user_details  implements UserDetails{
	
	private User user;
	
	public user_details(User user) {
		super();
		this.user = user;
	}

	
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority simple=new SimpleGrantedAuthority(user.getEmail());
		return List.of(simple);
	}

}
