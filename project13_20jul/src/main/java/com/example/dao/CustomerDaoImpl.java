package com.example.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Customer;

@Repository
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	private final EntityManager entityManager;

	public CustomerDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query=entityManager.createQuery("FROM Customer C",Customer.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		 entityManager.persist(customer);
	}
	
	@Override
	@Transactional
	public Customer findCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		return entityManager.merge(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		entityManager.remove(customer);
	}

}
