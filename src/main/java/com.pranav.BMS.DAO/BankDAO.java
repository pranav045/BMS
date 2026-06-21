package com.pranav.BMS.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranav.BMS.Entity.Bank;
import com.pranav.BMS.Repository.BankRepository;

@Repository
public class BankDAO {
	@Autowired
	private BankRepository bankRepository;

	public Bank saveBank(Bank bank) {
		return bankRepository.save(bank);
	}

	public Bank getBank(String id) {
		return bankRepository.findById(id).orElse(null);
	}

	public List<Bank> getAllBanks() {
		return bankRepository.findAll();
	}

	public Boolean deleteBank(String id) {
		if (bankRepository.existsById(id)) {
			bankRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
