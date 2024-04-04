package com.springboot.PaymentService.service;

import com.springboot.PaymentService.model.PaymentRequest;
import com.springboot.PaymentService.model.PaymentResponse;

public interface PaymentService {

	Long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPayment(Long orderId);

}
