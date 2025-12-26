package com.tcs.SpringWithJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.SpringWithJpa.bean.PfBankDetails;
import com.tcs.SpringWithJpa.service.PfService;



@RestController
public class PfController {
	
	@Autowired
	PfService ps;
	
	@PostMapping("/savepf")
	public String savePf(@RequestBody PfBankDetails pf) {
		//TODO: process POST request
		ps.savepf(pf);
		return "pf SAved";
	}
	
	@GetMapping("/getpfs")
	public List<PfBankDetails> getpfs() {
		return ps.getall();
	}
	
	
	
	@GetMapping("/getpf/{eno}")
	public PfBankDetails getpf(@PathVariable int eno) {
		
		return ps.getpf(eno);
	}
	
	@GetMapping("/getbypf/{pfno}")
	public List<PfBankDetails> getbypfno(@PathVariable String pfno) {
		
		return ps.getbypf(pfno);
	}
	
	
}
