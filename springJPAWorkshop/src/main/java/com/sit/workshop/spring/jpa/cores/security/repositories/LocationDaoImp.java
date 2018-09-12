package com.sit.workshop.spring.jpa.cores.security.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.LocationEntity;

@Repository
@Transactional
public class LocationDaoImp implements CommonDao<LocationEntity>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public LocationEntity findById(Long id) {
		return entityManager.find(LocationEntity.class, id);
	}
	
	@Override
	public List<LocationEntity> findAll() {
		return entityManager.createNamedQuery("Location.getActiveLocation", LocationEntity.class).getResultList();
	}
}
