package com.springbootsample.SpringBootSample.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootsample.SpringBootSample.Entity.EmployeeEnitity;


@Repository
public interface EmployeeRespository extends JpaRepository<EmployeeEnitity, String> {

}
