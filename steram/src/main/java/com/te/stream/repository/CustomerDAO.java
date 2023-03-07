package com.te.stream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.stream.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{

}
