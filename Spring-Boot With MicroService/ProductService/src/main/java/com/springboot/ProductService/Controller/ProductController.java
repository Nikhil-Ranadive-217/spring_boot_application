package com.springboot.ProductService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ProductService.Model.Product;
import com.springboot.ProductService.Model.ProductResponse;
import com.springboot.ProductService.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("save")
	public ResponseEntity<Long> addProduct(@RequestBody Product product) 
	{
		long productId = productService.addProduct(product);
		return new ResponseEntity<>(productId,HttpStatus.CREATED);
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable long id)
	{
		ProductResponse productResponse = productService.getProduct(id);
		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
	}
	
	@PutMapping("/reducequantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId,@RequestParam long quantity){
		productService.reduceQuantity(productId,quantity);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

	
}
