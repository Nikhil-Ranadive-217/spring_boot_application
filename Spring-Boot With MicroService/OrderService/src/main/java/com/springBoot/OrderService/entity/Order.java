package com.springBoot.OrderService.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "Product_Id")
	private long productId;
	
	@Column(name = "Product_Quantity")
	private long quantity;
	
	@Column(name = "Order_Timestamp")
	private Instant orderDate;
	
	@Column(name = "Order_Status")
	private String orderStatus;
	
	@Column(name = "Order_Amount")
	private long amount;
	
}
