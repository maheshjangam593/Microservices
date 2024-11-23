package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=	SpringApplication.run(FirstProjApplication.class, args);
		//System.out.println("Wellcome to Boot Sping");
		Alien a=context.getBean(Alien.class);
		a.show();
//		Alien a1=context.getBean(Alien.class);
		//Laptop l=context.getBean(Laptop.class);
		
		
		
	}

}
