package com.springboot.ProductService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ProductService.Entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

}
