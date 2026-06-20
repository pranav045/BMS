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
import com.pranav.BMS.Entity.Customer;
import com.pranav.BMS.Service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/getCustomer/{id")
	public ResponseEntity<ResponseStructure<Customer>> getCustomer(@PathVariable int id) {
		return customerService.getCustomer(id);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers() {
		return customerService.getAllCustomers();
	}
}
