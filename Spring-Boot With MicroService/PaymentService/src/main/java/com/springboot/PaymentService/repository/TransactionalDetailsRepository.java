package com.springboot.PaymentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.PaymentService.entity.TransactionDetails;

@Repository
public interface TransactionalDetailsRepository extends JpaRepository<TransactionDetails, Long> {
	
	TransactionDetails findByOrderId(long orderId);

}
