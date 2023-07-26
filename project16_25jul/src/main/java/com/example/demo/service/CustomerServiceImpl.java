package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> listCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int employeeId) {
		Optional<Customer> empOptional = customerRepository.findById(employeeId);
		if (empOptional==null) {
			return null;
		} else {
			return empOptional;
		}
		
	}
	
	@Override
	public Customer updateCustomerById(Customer customer) {
		Optional<Customer> oCustomer = customerRepository.findById(customer.getCustomerId());

		if (oCustomer.isEmpty()) {
			return null;
		}
		else
		{
			oCustomer.get().setCustomerName(customer.getCustomerName());
			oCustomer.get().setEmail(customer.getEmail());
			
			customerRepository.save(oCustomer.get());
			return oCustomer.get();

		}
	}
	
	@Override
    public Optional<Customer> deleteCustomerById(int employeeId) {
		Optional<Customer> empOptional = customerRepository.findById(employeeId);
        if (empOptional.isPresent()) {
            customerRepository.deleteById(employeeId);
            return empOptional;
        } else {
            return Optional.empty();
        }
    }

}
