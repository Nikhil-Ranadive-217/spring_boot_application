package com.springBoot.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.OrderService.model.OrderRequest;
import com.springBoot.OrderService.model.OrderResponse;
import com.springBoot.OrderService.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeorder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderrequest)
	{
		Long productID = orderService.placeOrder(orderrequest);
		log.info("Order Place successfully "+productID);
		return new ResponseEntity<Long>(productID,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("orderId") long OrderId){
		
		OrderResponse orderResponse= orderService.getOrderDetails(OrderId);
		
		return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.OK);
		
	}

}
