package com.hexaware.springjdbccasestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springjdbccasestudy.dao.IBusOperatorDao;
import com.hexaware.springjdbccasestudy.model.BusOperator;

@Service
public class BusOperatorServiceImp implements IBusOperatorService {
	
	@Autowired
	IBusOperatorDao dao;
	
	@Override
	public boolean createBusOp(BusOperator busOperator) {
		
		return dao.createBusOp(busOperator);
	}

	@Override
	public boolean updateBusOp(BusOperator busOperator) {
		
		return dao.updateBusOp(busOperator);
	}

	@Override
	public boolean deleteBusOpByUsername(String username) {
		
		return dao.deleteBusOpByUsername(username);
	}

	@Override
	public BusOperator selectBusOperatorByName(String name) {
		
		return dao.selectBusOperatorByName(name);
	}

	@Override
	public List<BusOperator> selectAllBusOperators() {
		
		return dao.selectAllBusOperators();
	}

}
