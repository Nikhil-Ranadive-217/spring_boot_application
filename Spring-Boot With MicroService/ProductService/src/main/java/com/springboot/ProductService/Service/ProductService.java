package com.springboot.ProductService.Service;

import com.springboot.ProductService.Model.Product;
import com.springboot.ProductService.Model.ProductResponse;

public interface ProductService {

	long addProduct(Product product);

	ProductResponse getProduct(long id);

	void reduceQuantity(Long productId, long quantity);

}
