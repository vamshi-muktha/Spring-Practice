package com.tcs.springsecurity.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/home")
	public String getMethodName() {
		return "Welcome to my home";
	}
	public static void main(String[] args) {
		PasswordEncoder p = new BcryptPassword4jPasswordEncoder();
		String pass = "xyz3";
		String enc = p.encode(pass);
		System.out.println(enc);
		
	}
}
