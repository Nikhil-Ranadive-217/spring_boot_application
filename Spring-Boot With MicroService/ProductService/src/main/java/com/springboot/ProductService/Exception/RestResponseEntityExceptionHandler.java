package com.springboot.ProductService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.ProductService.Model.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProductCustomException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductCustomException ex)
	{
		return new ResponseEntity<ErrorResponse>(new ErrorResponse()
												.builder()
												.errorCode(ex.getErrorCode())
												.errorMessage(ex.getMessage())
												.build()
												,HttpStatus.NOT_FOUND);
	}

}
