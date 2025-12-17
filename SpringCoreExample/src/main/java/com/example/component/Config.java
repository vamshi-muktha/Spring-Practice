package com.example.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.javabased.Resource2;

@Configuration
@ComponentScan("com.example.component")
public class Config {
	
//	@Bean(name = "r1")
//	public Resource getResource() {
//		Resource r = new Resource();
//		r.setResourceName("JavaBasedResource");
//		r.setResourcePort(8080);
//		return r;
//	}
//	@Bean(name = "r2")
//	@Primary
//	public Resource getResource1() {
//		Resource r = new Resource();
//		r.setResourceName("JavaBasedResource 2");
//		r.setResourcePort(8081);
//		return r;
//	}
//	
//	
//	
//	
//	@Bean
//	public Resource2 getResource2() {
//		Resource2 r2 = new Resource2("resource2", 9898);
//		
//		return r2;
//	}
}
