package com.springbootsample.SpringBootSample.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootsample.SpringBootSample.Error.EmployeeNotFoundException;
import com.springbootsample.SpringBootSample.Model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	
    List<Employee> EmployeeList = new ArrayList<Employee>();
	@Override
	public Employee save(Employee emp) {
		
		if(emp.getId()==null)
		{
			emp.setId(String.valueOf(Math.random()*100));
		}
		
		EmployeeList.add(emp);
		return emp;
	}
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return EmployeeList;
	}
	@Override
	public Employee get(String id) {
		// TODO Auto-generated method stub
		//Handle custom Error
		
		//return EmployeeList.stream().filter(Employee -> Employee.getId().equalsIgnoreCase(id)).findFirst().orElseThrow(()->new EmployeeNotFoundException("Employee not found with id "+id));
		//Handle Generic Error
		return EmployeeList.stream().filter(Employee -> Employee.getId().equalsIgnoreCase(id)).findFirst().orElseThrow(()->new RuntimeException("Employee not found with id "+id));
	}
	@Override
	public String delete(String id) {
		Employee employee = EmployeeList.stream().filter(Employee -> Employee.getId().contentEquals(id)).findFirst().get();
		boolean status=EmployeeList.remove(employee);

		if(status==true)
		{
		return "Employee with " +id+ " has been succesfully deleted";	
		}
		else
		{
			return "Employee not found";
		}
		
	}

}
