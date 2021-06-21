package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Region;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public abstract List<Customer> findByRegion(Region region);

	@Query(value = "select * from tb_customer c where c.id = :id", nativeQuery = true)
	public Customer findCustomerId(@Param("id") Long id);
}
