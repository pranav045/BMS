package com.pranav.BMS.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranav.BMS.Entity.Branch;
import com.pranav.BMS.Repository.BranchRepository;

@Repository
public class BranchDAO {
	@Autowired
	private BranchRepository branchRepository;

	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch getBranch(String id) {
		return branchRepository.findById(id).orElse(null);
	}

	public List<Branch> getAllBranches() {
		return branchRepository.findAll();
	}

	public Boolean deleteBranch(String id) {
		if (branchRepository.existsById(id)) {
			branchRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
