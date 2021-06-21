package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Region;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> listAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createAndUpdateCustomer(Customer obj) {
		obj.setState("CREATED");
		return customerRepository.save(obj);
	}

	@Override
	public List<Customer> findByRegion(Region region) {	
		return customerRepository.findByRegion(region);
	}
	@Override
	public Customer deleteCustomer(Long id) {
		Customer customerDB = getCustomer(id);
		if(customerDB == null) {
			return null;
		}
		customerDB.setState("DELETED");
		return customerRepository.save(customerDB);
	}


	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public Customer findCustomer(Long id) {
	return customerRepository.findCustomerId(id);
	}


	
	


}
