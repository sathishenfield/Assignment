package com.te.stream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.stream.entity.Customer;
import com.te.stream.repository.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer registerCustomer(Customer customer) {
		
		return customerDAO.save(customer);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerDAO.findAll();
	}

}
