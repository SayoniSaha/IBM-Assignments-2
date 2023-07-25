package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);
	Collection<Customer> getAllCustomers();
	Customer getCustomerById(String customerId);
	Customer updateCustomerById(String customerId, Customer customer);
	boolean deleteCustomerById(String customerId);
	
}
