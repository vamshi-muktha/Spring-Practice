package com.example.demo.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreExampleApplication {

	public static void main(String[] args) {
		ApplicationContext con = new AnnotationConfigApplicationContext(Config.class);

		Resource r1 = con.getBean(Resource.class);
		System.out.println(r1.getResourceName() + " " + r1.getResourcePort());


		((AnnotationConfigApplicationContext) con).close();

	}

}
