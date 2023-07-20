package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "studentForm";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + ", Email:" + student.getEmail());

		return "studentConfirmation";
	}
}
