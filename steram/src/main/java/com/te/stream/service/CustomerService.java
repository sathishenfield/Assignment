package com.te.stream.service;

import java.util.List;

import com.te.stream.entity.Customer;
import com.te.stream.repository.CustomerDAO;

public interface CustomerService {
	
     public Customer registerCustomer(Customer customer);
     
     public List<Customer> getAll();

}
