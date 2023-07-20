package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Customer;
import com.example.service.CustomerService;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/customer")
public class WebController {

	private CustomerService customerService;

	public WebController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping
	public String showDate(Model theModel) {
		theModel.addAttribute("theDate", new Date());
		return "index";
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> theCustomers =null;
		theCustomers=customerService.getAllCustomers();
		theModel.addAttribute("customers", theCustomers);
		return "customerList";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		
		Customer customer = new Customer();
		
		theModel.addAttribute("customer",customer);
		return "customerForm";

	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		theCustomer.setCustomerId(new Random().nextInt(10000));
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
}
