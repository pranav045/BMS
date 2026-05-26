package com.pranav.BMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.BMS.Entity.Bank;

public interface BankRepository extends JpaRepository<Bank, String> {

}
