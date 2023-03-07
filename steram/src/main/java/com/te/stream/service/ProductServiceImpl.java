package com.te.stream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.te.stream.entity.Product;
import com.te.stream.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired	
	private ProductDAO productDAO;

	@Override
	public Product registerProduct(Product product) {
		
		return productDAO.save(product);
	}

	@Override
	public List<Product> getAll() {
		
		return productDAO.findAll();
	}

	@Override
	public List<Product> findProductWithSorting(String field) {
		
		return productDAO.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	@Override
	public Page<Product> findProductWithPagination(Integer offset, Integer pagesize) {
	
		return productDAO.findAll(PageRequest.of(offset, pagesize));
	}
	
	@Override
	public Page<Product> findProdutWithPaginationAndSorting(Integer offset,Integer pagesize,String field){
		
		return productDAO.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(field)));
	}

}
