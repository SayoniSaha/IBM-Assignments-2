package com.example.dao;

import java.util.List;
import com.example.model.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers();
	public void saveCustomer(Customer customer);

}
