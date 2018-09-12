package com.sit.workshop.spring.jpa.cores.security.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.StationEntity;

@Repository
@Transactional
public class StationDaoImp implements CommonDao<StationEntity>{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public StationEntity findById(Long id) {		
		return entityManager.find(StationEntity.class, id);
	}
	
	@Override
	public StationEntity add(StationEntity obj) {
		entityManager.persist(obj);
		return obj;
	}

}
