package com.example.service;

import com.example.model.UserEntity;

public interface UserService {
    UserEntity createUser(UserEntity user);
    UserEntity getUserById(int id);
}
