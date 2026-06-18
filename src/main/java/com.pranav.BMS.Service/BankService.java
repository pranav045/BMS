package com.pranav.BMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.BankDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Bank;
import com.pranav.BMS.Exception.EmptyException;
import com.pranav.BMS.Exception.IdDoesNotPresentException;

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

	public ResponseEntity<ResponseStructure<Bank>> getBank(String id) {
		Bank data = bankDAO.getBank(id);
		if (data != null) {
			ResponseStructure<Bank> rs = new ResponseStructure<Bank>();
			rs.setData(data);
			rs.setMessage("Bank id " + id + " found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Bank>>(rs, HttpStatus.FOUND);
		} else {
			throw new IdDoesNotPresentException("Account id " + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Bank>>> getAllBanks() {
		List<Bank> data = bankDAO.getAllBanks();
		if (data != null) {
			ResponseStructure<List<Bank>> rs = new ResponseStructure<List<Bank>>();
			rs.setData(data);
			rs.setMessage("All Banks found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Bank>>>(rs, HttpStatus.FOUND);
		} else {
			throw new EmptyException("No bank found");
		}
	}
}
