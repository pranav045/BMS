package com.pranav.BMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Account;
import com.pranav.BMS.Service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/saveAccount")
	public ResponseEntity<ResponseStructure<Account>> saveAccount(Account account) {
		return accountService.saveAccount(account);
	}
}
