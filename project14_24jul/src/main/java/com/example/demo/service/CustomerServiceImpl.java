package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.createCustomer(customer);
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}
	
	@Override
	public Customer getCustomerById(String customerId) {
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public Customer updateCustomerById(String customerId, Customer customer) {
		return customerRepository.updateCustomerById(customerId, customer);
	}

	@Override
	public boolean deleteCustomerById(String customerId) {
		return customerRepository.deleteCustomerById(customerId);

	}

}
