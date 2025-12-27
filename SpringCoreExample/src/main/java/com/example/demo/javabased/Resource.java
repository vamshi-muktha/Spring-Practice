package com.example.demo.javabased;

public class Resource {
	private String resourceName;
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

	public void init() {
		System.out.println("Init Method");
	}
	public void destroy() {
		System.out.println("destroy Method");
	}
}
