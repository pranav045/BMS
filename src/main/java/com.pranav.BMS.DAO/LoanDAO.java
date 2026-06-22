package com.pranav.BMS.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranav.BMS.Entity.Loan;
import com.pranav.BMS.Repository.LoanRepository;

@Repository
public class LoanDAO {
	@Autowired
	private LoanRepository loanRepository;

	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}

	public Loan getLoan(int id) {
		return loanRepository.findById(id).orElse(null);
	}

	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}

	public boolean deleteLoan(int id) {
		if (loanRepository.existsById(id)) {
			loanRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
