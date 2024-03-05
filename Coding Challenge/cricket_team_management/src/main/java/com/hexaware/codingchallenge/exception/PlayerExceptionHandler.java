package com.hexaware.codingchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PlayerExceptionHandler { // Global exception handler
	
//	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Player Not Found in DB")
	@ExceptionHandler({PlayerNotFoundException.class})
	public ResponseEntity<String> handler() {
		return new ResponseEntity<>("Player not found in Db", HttpStatus.NOT_FOUND);
	}
}
