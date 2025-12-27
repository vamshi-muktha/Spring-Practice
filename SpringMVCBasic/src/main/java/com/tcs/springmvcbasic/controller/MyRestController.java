package com.tcs.springmvcbasic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	@RequestMapping("/getmsg")
	public String getMessage() {
		return "Hello World";
	}
	@RequestMapping("/getmsg1")
	public String getMessage1() {
		return "Hello World message2   kkk";
	}
	
}
