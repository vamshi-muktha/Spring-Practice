package com.tcs.assessment4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.assessment4.bean.Account;
import com.tcs.assessment4.bean.TranHistory;
import com.tcs.assessment4.service.AccountService;
import com.tcs.assessment4.service.TranhistoryService;

import jakarta.validation.Valid;


@Controller
public class JspController {
	
//	@Autowired
//	UserService us;
	@Autowired
	AccountService as;
	
	@Autowired
	TranhistoryService ts;
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping("/wel")
	public String getWel() {
		return "welcome";
	}
	
	@RequestMapping("/saveacc")
	public String getAccForm() {
		return "account";
	}
	
	@RequestMapping("/savetran")
	public String getTranForm() {
		return "tranhistory";
	}
	
//	@GetMapping("/register")
//	public String getRegister() {
//		return "register";
//	}
//	
//	@PostMapping("/register")
//	public String postRegisterName(@RequestParam String username, @RequestParam String password, @RequestParam String cpassword, @RequestParam String details) {
//		//TODO: process POST request
//		System.out.println(username + " " + password);
//		if(!password.equals(cpassword)) {
//			System.out.println("Enter both passwords same");
//			return "register";
//		}
//		PasswordEncoder p = new BcryptPassword4jPasswordEncoder();
//		String pass = password;
//		String enc = p.encode(pass);
//		System.out.println(enc);
//		User u = new User(username, enc, password);
//		us.saveUser(u);
//		return "login";
//	}
	
	
	@PostMapping("/saveacc")
	public String saveAcc(@Valid @ModelAttribute Account acc){
		as.saveAcc(acc);
		return "welcome";		
	}
	
	
	@PostMapping("/savetran")
	public String saveTran(@ModelAttribute TranHistory tran, @RequestParam int accNo) {
		System.out.println(tran + " " + accNo);
		//TODO: process POST request
		tran.setAcc(as.getById(accNo));
		ts.saveTran(tran);
		return "welcome";
	}
	
}
