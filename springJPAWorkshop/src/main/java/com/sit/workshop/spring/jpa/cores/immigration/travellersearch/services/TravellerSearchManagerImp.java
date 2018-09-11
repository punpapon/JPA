package com.sit.workshop.spring.jpa.cores.immigration.travellersearch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonSearchResult;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearch;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearchCriteria;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.interfaces.TravellerSearchManager;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.interfaces.TravellerSearchService;

@Component
@Transactional
public class TravellerSearchManagerImp implements TravellerSearchManager{
	
	@Autowired
	private TravellerSearchService service;

	@Override
	public CommonSearchResult<TravellerSearch> getTravellerSearch(TravellerSearchCriteria criteria) throws Exception {
		CommonSearchResult<TravellerSearch> result = new CommonSearchResult<TravellerSearch>();
		 
		// set total
		result.setTotalResult(service.countTravellerSearch(criteria));
		
		// set list result
		result.setListResult(service.getTravellerSearch(criteria));
		
		return result;
	}
}
