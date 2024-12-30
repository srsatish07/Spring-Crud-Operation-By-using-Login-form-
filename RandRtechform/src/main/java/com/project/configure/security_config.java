package com.project.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class security_config {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService getDetailsService() {
		
		return new user_service();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoprAuthenticationProvider=new DaoAuthenticationProvider();
		daoprAuthenticationProvider.setUserDetailsService(getDetailsService());
		daoprAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoprAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> requests.requestMatchers("/")
                .permitAll().anyRequest().authenticated()).formLogin(login -> login.loginPage("/login").
                loginProcessingUrl("/process").
                permitAll());
		
		return http.build();
		
	}
	
}
