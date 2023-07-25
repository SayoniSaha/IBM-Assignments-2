package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);

	List<Employee> listEmployees();
	Optional<Employee> getEmployeeById(int employeeId);
	Employee updateEmployeeById(Employee employee);
	Optional<Employee> deleteEmployeeById(int employeeId);

}
