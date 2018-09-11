package com.sit.workshop.spring.jpa.apis.immigration.travellersearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.commons.CommonSearchResult;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearch;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearchCriteria;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.interfaces.TravellerSearchManager;

@RestController
@RequestMapping("api/immigration/travellerSearch")
public class TravellerSearchController {

	@Autowired
	private TravellerSearchManager manager;
	
	@PostMapping
	@Transactional(propagation = Propagation.REQUIRED)
	public ResponseEntity getTravellerSearch(@Validated @RequestBody TravellerSearchCriteria criteria
			, Errors errors) throws Exception {
		
		if (errors.hasErrors()) {
			ResponseEntity response = ResponseEntity.badRequest().body("Had Errors.");
			return response;
		}

		ResponseEntity response = null;
		CommonSearchResult<TravellerSearch> result = null;
		try {
			result = manager.getTravellerSearch(criteria);			
			response = ResponseEntity.ok(result);

		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}

}
