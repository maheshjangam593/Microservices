package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyWebApp2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(MyWebApp2Application.class, args);
		JdbcController j=context.getBean(JdbcController.class);
		
	}

}
