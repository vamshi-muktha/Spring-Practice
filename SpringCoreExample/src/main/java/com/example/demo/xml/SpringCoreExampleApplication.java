package com.example.demo.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreExampleApplication {

	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("sample.xml");

		Resource r1 = con.getBean(Resource.class);
		System.out.println(r1.getResourceName() + " " + r1.getResourcePort());

		Resource2 r2 = con.getBean(Resource2.class);
		System.out.println(r2.getResourceName() + " " + r2.getResourcePort());

		Resource r3 = con.getBean(Resource.class);
		System.out.println(r3.getResourceName() + " " + r3.getResourcePort());

		((ClassPathXmlApplicationContext) con).close();

	}

}
