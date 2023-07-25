package com.example.demo.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<String, Customer> customers;

    {
        customers = new HashMap<>();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        String customerId = UUID.randomUUID().toString();
        customer.setId(customerId);
        customers.put(customerId, customer);
        return customer;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        Collection<Customer> collection = customers.values();
        return collection;
    }

    @Override
    public Customer getCustomerById(String id) {
        return customers.get(id);
    }

    @Override
    public Customer updateCustomerById(String id, Customer customer) {
        Customer tempCustomer = customers.get(id);
        if (tempCustomer == null) {
            return null;
        } else {
            tempCustomer.setName(customer.getName());
            tempCustomer.setEmail(customer.getEmail());
            return tempCustomer;
        }
    }

    @Override
    public boolean deleteCustomerById(String id) {
        return customers.remove(id) != null;
    }
}
