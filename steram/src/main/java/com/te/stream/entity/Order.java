package com.te.stream.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_order")
public class Order {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  private LocalDate orderDate;
	  private LocalDate deliveryDate;
	  private String status;
	  
	  @ManyToOne
	  @JoinColumn(name = "customer_id")
	  private Customer customer;
	  
	  @ManyToMany
	  @JoinTable(
	      name = "order_product_relationship",
	      joinColumns = { @JoinColumn(name = "order_id") },
	      inverseJoinColumns = { @JoinColumn(name = "product_id") }
	  )
	  @ToString.Exclude
	  List<Product> products;

}
