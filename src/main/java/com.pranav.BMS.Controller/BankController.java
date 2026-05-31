package com.pranav.BMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Bank;
import com.pranav.BMS.Service.BankService;

@RestController
public class BankController {
	@Autowired
	private BankService bankService;

	@PostMapping("/saveBank")
	public ResponseEntity<ResponseStructure<Bank>> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}
}
