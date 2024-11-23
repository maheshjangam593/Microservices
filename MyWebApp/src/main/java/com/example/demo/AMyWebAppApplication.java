package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AMyWebAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(AMyWebAppApplication.class, args);
		System.out.println("hello");
		//@Value("server.port") String port;
		
		Controller12 c=context.getBean(Controller12.class);
		//c.getPort();
		
	}

}
