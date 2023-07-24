package com.example.model;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "orders")
public class Order {

	@Column(name = "order_name")
	private String order_name;
	@Column(name = "order_price")
	private String order_price;
	@Id
	@Column(name = "order_id")
	private int order_id;
	
	public Order() {
		super();
	}
	public Order(int order_id, String order_name, String order_price) {
		super();
		this.order_id = order_id;
		this.order_name = order_name;
		this.order_price = order_price;
	}
	
	
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	
}
