package com.example.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Order;

@Repository
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {

	private final EntityManager entityManager2;

	public OrderDaoImpl(EntityManager entityManager2) {
		super();
		this.entityManager2 = entityManager2;
	}

	@Override
	@Transactional
	public List<Order> getAllOrders() {
		TypedQuery<Order> query=entityManager2.createQuery("FROM Order O",Order.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void saveOrder(Order order) {
		 entityManager2.persist(order);
	}
	
	@Override
	@Transactional
	public Order findOrderById(int order_id) {
		return entityManager2.find(Order.class, order_id);
	}

	@Override
	@Transactional
	public Order updateOrder(Order order) {
		return entityManager2.merge(order);
	}

	@Override
	@Transactional
	public void deleteOrder(Order order) {
		entityManager2.remove(order);
	}

}
