package com.hexaware.springjdbccasestudy.dao;

import java.util.List;

import com.hexaware.springjdbccasestudy.model.BusOperator;

public interface IBusOperatorDao {
	public boolean createBusOp(BusOperator busOperator);
	public boolean updateBusOp(BusOperator busOperator);
	
	public boolean deleteBusOpByUsername(String Username);
	public BusOperator selectBusOperatorByName(String name);
	
	public List<BusOperator> selectAllBusOperators();
}
