package com.hexaware.springjdbccasestudy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hexaware.springjdbccasestudy.model.BusOperator;

public class BusOperatorMapper implements RowMapper<BusOperator>{

	@Override
	public BusOperator mapRow(ResultSet rs, int rowNum) throws SQLException {
		BusOperator busOperator = new BusOperator();
		
		busOperator.setOperatorUserName(rs.getString("OperatorUsername"));
		busOperator.setOperatorPassword(rs.getString("OperatorPassword"));
		busOperator.setName(rs.getString("OperatorName"));
		busOperator.setEmail(rs.getString("Email"));
		busOperator.setPhoneNumber(rs.getString("PhoneNumber"));
		busOperator.setRegistrationDate(rs.getDate("RegistrationDate"));
		return busOperator;
	}

}
