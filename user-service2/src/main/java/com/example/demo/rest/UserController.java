package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.user.UserAuthenticationService;

@Service
public class UserController {

    private final RestTemplate restTemplate;
    private final UserAuthenticationService userAuthenticationService;

    @Autowired
    public UserController(RestTemplate restTemplate, UserAuthenticationService userAuthenticationService) {
        this.restTemplate = restTemplate;
        this.userAuthenticationService = userAuthenticationService;
    }

    public boolean validateUserCredentials(String username, String password) {
        return userAuthenticationService.authenticateUser(username, password);
    }

    public String getTutorialDetails(int tutorialId, String username, String password) {
        if (validateUserCredentials(username, password)) {
            String url = "http://localhost:9191/tutorials/" + tutorialId;

            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(username, password);
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                return "Error: " + response.getStatusCode();
            }
        } else {
            return "Invalid input";
        }
    }
}

