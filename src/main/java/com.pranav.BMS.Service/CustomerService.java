package com.pranav.BMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.BMS.DAO.CustomerDAO;
import com.pranav.BMS.DTO.ResponseStructure;
import com.pranav.BMS.Entity.Customer;
import com.pranav.BMS.Exception.EmptyException;
import com.pranav.BMS.Exception.IdDoesNotPresentException;

@Service
public class CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		Customer data = customerDAO.saveCustomer(customer);
		ResponseStructure<Customer> rs = new ResponseStructure<Customer>();
		rs.setData(data);
		rs.setMessage("Customer added successfully");
		rs.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Customer>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomer(int id) {
		Customer data = customerDAO.getCustomer(id);
		if (data != null) {
			ResponseStructure<Customer> rs = new ResponseStructure<Customer>();
			rs.setData(data);
			rs.setMessage("Customer id " + id + " found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Customer>>(rs, HttpStatus.FOUND);
		} else {
			throw new IdDoesNotPresentException("Customer id" + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers() {
		List<Customer> data = customerDAO.getAllCustomers();
		if (data != null) {
			ResponseStructure<List<Customer>> rs = new ResponseStructure<List<Customer>>();
			rs.setData(data);
			rs.setMessage("All Customers found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Customer>>>(rs, HttpStatus.FOUND);
		} else {
			throw new EmptyException("No Customer found");
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
		Customer data = customerDAO.getCustomer(id);
		if (data != null) {
			customerDAO.deleteCustomer(id);
			ResponseStructure<Customer> rs = new ResponseStructure<Customer>();
			rs.setData(null);
			rs.setMessage("Customer having id " + id + " deleted successfully");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Customer>>(rs, HttpStatus.ACCEPTED);
		} else {
			throw new IdDoesNotPresentException("Customer id " + id + " not found");
		}
	}
}
