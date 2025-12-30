package com.tcs.springsecurity.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// UserDetailssService is an interface which holds User's data
// Internally spring security uses UserDetailsService object to validate uname and pass

@Configuration	
public class Config {
	
	@Bean
	protected UserDetailsService uds() {
		List<UserDetails> users = new ArrayList<>();
		
		users.add(User.withDefaultPasswordEncoder().username("abc").password("xyz").roles("user").build());
		users.add(User.withDefaultPasswordEncoder().username("def").password("ghi").roles("user").build());
		users.add(User.withDefaultPasswordEncoder().username("jkl").password("lmn").roles("user").build());
		
		return new InMemoryUserDetailsManager(users);
	}
}
