package com.te.stream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.stream.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {

}
