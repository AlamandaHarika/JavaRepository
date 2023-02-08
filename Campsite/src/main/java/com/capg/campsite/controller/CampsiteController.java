package com.capg.campsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.campsite.entity.Campsite;
import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.service.CampsiteService;

@RestController
@RequestMapping("/compsite")
public class CampsiteController {

	@Autowired
	private CampsiteService campsiteService;

	@PostMapping("/add-campsite")
	public ResponseEntity<?> addCampsite(@RequestBody Campsite campsite) throws Exception {
		return new ResponseEntity<Campsite>(campsiteService.addCampsite(campsite), HttpStatus.CREATED);
	}

	@PutMapping("/update-campsite")
	public ResponseEntity<?> updateCampsite(@RequestBody Campsite campsite) throws ResourceNotFoundException {

		return ResponseEntity.ok(campsiteService.updateCampsite(campsite));
	}

	@GetMapping("/get-campsite-by-id/{siteId}")
	public ResponseEntity<?> getCampsiteById(@PathVariable int siteId) throws ResourceNotFoundException {
		return ResponseEntity.ok(campsiteService.getCampsite(siteId));
	}

	@GetMapping("/get-all-campsite")
	public ResponseEntity<?> getAllCampsite() throws ResourceNotFoundException {

		return ResponseEntity.ok(campsiteService.getCampsiteDetails());
	}

}
