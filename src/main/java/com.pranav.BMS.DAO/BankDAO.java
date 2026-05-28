package com.pranav.BMS.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranav.BMS.Entity.Account;
import com.pranav.BMS.Repository.AccountRepository;

@Repository
public class AccountDAO {
	@Autowired
	private AccountRepository accountRepository;

	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account getAccount(String id) {
		return accountRepository.findById(id).orElse(null);
	}
}
