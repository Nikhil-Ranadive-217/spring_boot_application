package com.springboot.PaymentService.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Transaction_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "order_Id")
	private long orderId;
	@Column(name = "payment_Mode")
	private String paymentMode;
	@Column(name = "reference_Number")
	private String referenceNumber;
	@Column(name = "payment_Date")
	private Instant paymentDate;
	@Column(name = "payment_Status")
	private String paymentStatus;
	@Column(name = "payment_Amount")
	private long amount;

}
