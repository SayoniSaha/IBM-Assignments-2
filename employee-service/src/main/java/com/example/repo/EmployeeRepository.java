package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
