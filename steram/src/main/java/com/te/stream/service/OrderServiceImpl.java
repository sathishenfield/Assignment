package com.te.stream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.stream.entity.Order;
import com.te.stream.repository.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	private OrderDAO orderDAO;

	@Override
	public Order registerOrder(Order order) {
		
		return orderDAO.save(order);
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return orderDAO.findAll();
	}

}
