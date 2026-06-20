package com.pranav.BMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Branch;
import com.pranav.BMS.Service.BranchService;

@RestController
public class BranchController {
	@Autowired
	private BranchService branchService;

	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@GetMapping("/getBranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getBranch(@PathVariable String id) {
		return branchService.getBranch(id);
	}

	@GetMapping("/getAllBranches")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranches() {
		return branchService.getAllBranches();
	}
}
