package com.sit.workshop.spring.jpa.cores.security.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.OperatorEntity;

@Repository
@Transactional
public class OperatorDaoImp implements CommonDao<OperatorEntity>{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public OperatorEntity findById(Long id) {
		return entityManager.find(OperatorEntity.class, id);
	}

}
