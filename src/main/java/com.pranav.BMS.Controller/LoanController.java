package com.pranav.BMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Loan;
import com.pranav.BMS.Service.LoanService;

@RestController
public class LoanController {
	@Autowired
	private LoanService loanService;

	@PostMapping("/saveLoan")
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(@RequestBody Loan loan) {
		return loanService.saveLoan(loan);
	}

	@GetMapping("/getLoan/{id}")
	public ResponseEntity<ResponseStructure<Loan>> getLoan(@PathVariable int id) {
		return loanService.getLoan(id);
	}
}
