package com.example.demo.rest;

import java.util.Collection;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.http.MediaType;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping(produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customer.setId(UUID.randomUUID().toString());
		return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Collection<Customer>> getAllCustomers() {
		return new ResponseEntity<Collection<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id")String id) {
		Customer customer=customerService.getCustomerById(id);
		if(customer==null) {
			return new ResponseEntity<String>("customer with "+ id +" not found ",HttpStatus.NOT_FOUND);
		}
		
		else {
			return new ResponseEntity<Customer>(customer,HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomerById(@PathVariable("id") String id, @RequestBody Customer customer) {
	    Customer updatedCustomer = customerService.updateCustomerById(id, customer);
	    if (updatedCustomer == null) {
	        return new ResponseEntity<String>("Customer with " + id + " not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") String id) {
	    boolean isDeleted = customerService.deleteCustomerById(id);
	    if (isDeleted) {
	        return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<String>("Customer with ID " + id + " not found.", HttpStatus.NOT_FOUND);
	    }
	}

}
