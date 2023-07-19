package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Employee;

@Controller
public class MyController {

	private DataSource dataSource;

	@Autowired
	public MyController(DataSource dataSource) {

		this.dataSource = dataSource;
	}
	
    @GetMapping
    public String goHome() {
        return "home";
    }

    @GetMapping("/showForm")
    public String showForm() {
        return "showForm";
    }

//    @PostMapping("/addEmployee")
//    public String addEmployee(HttpServletRequest request, Model model) {
//        String name = request.getParameter("t1");
//        String ageStr = request.getParameter("t2");
//
//        if (name.trim().isEmpty()) {
//            model.addAttribute("error", "Name cannot be empty");
//            return "showForm";
//        }
//        
//        if (ageStr.trim().isEmpty()) {
//            model.addAttribute("error", "Age cannot be empty");
//            return "showForm";
//        }
//
//        double age = Double.parseDouble(ageStr);
//        model.addAttribute("emp", new Employee(name, age));
//
//        return "success";
//    }
    
    
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestParam(name = "t1") String name, @RequestParam(name = "t2") String ageStr,
            Model theModel) {

        String error = "";

        if (name.trim().isEmpty()) {
            error = "Name cannot be empty";
        }

        if (ageStr.trim().isEmpty()) {
            error = "Age cannot be empty";
        } else {
            try {
                double age = Double.parseDouble(ageStr);
                if (age <= 0) {
                    error = "Age must have a positive value";
                }
            } catch (NumberFormatException e) {
                error = "Age must be a numeric";
            }
        }

        if (!error.isEmpty()) {
            theModel.addAttribute("error", error);
            return "showForm";
        }

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into employee(name, age) values(?, ?)");
            pstmt.setString(1, name);
            pstmt.setDouble(2, Double.parseDouble(ageStr));
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        theModel.addAttribute("emp", new Employee(name, Double.parseDouble(ageStr)));
        return "success";
    }

}

