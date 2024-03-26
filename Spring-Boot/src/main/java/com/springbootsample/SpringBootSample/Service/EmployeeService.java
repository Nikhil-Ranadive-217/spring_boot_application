package com.springbootsample.SpringBootSample.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootsample.SpringBootSample.Model.Employee;

public interface EmployeeService {
	
	public Employee save(Employee emp);

	public List<Employee> getAll();

	public Employee get(String id);

	public String delete(String id);

}
