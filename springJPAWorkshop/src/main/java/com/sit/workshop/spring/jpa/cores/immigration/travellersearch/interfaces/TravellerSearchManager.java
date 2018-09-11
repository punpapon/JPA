package com.sit.workshop.spring.jpa.cores.immigration.travellersearch.interfaces;

import com.sit.commons.CommonSearchResult;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearch;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearchCriteria;

public interface TravellerSearchManager {
	CommonSearchResult<TravellerSearch> getTravellerSearch(TravellerSearchCriteria criteria) throws Exception;
}
