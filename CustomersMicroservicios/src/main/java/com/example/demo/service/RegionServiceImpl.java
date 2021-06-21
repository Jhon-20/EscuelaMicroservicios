package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService{

	@Autowired
	RegionRepository regionRepository;
	
	@Override
	public Region create(Region obj) {
		return regionRepository.save(obj);
	}

}
