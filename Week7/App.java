package com.spring.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstProjApplication.class, args);
			
		Mobile myMobile = context.getBean(Mobile.class);
		myMobile.tellSpec();
	}

}
