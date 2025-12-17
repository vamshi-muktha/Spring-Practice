package com.example.demo.componentProp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.example.componentProp")
@PropertySource(value = { "myres.properties" })
public class Config {
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropFile() {
		return new PropertySourcesPlaceholderConfigurer();
	}

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
