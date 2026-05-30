package com.pranav.BMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.LoanDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Loan;

@Service
public class LoanService {
	@Autowired
	private LoanDAO loanDAO;

	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan) {
		Loan data = loanDAO.saveLoan(loan);
		ResponseStructure<Loan> rs = new ResponseStructure<Loan>();
		rs.setData(data);
		rs.setMessage("Loan added successfully");
		rs.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Loan>>(rs, HttpStatus.CREATED);
	}
}
