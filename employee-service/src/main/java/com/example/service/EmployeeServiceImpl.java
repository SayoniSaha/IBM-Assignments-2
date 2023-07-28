package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.EmployeeEntity;
import com.example.repo.EmployeeRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;
	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}

}
