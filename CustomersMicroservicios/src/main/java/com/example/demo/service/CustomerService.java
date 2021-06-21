package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Region;

public interface CustomerService {
	public abstract List<Customer> listAllCustomer();
	public abstract List<Customer> findByRegion(Region region);
	public abstract Customer getCustomer(Long id);
	public abstract Customer createAndUpdateCustomer(Customer obj);
	public abstract Customer findCustomer(Long id);
	public Customer deleteCustomer(Long id);
}
