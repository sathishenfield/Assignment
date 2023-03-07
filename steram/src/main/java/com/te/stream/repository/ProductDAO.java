package com.te.stream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.stream.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {

}
