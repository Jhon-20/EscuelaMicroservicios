package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "tb_customer")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numberId", nullable = true, length = 8)
	private String numberId;
	
	@Column(name = "firstName", nullable = true, length = 40)
	private String firstName;
	
	@Column(name = "lastName", nullable = true, length = 40)
	private String lastName;
	
	@Column(name = "email", nullable = true, length = 25)
	private String email;
	
	@Column(name = "phtoUrl", nullable = true, length = 8)
	private String phtoUrl;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRegion")
	private Region region;
	
	@Column(name = "state", nullable = true, length = 10)
	private String state;
	
	
}
