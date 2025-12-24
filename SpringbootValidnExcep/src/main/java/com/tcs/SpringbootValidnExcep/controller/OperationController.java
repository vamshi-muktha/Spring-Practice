package com.tcs.SpringbootValidnExcep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.SpringbootValidnExcep.bean.Operation;

import jakarta.validation.Valid;

@RestController
public class OperationController {
	
	@GetMapping("/sum")
	public ResponseEntity<Integer> sum(@RequestParam int inp1, @RequestParam int inp2){
		if(inp1 == 0 && inp2 == 0)throw new ArithmeticException("Both should not be zeroes");
		Operation ope = new Operation(inp1, inp2);
		ope.setRes(ope.getInp1() + ope.getInp2());
		return new ResponseEntity<>(ope.getRes(), HttpStatus.OK);
		
	}
	
	@GetMapping("/div")
	public ResponseEntity<Integer> div(@RequestParam int inp1, @RequestParam int inp2) {
		Operation ope = new Operation(inp1, inp2);
		ope.setRes(ope.getInp1() / ope.getInp2());
		return new ResponseEntity<>(ope.getRes(), HttpStatus.OK);
	}
	
	@PostMapping("/sumb")
	public ResponseEntity<Integer> sum(@Valid @RequestBody Operation ope){
		if(ope.getInp1() == 0 && ope.getInp2() == 0)throw new ArithmeticException("Both should not be zeroes");
		ope.setRes(ope.getInp1() + ope.getInp2());
		return new ResponseEntity<>(ope.getRes(), HttpStatus.OK);
		
	}
	
	@PostMapping("/divb")
	public ResponseEntity<Integer> div(@Valid @RequestBody Operation ope){
		if(ope.getInp1() == 0 && ope.getInp2() == 0)throw new ArithmeticException("Both should not be zeroes");
		ope.setRes(ope.getInp1() / ope.getInp2());
		return new ResponseEntity<>(ope.getRes(), HttpStatus.OK);
		
	}
	
}
