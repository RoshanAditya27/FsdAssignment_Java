package com.hexaware.springjpapractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springjpapractice.entity.User;
import com.hexaware.springjpapractice.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImp implements IUserService {

	@Autowired
	UserRepository repo;
	
	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
		return repo.save(user);
	}

	@Override
	public User getUserById(int userId) {
		return repo.findById(userId).orElse(null);
	}

	@Override
	public String deleteUserById(int userId) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public List<User> getByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public int deleteByUsername(String username) {
		return repo.deleteByUsername(username);
	}

}
