package com.springboot.PaymentService.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
	
	private long orderId;
	
	private long amount;
	
	private PaymentMode paymentMode;
	
	private Instant paymentDate;
	
	private String status;

}
