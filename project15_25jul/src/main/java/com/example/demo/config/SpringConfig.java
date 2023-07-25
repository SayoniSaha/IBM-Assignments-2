package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SpringConfig implements CommandLineRunner {

	private final EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("abc", 100000));
		employees.add(new Employee("efg", 200000));
		employees.add(new Employee("ijk", 300000));
		employeeRepository.saveAll(employees);
	}
}
