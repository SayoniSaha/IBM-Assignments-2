package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserEntity;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        String encryptedPassword = new StringBuilder(user.getPassword()).reverse().toString();
        user.setEncryptedPassword(encryptedPassword);
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
