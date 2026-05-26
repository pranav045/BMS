package com.pranav.BMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.BMS.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
