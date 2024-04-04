package com.springboot.PaymentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.PaymentService.model.PaymentRequest;
import com.springboot.PaymentService.model.PaymentResponse;
import com.springboot.PaymentService.service.PaymentService;

import lombok.Getter;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/postPayment")
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest)
	{
		Long paymentId =  paymentService.doPayment(paymentRequest);
		return new ResponseEntity<Long>(paymentId, HttpStatus.OK);
		
	}

	@GetMapping("/getpayment/{orderid}")
	public ResponseEntity<PaymentResponse> getPayment(@PathVariable("orderid") Long orderId)
	{
		PaymentResponse paymentResponse = paymentService.getPayment(orderId);
		
		return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.OK);
	}
}
