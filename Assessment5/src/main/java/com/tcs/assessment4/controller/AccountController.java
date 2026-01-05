package com.tcs.assessment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.assessment4.bean.Account;
import com.tcs.assessment4.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController {
	@Autowired
	AccountService as;
	
//	@PostMapping("/saveacc")
//	public ResponseEntity<String> saveAcc(@Valid @RequestBody Account acc){
//		as.saveAcc(acc);
//		return new ResponseEntity<>("Employee Saved", HttpStatus.OK);
//		
//	}
	
	@GetMapping("/getacc/{ano}")
	public ResponseEntity<Account> getById(@PathVariable int ano){
		Account acc = as.getById(ano);
		return new ResponseEntity<>(acc, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getaccbid/{bid}")
	public ResponseEntity<List<Account>> getByBid(@PathVariable String bid){
		return new ResponseEntity<>(as.getByBid(bid), HttpStatus.OK);
		
	}
	
	
}
