package com.example.demo.componentProp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
public class Resource {

	@Value("${m.drivername}")
	private String resourceName;
	@Value("${m.portnum}")
	private int resourcePort;

	Resource(){
		System.out.println("Resource Object Created");
	}

	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public int getResourcePort() {
		return resourcePort;
	}
	public void setResourcePort(int resourcePort) {
		this.resourcePort = resourcePort;
	}
	@PostConstruct
	public void init() {
		System.out.println("Init Method");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy Method");
	}
}
