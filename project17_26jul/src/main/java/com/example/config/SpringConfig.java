package com.example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.UserEntity;
import com.example.repository.UserRepository;

@Component
public class SpringConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity("u1", 1, "ab", "cd", "ab@example.com", "pass1", ""));
        users.add(new UserEntity("u2", 2, "ef", "gh", "ef@example.com", "pass2", ""));
        users.add(new UserEntity("u3", 3, "yu", "io", "yu@example.com", "pass3", ""));
        userRepository.saveAll(users);
    }
}
