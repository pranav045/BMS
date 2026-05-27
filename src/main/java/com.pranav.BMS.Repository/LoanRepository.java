package com.pranav.BMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.BMS.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
