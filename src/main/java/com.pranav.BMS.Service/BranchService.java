package com.pranav.BMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.BranchDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Branch;

@Service
public class BranchService {
	@Autowired
	private BranchDAO branchDAO;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		Branch data = branchDAO.saveBranch(branch);
		ResponseStructure<Branch> rs = new ResponseStructure<Branch>();
		rs.setData(data);
		rs.setMessage("Branch added successfully");
		rs.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.CREATED);
	}
}
