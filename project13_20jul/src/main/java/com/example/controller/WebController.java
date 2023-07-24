package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Customer;
import com.example.model.Order;
import com.example.service.CustomerService;
import com.example.service.OrderService;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/customer")
public class WebController {

	private CustomerService customerService;
	private OrderService orderService;

	public WebController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/index")
	public String showHome(Model theModel) {
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
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		theCustomer.setCustomerId(new Random().nextInt(10000));
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/searchCustomer")
    public String searchCustomer(@RequestParam("customerId") int customerId, Model theModel) {
        Customer customer = customerService.findCustomerById(customerId);
        theModel.addAttribute("customer", customer);
        return "customerSearchResult";
    }
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId,Model theModel) {
		Customer customer=customerService.findCustomerById(customerId);
		theModel.addAttribute("customer",customer);
		return "customerUpdateForm";
	}
	
	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.updateCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId,@ModelAttribute("customer") Customer theCustomer) {
		theCustomer = customerService.findCustomerById(customerId);
		customerService.deleteCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
}
