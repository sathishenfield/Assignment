package com.te.stream.service;

import java.util.List;

import com.te.stream.entity.Order;

public interface OrderService {
	
	public Order registerOrder(Order order);
	
	public List<Order> getAll();

}
