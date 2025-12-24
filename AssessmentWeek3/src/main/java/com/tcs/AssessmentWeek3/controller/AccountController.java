package com.tcs.AssessmentWeek3.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.AssessmentWeek3.bean.Account;

import jakarta.validation.Valid;

@RestController
public class AccountController {
	Map<Integer, Account> hm;
	public AccountController() {
		hm = new HashMap<>();
		hm.put(10001, new Account(10001, "Vamshi", 8000, "Adi0001111111", "Adibatla Hyd", "vamshi@gmail.com"));
		hm.put(10002, new Account(10002, "Virat", 8000, "Adi0001111112", "Adibatla Hyd", "Virat@gmail.com"));
		hm.put(10003, new Account(10003, "Dhobi", 8000, "Adi0001111113", "Adibatla Hyd", "Dhobi@gmail.com"));
		hm.put(10004, new Account(10004, "Rohit", 8000, "Adi0001111114", "Adibatla Hyd", "Rohit@gmail.com"));
		hm.put(10005, new Account(10005, "Rahul", 8000, "Adi0001111115", "Adibatla Hyd", "Rahul@gmail.com"));
		hm.put(10006, new Account(10006, "Gambhir", 8000, "Adi0001111116", "Adibatla Hyd", "Gambhir@gmail.com"));
		hm.put(10007, new Account(10007, "Narine", 8000, "Adi0001111117", "Adibatla Hyd", "Narine@gmail.com"));
		hm.put(10008, new Account(10008, "Rahane", 8000, "Adi0001111118", "Adibatla Hyd", "Rahane@gmail.com"));
		hm.put(10009, new Account(10009, "Pujara", 8000, "Adi0001111119", "Adibatla Hyd", "Pujara@gmail.com"));
	}
	
	
	@PostMapping("/saveacc")
	public ResponseEntity<String> saveacc(@Valid @RequestBody Account acc){
		hm.put(acc.getAccNo(), acc);
		return new ResponseEntity<>("Employee Saved", HttpStatus.OK);
		
	}
	
	@GetMapping("/getacc/{ano}")
	public ResponseEntity<Account> getbyid(@PathVariable int ano){
		Account acc = hm.get(ano);
		return new ResponseEntity<>(acc, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getaccbid/{bid}")
	public ResponseEntity<Account> getbybid(@PathVariable String bid){
		Account acc = null;
		for(Integer i : hm.keySet()) {
			if(hm.get(i).getBid().equals(bid))acc = hm.get(i);
		}
		return new ResponseEntity<>(acc, HttpStatus.OK);
		
	}
}
