package com.sit.workshop.spring.jpa.cores.immigration.travellersearch.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sit.workshop.spring.jpa.configs.SQLUtils;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearch;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains.TravellerSearchCriteria;
import com.sit.workshop.spring.jpa.cores.immigration.travellersearch.interfaces.TravellerSearchDao;
import com.sit.workshop.spring.jpa.utils.transform.IgnoreCaseAliasToBeanResultTransformer;

import oracle.jdbc.driver.SQLUtil;

@Repository
@Transactional
public class TravellerSearchDaoImp implements TravellerSearchDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public long countTravellerSearch(TravellerSearchCriteria criteria) throws Exception {
		Query query = SQLUtils.getSingleResultQuery(entityManager, "Traveller.countTravellerSearch" , criteria, "singleResult");
		
		return ((BigDecimal)query.getSingleResult()).longValue();
	}

	@Override
	public List<TravellerSearch> getTravellerSearch(TravellerSearchCriteria criteria) throws Exception {
		Query query = SQLUtils.getQuery(entityManager, "Traveller.getTravellerSearch", criteria);
		SQLUtils.setOffsetLimit(query, criteria);
		
		query.unwrap(org.hibernate.query.internal.NativeQueryImpl.class)
			.setResultTransformer(new IgnoreCaseAliasToBeanResultTransformer(TravellerSearch.class));
		
		return query.getResultList();
	}

}
