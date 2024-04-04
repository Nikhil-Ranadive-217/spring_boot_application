package com.springBoot.OrderService.external.client.decoder;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBoot.OrderService.exception.OrderCustomException;
import com.springBoot.OrderService.external.client.response.ErrorResponse;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		// TODO Auto-generated method stub
		
		ObjectMapper objectMapper = new  ObjectMapper();
		
		log.info("::{}",response.request().url());
		log.info("::{}",response.request().headers());
		
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			
			return new OrderCustomException(errorResponse.getErrorMessage(),errorResponse.getErrorCode(),response.status());
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			throw new OrderCustomException("Internal Server Error ","INTERNAL_SERVER_ERROR",500); 
		}
		
		
	}

}
