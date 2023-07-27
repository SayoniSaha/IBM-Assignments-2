package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	@Query
	UserEntity findByUserId(String userId);
}
