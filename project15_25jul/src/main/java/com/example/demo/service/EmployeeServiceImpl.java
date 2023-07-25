package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional==null) {
			return null;
		} else {
			return empOptional;
		}
		
	}
	
	@Override
	public Employee updateEmployeeById(Employee employee) {
		Optional<Employee> oEmployee = employeeRepository.findById(employee.getEmployeeId());

		if (oEmployee.isEmpty()) {
			return null;
		}
		else
		{
			oEmployee.get().setEmployeeName(employee.getEmployeeName());
			oEmployee.get().setSalary(employee.getSalary());
			
			employeeRepository.save(oEmployee.get());
			return oEmployee.get();

		}
	}
	
	@Override
    public Optional<Employee> deleteEmployeeById(int employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
        if (empOptional.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return empOptional;
        } else {
            return Optional.empty();
        }
    }

}
