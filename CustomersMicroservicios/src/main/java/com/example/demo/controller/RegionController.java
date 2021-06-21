package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {

	@Autowired
	RegionService regionService;
	
	@PostMapping
	public ResponseEntity<Region> createRegion(@RequestBody Region obj) {
		Region region = regionService.create(obj);
		if(region != null) {
			return ResponseEntity.ok(region);
		}else {
			return ResponseEntity.badRequest().build();
		}
		
	}
}
