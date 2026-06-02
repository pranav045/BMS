package com.pranav.BMS.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pranav.BMS.DTO.ResponseStructure;

public class BranchExceptionHandler {
	@ExceptionHandler(IdDoesNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> catchException(IdDoesNotPresentException exception) {
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setData(exception.getMessage());
		rs.setMessage("Branch not found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NOT_FOUND);
	}
}
