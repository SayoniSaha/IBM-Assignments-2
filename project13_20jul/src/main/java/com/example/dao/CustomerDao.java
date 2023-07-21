package com.example.dao;

import java.util.List;
import com.example.model.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers();
	public void saveCustomer(Customer customer);
	public Customer findCustomerById(int customerId);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);

}
