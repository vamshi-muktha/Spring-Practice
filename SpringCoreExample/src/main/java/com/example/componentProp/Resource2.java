package com.example.componentProp;

import org.springframework.stereotype.Component;

import jakarta.inject.Inject;

@Component
public class Resource2 {
	@Inject
	private Resource res;
	
	void display() {
		System.out.println(res.getResourceName() + "  " + res.getResourcePort());
	}
	
	
}
