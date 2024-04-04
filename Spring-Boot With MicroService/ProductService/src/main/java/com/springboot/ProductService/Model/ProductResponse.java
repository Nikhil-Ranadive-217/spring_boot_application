package com.springboot.ProductService.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

		private long productId;
			
		private String productname;
			
		private long productprice;
		
		private long productquantity;
	
}
