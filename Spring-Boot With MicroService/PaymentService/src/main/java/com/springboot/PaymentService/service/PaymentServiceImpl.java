package com.springboot.PaymentService.service;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.PaymentService.entity.TransactionDetails;
import com.springboot.PaymentService.exception.PaymentServiceCustomException;
import com.springboot.PaymentService.model.PaymentMode;
import com.springboot.PaymentService.model.PaymentRequest;
import com.springboot.PaymentService.model.PaymentResponse;
import com.springboot.PaymentService.repository.TransactionalDetailsRepository;

import jakarta.persistence.EnumType;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private TransactionalDetailsRepository transactionDetailsRepository;

	@Override
	public Long doPayment(PaymentRequest paymentRequest) {
		// TODO Auto-generated method stub
		log.info("Doing payment....{}",paymentRequest);
		TransactionDetails transactionDetails = new TransactionDetails()
												.builder()
												.orderId(paymentRequest.getOrderId())
												.referenceNumber(paymentRequest.getReferenceNumber())
												.paymentDate(Instant.now())
												.paymentMode(paymentRequest.getPaymentMode().name())
												.paymentStatus("Success")
												.amount(paymentRequest.getAmount())
												.build();
		
		transactionDetailsRepository.save(transactionDetails);
		
		log.info("Payment Done...{}",transactionDetails.getId());
		return transactionDetails.getId();
	}

	@Override
	public PaymentResponse getPayment(Long orderId) {
		log.info("Getting Payment Details for OderID  {}",orderId);
		
		TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(orderId);
												
												
		PaymentResponse paymentResponse = new PaymentResponse()
										.builder()
										.orderId(transactionDetails.getOrderId())
										.amount(transactionDetails.getAmount())
										.paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
										.paymentDate(transactionDetails.getPaymentDate())
										.status(transactionDetails.getPaymentStatus())
										.build();
		
		
		return paymentResponse;
	}

}
