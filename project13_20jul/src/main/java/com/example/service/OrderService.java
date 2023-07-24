package com.example.service;

import java.util.List;
import com.example.model.Order;

public interface OrderService {
	public List<Order> getAllOrders();
	public void saveOrder(Order order);
	public Order findOrderById(int order_id);
	public Order updateOrder(Order order);
	public void deleteOrder(Order order);

}
