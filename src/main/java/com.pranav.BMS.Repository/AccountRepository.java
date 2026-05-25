package com.pranav.BMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.BMS.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
