package com.example.demo.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.javabased.Config;

public class SpringCoreExampleApplication {

	public static void main(String[] args) {
		ApplicationContext con = new AnnotationConfigApplicationContext(Config.class);
		
		Resource r1 = (Resource) con.getBean("r1");
		System.out.println(r1.getResourceName() + " " + r1.getResourcePort());
		
//		Resource2 r2 = con.getBean(Resource2.class);
//		System.out.println(r2.getResourceName() + " " + r2.getResourcePort());
		
		Resource r3 = con.getBean(Resource.class);
		System.out.println(r3.getResourceName() + " " + r3.getResourcePort());
		
		((AnnotationConfigApplicationContext) con).close();
		
	}

}