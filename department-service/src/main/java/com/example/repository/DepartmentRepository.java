package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	@Query
	Department findByDepartmentName(String departmentName);

}
