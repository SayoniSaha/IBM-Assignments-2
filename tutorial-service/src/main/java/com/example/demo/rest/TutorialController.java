package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.TutorialRepository;
import com.example.demo.model.Tutorial;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialController(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @GetMapping("/{tutorialId}")
    public ResponseEntity<Tutorial> getTutorialDetails(@PathVariable int tutorialId) {
        Tutorial tutorial = tutorialRepository.findById(tutorialId).orElse(null);

        if (tutorial != null) {
            return ResponseEntity.ok(tutorial);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

