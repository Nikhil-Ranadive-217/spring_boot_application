package com.springboot.ProductService.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ProductService.Entity.ProductEntity;
import com.springboot.ProductService.Exception.ProductCustomException;
import com.springboot.ProductService.Model.Product;
import com.springboot.ProductService.Model.ProductResponse;
import com.springboot.ProductService.Repository.ProductRepository;
import com.sun.tools.sjavac.Log;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Service
//Instead of @Log4j2 @Slf4j works
@Slf4j
//@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@SuppressWarnings("restriction")
	@Override
	public long addProduct(Product product) {
		// TODO Auto-generated method stub
		log.info("Added the product....");
		//Log.info("Added the product....");
		//ProductEntity productEntity = new ProductEntity();
		//BeanUtils.copyProperties(product, productEntity);
		
		
		//Sometimes lombok feature are not reflected 
		//we can refer this link https://stackoverflow.com/questions/35842751/lombok-not-working-with-sts
		ProductEntity productEntity = ProductEntity
										.builder()
										.productname(product.getName())
										.productprice(product.getPrice())
										.productquantity(product.getQuantity())
										.build();
		
		productRepository.save(productEntity);
		return productEntity.getProductId();
		
	}

	@Override
	public ProductResponse getProduct(long id) {
		// TODO Auto-generated method stub
		
		ProductEntity productEntity =productRepository.findById(id)
									.orElseThrow(()->new ProductCustomException("No Product with that id is not found ","PRODUCT_NOT_FOUND"));
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(productEntity, productResponse);
		return productResponse;
	}

	@Override
	public void reduceQuantity(Long productId, long quantity) {
		log.info("Reduce quantity {} for id {}",quantity,productId);
		ProductEntity productEntity = productRepository.findById(productId)
										.orElseThrow(()-> new ProductCustomException("product with id not found", "PRODUCT_NOT_FOUND"));
		
		if(productEntity.getProductquantity()< quantity)
		{
			throw new ProductCustomException("Product doesn't have sufficient quantity","INSUFFICIENT_QUANTITY");
		}
		productEntity.setProductquantity(productEntity.getProductquantity()-quantity);
		productRepository.save(productEntity);
		// TODO Auto-generated method stub
		log.info("Product quantity updated successfully");
		
	}

}
