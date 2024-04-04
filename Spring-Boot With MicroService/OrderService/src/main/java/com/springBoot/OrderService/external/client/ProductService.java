package com.springBoot.OrderService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.OrderService.exception.OrderCustomException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@CircuitBreaker(name="external",fallbackMethod = "fallback")
@FeignClient(name = "ProductService/product")
public interface ProductService {

	@PutMapping("/reducequantity/{id}")
	ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId,@RequestParam long quantity);
	
	default void fallback(Exception e)
	{
		throw new OrderCustomException("Product Service is Down!!!","UNAVAILABLE",500);
	}
	
}
