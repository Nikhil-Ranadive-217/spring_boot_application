package com.springBoot.OrderService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springBoot.OrderService.external.client.response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandle extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(OrderCustomException.class)
	public ResponseEntity<ErrorResponse> handleOrderServiceException(OrderCustomException ex)
	{
		return new ResponseEntity<ErrorResponse>(new ErrorResponse()
												.builder()
												.errorMessage(ex.getMessage())
												.errorCode(ex.getErrorCode())
												.build(),HttpStatus.valueOf(ex.getStatus()));
		
	}
	
	

}
