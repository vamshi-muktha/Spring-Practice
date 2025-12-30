package com.tcs.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// UserDetailssService is an interface which holds User's data
// Internally spring security uses UserDetailsService object to validate uname and pass

@Configuration	
public class Config {

	@Autowired
	private UserDetailsService uds;
	
	@Bean
	public DaoAuthenticationProvider authicate() {
		DaoAuthenticationProvider dp = new DaoAuthenticationProvider(uds);
//		dp.setUserDetailsService(uds);
		dp.setPasswordEncoder(new BCryptPasswordEncoder());
		return dp;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/jsp").permitAll()   // allow /jsp without authentication
				.requestMatchers("/wel").authenticated() // require auth for /wel
				.anyRequest().authenticated() // secure all other requests by default
			)
			.formLogin(null); // use Spring Security's default login page
		
		return http.build();
	}
}