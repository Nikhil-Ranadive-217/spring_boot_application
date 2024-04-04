package com.springBoot.OrderService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springBoot.OrderService.exception.OrderCustomException;
import com.springBoot.OrderService.external.request.PaymentRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@CircuitBreaker(name="external",fallbackMethod = "fallback")
@FeignClient(name = "PaymentService/payment")
public interface PaymentService {

	@PostMapping("/postPayment")
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);
	
	default void fallback(Exception e)
	{
		throw new OrderCustomException("Payment Service is Down!!!","UNAVAILABLE",500);
	}
}
