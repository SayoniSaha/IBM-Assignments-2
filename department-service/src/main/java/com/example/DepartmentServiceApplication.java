package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableEurekaClient
@AllArgsConstructor
public class DepartmentServiceApplication implements CommandLineRunner {
	private final DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		departmentRepository.save(new Department("d1", "l1"));
		departmentRepository.save(new Department("d2", "l2"));
		departmentRepository.save(new Department("d3", "l3"));
		
	}

}
