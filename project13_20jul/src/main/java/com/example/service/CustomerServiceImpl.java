package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.CustomerDao;
import com.example.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerDao customerDao;
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}
	
	@Override
	public Customer findCustomerById(int customerId) {
		return customerDao.findCustomerById(customerId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
		
	}

}
