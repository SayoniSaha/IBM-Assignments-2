package com.example.demo.repo;

import java.util.Collection;

import com.example.demo.model.Customer;

public interface CustomerRepository {

	Customer createCustomer(Customer customer);
	Collection<Customer> getAllCustomers();
	Customer getCustomerById(String customerId);
	Customer updateCustomerById(String customerId, Customer customer);
	boolean deleteCustomerById(String customerId);

}
