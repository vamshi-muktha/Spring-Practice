package com.tcs.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	@RequestMapping("/jsp")
	public String getJsp() {
		return "sample";
	}
	
	@RequestMapping("/login1")
	public String getLoginPage() {
		return "login";
	}
}
