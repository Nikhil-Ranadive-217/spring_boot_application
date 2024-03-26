package com.springbootsample.SpringBootSample.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsample.SpringBootSample.Model.User;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "Hello Nkhil!!";
	}
	
	@GetMapping("/User")
	public User getUser()
	{
		User user = new User();
		user.setId("15827");
		user.setName("Nikhil");
		user.setEmail("Nikhil.r.217@gmail.com");
		
		return user;
	}
	
	@GetMapping("/User/{id}/{Username}")
	public User getUser(@PathVariable String id,@PathVariable("Username") String name)
	{
		
		User user = new User();
		user.setId("15827");
		user.setName("Nikhil");
		user.setEmail("Nikhil.r.217@gmail.com");
		user.setStatus(HttpStatus.OK.toString());
		
		if(id.equalsIgnoreCase(user.getId()))
		{
		return user;
		}
		return new User(HttpStatus.NOT_FOUND.toString());
	}
	
	@GetMapping("/Userparam")
	public String getUserParam(@RequestParam(name = "Name",required = false,defaultValue = "Nikhil") String UserName)
	{
	
		return "Hello " + UserName + " Greeting from us";
	}

}
