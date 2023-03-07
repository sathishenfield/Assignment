package com.te.stream.controller;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.stream.entity.Customer;
import com.te.stream.entity.Order;
import com.te.stream.entity.Product;
import com.te.stream.response.SuccessResponse;
import com.te.stream.service.CustomerService;
import com.te.stream.service.OrderService;
import com.te.stream.service.ProductService;

@RestController
public class Controller {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@PostMapping("/registerCustomer")
	public ResponseEntity<SuccessResponse> registerCustomer(@RequestBody Customer customer) {

		Customer registerCustomer = customerService.registerCustomer(customer);
		if (registerCustomer != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).data(registerCustomer).msg("Customer registered").build(),
					HttpStatus.OK);

		} else {

			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).data(registerCustomer).msg("Customer not registered").build(),
					HttpStatus.BAD_REQUEST);

		}

	}

	@PostMapping("/registerProduct")
	public ResponseEntity<SuccessResponse> registerProduct(@RequestBody Product product) {

		Product registerProduct = productService.registerProduct(product);
		if (registerProduct != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).data(registerProduct).msg("Product registered").build(),
					HttpStatus.OK);

		} else {

			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).data(registerProduct).msg("product not registered").build(),
					HttpStatus.BAD_REQUEST);

		}

	}

	@PostMapping("/registerOrder")
	public ResponseEntity<SuccessResponse> registerOrder(@RequestBody Order order) {

		Order registerOrder = orderService.registerOrder(order);
		if (registerOrder != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).data(registerOrder).msg("Order registered").build(),
					HttpStatus.OK);

		} else {

			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).data(registerOrder).msg("order not registered").build(),
					HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/findproductwithsorting")
	public ResponseEntity<SuccessResponse> findProductWithSorting(String filed) {
		List<Product> findProductWithSorting = productService.findProductWithSorting(filed);
		if (!findProductWithSorting.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().count(findProductWithSorting.size()).error(false).msg("sorted").
					t(findProductWithSorting).build(),HttpStatus.OK);
					
		} else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().count(findProductWithSorting.size())
					.error(true).msg("Not sorted").build(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findproductwithpagination")
	public ResponseEntity<SuccessResponse> findProductWithpagination(Integer offset, Integer pagesize) {
		Page<Product> findProductWithPagination = productService.findProductWithPagination(offset, pagesize);
		if (!findProductWithPagination.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).msg("pagination").count(findProductWithPagination.getSize()).t(findProductWithPagination).build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder()
					.error(true).msg("Not pagination").build(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findproductwithpaginationandsorting")
	public ResponseEntity<SuccessResponse> findProductWithpaginationAndSorting(Integer offset, Integer pagesize,String field) {
		Page<Product> findProdutWithPaginationAndSorting = productService.findProdutWithPaginationAndSorting(offset, pagesize,field);
		if (!findProdutWithPaginationAndSorting.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).msg("pagination").count(findProdutWithPaginationAndSorting.getSize()).t(findProdutWithPaginationAndSorting).build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder()
					.error(true).msg("Not pagination").build(), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/bookgreaterthanhundred")
	public ResponseEntity<SuccessResponse> getBooksGreaterThanHundred() {
		List<Product> all = productService.getAll();
		List<Product> collect = all.stream().filter(i -> i.getCategory().equalsIgnoreCase("books"))
				.filter(i -> i.getPrice() > 100).collect(Collectors.toList());

		if (collect != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).list(collect).msg("sucess").build(), HttpStatus.OK);

		}

		else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).list(collect).msg("fail").build(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getbabyproduct")
	public ResponseEntity<SuccessResponse> getBabyProductFromOrder() {

		List<Order> all = orderService.getAll();
		List<Order> collect = all.stream()
				.filter(i -> i.getProducts().stream().anyMatch(j -> j.getCategory().equalsIgnoreCase("baby")))
				.collect(Collectors.toList());

		if (collect != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).list(collect).msg("sucess").build(), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).list(collect).msg("fail").build(), HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/gettoyswithdiscount ")
	public ResponseEntity<SuccessResponse> getToyswithDiscount() {
		List<Product> all = productService.getAll();
		List<Product> collect = all.stream().filter(i -> i.getCategory().equalsIgnoreCase("toys"))
				.map(j -> j.withPrice(j.getPrice() * 0.9)).collect(Collectors.toList());
		if (collect != null) {

			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).list(collect).msg("sucess").build(), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).list(collect).msg("fail").build(), HttpStatus.BAD_REQUEST);

		}

	}

	// Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021
	// and 01-Apr-2021
	@GetMapping("/getcustomertiertwo")
	public ResponseEntity<SuccessResponse> getcustomertier2() {
		List<Order> all = orderService.getAll();
		List<Order> collect = all.stream().filter(i -> i.getCustomer().getTier() == 2)
				.filter(i -> i.getOrderDate().compareTo(LocalDate.of(2021, 02, 01)) > 0)
				.filter(i -> i.getOrderDate().compareTo(LocalDate.of(2021, 04, 01)) < 0).collect(Collectors.toList());

		if (collect != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).list(collect).msg("sucess").build(), HttpStatus.OK);

		}

		else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).list(collect).msg("fail").build(), HttpStatus.BAD_REQUEST);

		}
	}

	// Exercise 5 — Get the cheapest products of “Books” category
	@GetMapping("/getCheapBooks")
	public ResponseEntity<SuccessResponse> getCheapestBooks() {
		List<Product> all = productService.getAll();
		Optional<Product> min = all.stream().filter(i -> i.getCategory().equalsIgnoreCase("books"))
				.min(Comparator.comparing(Product::getPrice));
		if (min != null) {

			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).data(min).msg("sucess").build(), HttpStatus.OK);

		}

		else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).data(min).msg("not").build(), HttpStatus.BAD_REQUEST);
		}
	}
}
