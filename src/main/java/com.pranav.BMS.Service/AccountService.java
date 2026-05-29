package com.pranav.BMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.AccountDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Account;

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
}
