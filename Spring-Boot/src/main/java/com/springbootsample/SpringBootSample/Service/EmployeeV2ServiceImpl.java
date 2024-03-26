package com.springbootsample.SpringBootSample.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.crypto.ExemptionMechanism;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootsample.SpringBootSample.Entity.EmployeeEnitity;
import com.springbootsample.SpringBootSample.Model.Employee;
import com.springbootsample.SpringBootSample.Respository.EmployeeRespository;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

	
	 
	
	@Autowired
	private EmployeeRespository employeeRespository;
	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		
		if(emp.getId()==null)
		{
			emp.setId(String.valueOf(Math.random()*100));
		}
		
		EmployeeEnitity employeeEnitity = new EmployeeEnitity();
		BeanUtils.copyProperties(emp, employeeEnitity);
		employeeRespository.save(employeeEnitity);
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		
		List<EmployeeEnitity> EmployeeList = employeeRespository.findAll();
		return EmployeeList.stream()
				.map(employeeEnitity -> {
					Employee employee = new Employee();
					BeanUtils.copyProperties(employeeEnitity, employee);
					return employee;
				})
				.collect(Collectors.toList());
	}

	@Override
	public Employee get(String id) {
		// TODO Auto-generated method stub
		
		EmployeeEnitity employeeEnitity = employeeRespository.findById(id).get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeEnitity, employee);
		return employee;
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		
		employeeRespository.deleteById(id);
		return "Employee with " +id+ " has been succesfully deleted";
	}

}
