package com.tcs.assessment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.assessment4.bean.TranHistory;
import com.tcs.assessment4.service.TranhistoryService;

@RestController
public class TranhistoryController {
	@Autowired
	TranhistoryService ts;
	
	@PostMapping("/savetran")
	public ResponseEntity<String> saveTran(@RequestBody TranHistory tran) {
		//TODO: process POST request
		ts.saveTran(tran);
		return new ResponseEntity<>("Transaction Saved", HttpStatus.OK);
	}
	
	@GetMapping("/gettrans")
	public ResponseEntity<List<TranHistory>> getTrans() {
		return new ResponseEntity<>(ts.getTrans(), HttpStatus.OK);
	}
	
	
}
