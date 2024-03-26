package com.springbootsample.SpringBootSample.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//if we ant to ignore multiple properties in request and response at class  level
//@JsonIgnoreProperties({"lastName","firstName"})
public class Employee {
	String id;
	
	String firstName;
	
	String lastName;
	
	String emailId;
	
	
	//if we ant to ignore single properties in request and response at method level
	//@JsonIgnore
	String department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	

}
