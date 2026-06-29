package com.pranav.BMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.BranchDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Branch;
import com.pranav.BMS.Exception.EmptyException;
import com.pranav.BMS.Exception.IdDoesNotPresentException;

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

	public ResponseEntity<ResponseStructure<Branch>> getBranch(String id) {
		Branch data = branchDAO.getBranch(id);
		if (data != null) {
			ResponseStructure<Branch> rs = new ResponseStructure<Branch>();
			rs.setData(data);
			rs.setMessage("Branch id " + id + " found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.FOUND);
		} else {
			throw new IdDoesNotPresentException("Branch id " + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranches() {
		List<Branch> data = branchDAO.getAllBranches();
		if (data != null) {
			ResponseStructure<List<Branch>> rs = new ResponseStructure<List<Branch>>();
			rs.setData(data);
			rs.setMessage("All Branches found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Branch>>>(rs, HttpStatus.FOUND);
		} else {
			throw new EmptyException("No branch found");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(String id) {
		Branch data = branchDAO.getBranch(id);
		if (data != null) {
			branchDAO.deleteBranch(id);
			ResponseStructure<Branch> rs = new ResponseStructure<Branch>();
			rs.setData(null);
			rs.setMessage("Branch having id " + id + " deleted successfully");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.ACCEPTED);
		} else {
			throw new IdDoesNotPresentException("Branch id " + id + " not found");
		}
	}
}
