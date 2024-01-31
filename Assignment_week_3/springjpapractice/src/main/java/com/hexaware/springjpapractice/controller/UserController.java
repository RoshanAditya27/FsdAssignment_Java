package com.hexaware.springjpapractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springjpapractice.entity.User;
import com.hexaware.springjpapractice.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	IUserService service;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	@GetMapping("/getall")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteUserById(id);
	}
	
	@DeleteMapping("/delete/{username}")
	public String deleteByUsername(@PathVariable String username) {
		int count = service.deleteByUsername(username);
		
		return count + " record deleted";
	}
}
