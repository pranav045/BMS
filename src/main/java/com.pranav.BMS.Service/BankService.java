package com.pranav.BMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.BankDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Bank;

@Service
public class BankService {
	@Autowired
	private BankDAO bankDAO;

	public ResponseEntity<ResponseStructure<Bank>> saveBank(Bank bank) {
		Bank data = bankDAO.saveBank(bank);
		ResponseStructure<Bank> rs = new ResponseStructure<Bank>();
		rs.setData(data);
		rs.setMessage("Bank added successfully");
		rs.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Bank>>(rs, HttpStatus.CREATED);
	}
}
