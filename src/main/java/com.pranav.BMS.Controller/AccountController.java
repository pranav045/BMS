package com.pranav.BMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Account;
import com.pranav.BMS.Service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/saveAccount")
	public ResponseEntity<ResponseStructure<Account>> saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}

	@GetMapping("/getAccount/{id}")
	public ResponseEntity<ResponseStructure<Account>> getAccount(@PathVariable String id) {
		return accountService.getAccount(id);
	}

	@GetMapping("/getAllAccounts")
	public ResponseEntity<ResponseStructure<List<Account>>> getAllAccounts() {
		return accountService.getAllAccounts();
	}
}
