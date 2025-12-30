package com.tcs.springsecurity.bean;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User implements UserDetails {
	
	@Id
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String details;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> list=new ArrayList<>();
		list.add(new SimpleGrantedAuthority("admin")); 
		return list;
	}
	
	
	

}

