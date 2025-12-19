package com.tcs.SpringbootValidnExcep.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	
	@ExceptionHandler(exception = NullPointerException.class)
	public Map<String, String> handleNpe(NullPointerException ne){
		Map<String, String> hm = new HashMap<>();
		hm.put("errorCode", "101");
		hm.put("errorMessage", "There is some null pointer Exception");
		hm.put("details", ne.getMessage());
		return hm;
	}
	
	@ExceptionHandler(exception = ArithmeticException.class)
	public Map<String, String> handleAe(ArithmeticException ae){
		Map<String, String> hm = new HashMap<>();
		hm.put("errorCode", "102");
		hm.put("errorMessage", "There is some Arithmetic Exception");
		hm.put("details", ae.getMessage());
		return hm;
	}
	
}
