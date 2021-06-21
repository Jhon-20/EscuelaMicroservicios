package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Region;
import com.example.demo.service.CustomerService;

@RestController()
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping
	public ResponseEntity<List<Customer>> listCustomer(@RequestParam(name="regionId", required = false) Long regionId) {
		List<Customer> customer = null;
		if(regionId == null) {
			customer = customerService.listAllCustomer();
			 if(customer.isEmpty()) {
					return ResponseEntity.notFound().build();
			 }
		}else {
			customer = customerService.findByRegion(Region.builder().idRegion(regionId).build());
			 if(customer.isEmpty()) {
					return ResponseEntity.notFound().build();
			}
		}

		return ResponseEntity.ok(customer);
	}

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> getProduct(@PathVariable("id") Long id) {
		Customer product =  customerService.getCustomer(id);
		if(product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	
	
	}
	
	@PostMapping
	public ResponseEntity<Customer> SaveCustomer(@RequestBody Customer obj){
		Customer customer = customerService.createAndUpdateCustomer(obj);
		if(customer != null) {
			return ResponseEntity.ok(customer);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id")Long id, @RequestBody Customer obj) {
		obj.setId(id);
		Customer productDB = customerService.createAndUpdateCustomer(obj);
		if(productDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productDB);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id")Long id) {
		
		Customer customer = customerService.deleteCustomer(id);
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);
	}
}
