package com.sit.workshop.spring.jpa.cores.immigration.travellersearch.interfaces;

import java.util.List;

import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearch;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearchCriteria;

public interface TravellerSearchDao {
	long countTravellerSearch(TravellerSearchCriteria criteria) throws Exception;
	List<TravellerSearch> getTravellerSearch(TravellerSearchCriteria criteria) throws Exception;
}
