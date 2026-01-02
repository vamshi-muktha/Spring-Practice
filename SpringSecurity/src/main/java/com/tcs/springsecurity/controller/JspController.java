package com.tcs.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.springsecurity.bean.User;
import com.tcs.springsecurity.service.UserService;


@Controller
public class JspController {
	
	@Autowired
	UserService us;
	@RequestMapping("/jsp")
	public String getJsp() {
		return "sample";
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping("/wel")
	public String getWel() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegisterName(@RequestParam String username, @RequestParam String password, @RequestParam String cpassword, @RequestParam String details) {
		//TODO: process POST request
		System.out.println(username + " " + password);
		if(!password.equals(cpassword)) {
			System.out.println("Enter both passwords same");
			return "register";
		}
		PasswordEncoder p = new BcryptPassword4jPasswordEncoder();
		String pass = password;
		String enc = p.encode(pass);
		System.out.println(enc);
		User u = new User(username, enc, password);
		us.saveUser(u);
		return "login";
	}
	
	
}
