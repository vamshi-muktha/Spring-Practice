package com.example.componentProp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringCoreExampleApplication {

	public static void main(String[] args) {
		ApplicationContext con = new AnnotationConfigApplicationContext(Config.class);
		
		Resource r1 = con.getBean(Resource.class);
		System.out.println(r1.getResourceName() + " " + r1.getResourcePort());
		
		Resource2 r2 = con.getBean(Resource2.class);
		r2.display();

		((AnnotationConfigApplicationContext) con).close();
		
	}

}
