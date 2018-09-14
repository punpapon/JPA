package com.sit.workshop.spring.jpa.cores.security.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.ConfigSystemEntity;

@Repository
@Transactional
public class ConfigSystemDaoImp implements CommonDao<ConfigSystemEntity>{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public ConfigSystemEntity findById(Long id) {
		return entityManager.find(ConfigSystemEntity.class, id);
	}

}
