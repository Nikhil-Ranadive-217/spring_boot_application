package com.springBoot.OrderService.service;

import com.springBoot.OrderService.model.OrderRequest;
import com.springBoot.OrderService.model.OrderResponse;

public interface OrderService {

	Long placeOrder(OrderRequest orderrequest);

	OrderResponse getOrderDetails(long orderId);

}
