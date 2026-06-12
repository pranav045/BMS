package com.pranav.BMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.AccountDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Account;
import com.pranav.BMS.Exception.IdDoesNotPresentException;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;

	public ResponseEntity<ResponseStructure<Account>> saveAccount(Account account) {
		Account data = accountDAO.saveAccount(account);
		ResponseStructure<Account> rs = new ResponseStructure<Account>();
		rs.setData(data);
		rs.setMessage("Account created successfully");
		rs.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Account>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Account>> getAccount(String id) {
		Account data = accountDAO.getAccount(id);
		if (data != null) {
			ResponseStructure<Account> rs = new ResponseStructure<Account>();
			rs.setData(data);
			rs.setMessage("Account Id " + id + " found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Account>>(rs, HttpStatus.FOUND);
		} else {
			throw new IdDoesNotPresentException("Account having id " + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Account>>> getAllAccounts() {
		List<Account> data = accountDAO.getAllAccounts();
		ResponseStructure<List<Account>> rs = new ResponseStructure<List<Account>>();
		rs.setData(data);
		rs.setMessage("All accounts retrieved successfully");
		rs.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Account>>>(rs, HttpStatus.FOUND);
	}
}
