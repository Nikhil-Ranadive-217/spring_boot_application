package com.springBoot.OrderService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springBoot.OrderService.entity.Order;
import com.springBoot.OrderService.exception.OrderCustomException;
import com.springBoot.OrderService.external.client.PaymentService;
import com.springBoot.OrderService.external.client.ProductService;
import com.springBoot.OrderService.external.request.PaymentRequest;
import com.springBoot.OrderService.model.OrderRequest;
import com.springBoot.OrderService.model.OrderResponse;
import com.springBoot.OrderService.model.OrderResponse.ProductDetails;
import com.springBoot.OrderService.model.PaymentResponse;
import com.springBoot.OrderService.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Long placeOrder(OrderRequest orderrequest) {
		
		log.info("Placing Order...");
		// TODO Auto-generated method stub
		
		log.info("Reducing Quantity...");
		
		productService.reduceQuantity(orderrequest.getProductId(), orderrequest.getQuantity());
		
		log.info(" Quantity Reduced...");
		Order order = new Order()
					.builder()
					.quantity(orderrequest.getQuantity())
					.amount(orderrequest.getTotalAmount())
					.productId(orderrequest.getProductId())
					.orderStatus("CREATED")
					.orderDate(Instant.now())
					.build();
		
		orderRepository.save(order);
		
		log.info("Order Placed....");
		
		log.info("Doing Payment....");
		PaymentRequest paymentRequest = new PaymentRequest()
										.builder()
										.amount(order.getAmount())
										.orderId(order.getId())
										.paymentMode(orderrequest.getPaymentmode())
										.build();
		
		String Orderstatus=null;
		
		try {
		paymentService.doPayment(paymentRequest);
		log.info("Payment successfully Order Placed");
		Orderstatus="PLACED";
		}
		catch(Exception e) {
			log.error("Error occured during payment order placed failed");
			Orderstatus="PAYMENT_FAILED";
		}
		log.info("Payment Done...");
		order.setOrderStatus(Orderstatus);
		orderRepository.save(order);
		return order.getId();
	}

	@Override
	public OrderResponse getOrderDetails(long orderId) {
		// TODO Auto-generated method stub
		log.info("get Order details for {}",orderId);
		
		log.info("Fetching Order details");
		Order order = orderRepository.findById(orderId)
				.orElseThrow(()-> new OrderCustomException("Order not found for the orderId "+orderId,"NOT_FOUND",404));
		
		log.info("Invoking fetch Product details from Product Service for order id {}",orderId);
		
		ProductDetails productDetails = restTemplate.getForObject("http://ProductService/product/get/"+order.getProductId(),ProductDetails.class);
		
		OrderResponse.ProductDetails productDetails1 = new ProductDetails()
														.builder()
														.productId(productDetails.getProductId())
														.productname(productDetails.getProductname())
														.productprice(productDetails.getProductprice())
														.productquantity(productDetails.getProductquantity())
														.build();
		log.info("Fetching Payment details from payment service for {}",orderId);
		
		PaymentResponse paymentResponse = restTemplate.getForObject("http://PaymentService/payment/getpayment/"+order.getId(), PaymentResponse.class);
		
		
		
		OrderResponse orderResponse = new OrderResponse()
										.builder()
										.orderId(order.getId())
										.orderDate(order.getOrderDate())
										.amount(order.getAmount())
										.orderstatus(order.getOrderStatus())
										.productDetails(productDetails1)
										.paymentResponse(paymentResponse)
										.quantity(order.getQuantity())
										.build();
		
		return orderResponse;
	}
}
