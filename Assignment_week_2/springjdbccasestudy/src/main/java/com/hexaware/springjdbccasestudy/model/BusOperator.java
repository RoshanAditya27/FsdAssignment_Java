package com.hexaware.springjdbccasestudy.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class BusOperator {
	private String operatorUserName;
	private String operatorPassword;
	private String name;
	private String email;
	private String phoneNumber;
	private Date registrationDate;
	
	public BusOperator() {
		
	}

	public BusOperator(String operatorUserName, String operatorPassword, String name, String email, String phoneNumber,
			Date registrationDate) {
		super();
		this.operatorUserName = operatorUserName;
		this.operatorPassword = operatorPassword;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
	}

	public String getOperatorUserName() {
		return operatorUserName;
	}

	public void setOperatorUserName(String operatorUserName) {
		this.operatorUserName = operatorUserName;
	}

	public String getOperatorPassword() {
		return operatorPassword;
	}

	public void setOperatorPassword(String operatorPassword) {
		this.operatorPassword = operatorPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "BusOperator [operatorUserName=" + operatorUserName + ", operatorPassword=" + operatorPassword
				+ ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", registrationDate="
				+ registrationDate + "]";
	}
	
	
}
