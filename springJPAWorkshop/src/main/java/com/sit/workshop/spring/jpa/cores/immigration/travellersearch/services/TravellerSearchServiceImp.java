package com.sit.workshop.spring.jpa.cores.immigration.travellersearch.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearch;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearchCriteria;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.interfaces.TravellerSearchDao;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.interfaces.TravellerSearchService;

@Service
@Transactional
public class TravellerSearchServiceImp implements TravellerSearchService{
	
	@Autowired
	private TravellerSearchDao dao;

	@Override
	public long countTravellerSearch(TravellerSearchCriteria criteria) throws Exception {
		return dao.countTravellerSearch(criteria);
	}

	@Override
	public List<TravellerSearch> getTravellerSearch(TravellerSearchCriteria criteria) throws Exception {
		return dao.getTravellerSearch(criteria);
	}
	
	
}
