package com.springbootsample.SpringBootSample.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsample.SpringBootSample.Model.Employee;
import com.springbootsample.SpringBootSample.Service.EmployeeService;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {
	
	
	@Autowired
	@Qualifier("employeeV2ServiceImpl")
	private EmployeeService employeeService;
	
	@PostMapping("/Save")
	public Employee SaveEmployee(@RequestBody Employee emp)
	{	
	return employeeService.save(emp);
	}
	
	@GetMapping("/GetAll")
	public List<Employee> GetAllEmployeeList()
	{	
	return employeeService.getAll();
	}
	
	@GetMapping("/Get/{id}")
	public Employee GetEmployeeByID(@PathVariable String id)
	{
		return employeeService.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id)
	{
		return employeeService.delete(id);
	}

}
