package com.springBoot.OrderService.exception;

import lombok.Data;

@Data
public class OrderCustomException extends RuntimeException{
	
	private String errorCode;
	
	private int status;
	
	public OrderCustomException(String errorMessage,String errorCode,int status)
	{
		super(errorMessage);
		this.errorCode=errorCode;
		this.status=status;
	}

}
