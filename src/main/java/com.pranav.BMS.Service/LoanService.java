package com.pranav.BMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.LoanDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Loan;
import com.pranav.BMS.Exception.IdDoesNotPresentException;

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

	public ResponseEntity<ResponseStructure<Loan>> getLoan(int id) {
		Loan data = loanDAO.getLoan(id);
		if (data != null) {
			ResponseStructure<Loan> rs = new ResponseStructure<Loan>();
			rs.setData(data);
			rs.setMessage("Loan id " + id + " found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Loan>>(rs, HttpStatus.FOUND);
		} else {
			throw new IdDoesNotPresentException("Loan id " + id + " not found");
		}
	}
}
