package com.springbootsample.SpringBootSample.Model;

public class User {
	
	String Id;
	String Name;
	String Email;
	String status;
	
	public User()
	{
		
	}
	
	public User(String status)
	{
		this.status=status;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	

}
