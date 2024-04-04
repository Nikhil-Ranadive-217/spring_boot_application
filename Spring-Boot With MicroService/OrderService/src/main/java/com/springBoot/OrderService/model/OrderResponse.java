package com.springBoot.OrderService.model;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
	
	private long orderId;
	private Instant orderDate;
	private String orderstatus;
	private long amount;
	private long quantity;
	private ProductDetails productDetails;
	//@Autowired
	private PaymentResponse paymentResponse;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class ProductDetails{

			private long productId;
				
			private String productname;
				
			private long productprice;
			
			private long productquantity;
		
	}

}
