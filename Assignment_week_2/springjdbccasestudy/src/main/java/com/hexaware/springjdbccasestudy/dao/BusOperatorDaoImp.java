package com.hexaware.springjdbccasestudy.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hexaware.springjdbccasestudy.model.BusOperator;

@Repository
public class BusOperatorDaoImp implements IBusOperatorDao {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BusOperatorDaoImp(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
		
		System.out.println(jdbcTemplate);
	}
	@Override
	public boolean createBusOp(BusOperator busOperator) {
		String insert = "insert into BusOperator(OperatorUsername, OperatorPassword, OperatorName, Email, PhoneNumber, RegistrationDate) "
				+ "values (?, ?, ?, ?, ?, now())";
		
		int count = jdbcTemplate.update(insert, busOperator.getOperatorUserName(), busOperator.getOperatorPassword(), busOperator.getName(), busOperator.getEmail(), busOperator.getPhoneNumber());
		
		return count > 0;
	}

	@Override
	public boolean updateBusOp(BusOperator busOperator) {
		String update = "update BusOperator set OperatorName = ? where OperatorUsername = ?";
		
		int count = jdbcTemplate.update(update, busOperator.getName(), busOperator.getOperatorUserName());
		
		return count > 0;
	}

	@Override
	public boolean deleteBusOpByUsername(String username) {
		String delete = "delete from BusOperator where OperatorUsername = ?";
		
		int count = jdbcTemplate.update(delete, username);
		return count > 0;
	}

	@Override
	public BusOperator selectBusOperatorByName(String name) {
		String selectByName = "select OperatorId, OperatorUsername, OperatorName, Email, PhoneNumber, RegistrationDate from BusOperator where OperatorName = ?";
		
		BusOperator busOperator = jdbcTemplate.queryForObject(selectByName, new BusOperatorMapper(), name);
		return busOperator;
	}

	@Override
	public List<BusOperator> selectAllBusOperators() {
		String selectAll = "Select * from BusOperator";
		
		List<BusOperator> list = jdbcTemplate.query(selectAll, new BusOperatorMapper());
		return list;
	}

}
