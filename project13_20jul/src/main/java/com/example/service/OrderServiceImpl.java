package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.OrderDao;
import com.example.model.Order;

@Service
public class OrderServiceImpl implements OrderService{
	
	private final OrderDao orderDao;
	
	public OrderServiceImpl(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}
	
	@Override
	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
	}
	
	@Override
	public Order findOrderById(int order_id) {
		return orderDao.findOrderById(order_id);
	}

	@Override
	public Order updateOrder(Order order) {
		return orderDao.updateOrder(order);
	}

	@Override
	public void deleteOrder(Order order) {
		orderDao.deleteOrder(order);
		
	}

}
