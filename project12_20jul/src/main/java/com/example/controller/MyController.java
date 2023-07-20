package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.League;

@Controller
public class MyController {

    @GetMapping
    public String home(Model theModel) {
        theModel.addAttribute("league", new League());
        return "index";
    }

    @PostMapping("/success")
    public String processForm(@ModelAttribute("league") League theLeague) {
        return "success";
    }
}
