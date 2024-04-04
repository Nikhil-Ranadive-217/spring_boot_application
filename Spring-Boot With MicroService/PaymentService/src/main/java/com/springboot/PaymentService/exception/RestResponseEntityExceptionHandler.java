package com.springboot.PaymentService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.PaymentService.model.ErrorResponse;

public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(PaymentServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handlePaymentServiceException(PaymentServiceCustomException ex)
	{
		return new ResponseEntity<ErrorResponse>(new ErrorResponse()
												.builder()
												.errorMessage(ex.getMessage())
												.errorCode(ex.getErrorCode())
												.build(),HttpStatus.valueOf(ex.getStatus()));
	}

}
