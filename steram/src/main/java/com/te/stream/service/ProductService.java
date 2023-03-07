package com.te.stream.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.te.stream.entity.Product;

public interface ProductService {
	
	public Product registerProduct(Product product);
	
	public List<Product> getAll();
	
	public List<Product> findProductWithSorting(String field);
	
	public Page<Product> findProductWithPagination(Integer offset,Integer pagesize);
	
	public Page<Product> findProdutWithPaginationAndSorting(Integer offset,Integer pagesize,String field);

}
