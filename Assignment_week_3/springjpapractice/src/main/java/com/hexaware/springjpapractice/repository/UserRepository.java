package com.hexaware.springjpapractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.springjpapractice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findByUsername(String username);
	
	@Modifying
	@Query("delete from User u where u.username = ?1")
	int deleteByUsername(String username);
}
