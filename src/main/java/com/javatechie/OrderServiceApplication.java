package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		// in intellij idea,how to make a jar file as below:
		// to package the application as a jar file
		// firstly click maven icon then click on lifecycle and then click on package
		// or use the command: mvn clean package

		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
