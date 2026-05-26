package com.pranav.BMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.BMS.Entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, String> {

}
