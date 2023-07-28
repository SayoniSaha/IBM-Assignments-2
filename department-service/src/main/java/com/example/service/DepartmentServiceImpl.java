package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;

	@Override
	public Department findDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}

}
