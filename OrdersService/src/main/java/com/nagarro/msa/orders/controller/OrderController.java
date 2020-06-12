package com.nagarro.msa.orders.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.orders.model.Order;
import com.nagarro.msa.orders.orderdto.OrderDto;
import com.nagarro.msa.orders.orderrepository.OrderRepository;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("")
	public List<Order> userList() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public HashMap<String, List<OrderDto>> retrieveProduct(@PathVariable Integer id) {
		List<Order> orders = orderRepository.findOrdersByUserId(id);
		HashMap<String, List<OrderDto>> map = new HashMap<>();
		List<OrderDto> orderDto = new ArrayList<OrderDto>();
		for(Order order: orders) {
			orderDto.add(new OrderDto(order.getOrderId(), order.getOrderAmount(), order.getOrderDate()));
		}
		map.put("orders" , orderDto);
		return map;
	}

}
