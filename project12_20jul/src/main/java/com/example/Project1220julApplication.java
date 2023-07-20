package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example")
@SpringBootApplication
public class Project1220julApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project1220julApplication.class, args);
	}

}
