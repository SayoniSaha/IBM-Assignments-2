package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Order;
import com.example.service.OrderService;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@GetMapping("/list")
	public String listOrders(Model theModel) {

		List<Order> theOrders =null;
		theOrders=orderService.getAllOrders();
		theModel.addAttribute("orders", theOrders);
		return "orderList";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		
		Order order = new Order();
		
		theModel.addAttribute("order",order);
		return "orderForm";

	}
	
	@PostMapping("/save")
	public String saveOrder(@ModelAttribute("orders") Order theOrder) {
		orderService.saveOrder(theOrder);
		return "redirect:/order/list";
	}
	
	@GetMapping("/searchOrder")
    public String searchOrder(@RequestParam("order_id") int order_id, Model theModel) {
        Order order = orderService.findOrderById(order_id);
        theModel.addAttribute("order", order);
        return "orderSearchResult";
    }
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("order_id") int order_id,Model theModel) {
		Order order=orderService.findOrderById(order_id);
		theModel.addAttribute("order",order);
		return "orderUpdateForm";
	}
	
	@PostMapping("/update")
	public String updateOrder(@ModelAttribute("order") Order theOrder) {
		orderService.updateOrder(theOrder);
		return "redirect:/order/list";
	}
	
	@GetMapping("/deleteOrder")
	public String deleteOrder(@RequestParam("order_id") int order_id,@ModelAttribute("order") Order theOrder) {
		theOrder = orderService.findOrderById(order_id);
		orderService.deleteOrder(theOrder);
		return "redirect:/order/list";
	}
}
