package com.hexaware.springjpapractice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.springjpapractice.entity.User;

@Service
public interface IUserService {
	public User addUser(User user);

	public User updateUser(User user);

	public String deleteUserById(int userId);
	
	public  List<User>  getAllUsers();
	
	
	public  List<User>  getByUsername(String username);
	
	public int  deleteByUsername(String username);

	User getUserById(int userId);
}
