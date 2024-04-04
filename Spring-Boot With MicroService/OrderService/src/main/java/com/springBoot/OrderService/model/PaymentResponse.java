package com.springBoot.OrderService.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
	
	@JsonIgnore
	private long orderId;
	
	@JsonIgnore
	private long amount;
	
	private PaymentMode paymentMode; 
	
	private Instant paymentDate;
	
	private String status;

}
