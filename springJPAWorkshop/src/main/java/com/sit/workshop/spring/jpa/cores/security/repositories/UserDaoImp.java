package com.sit.workshop.spring.jpa.cores.security.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.UserEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.UserGroupEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.UserOperatorEntity;
import com.sit.workshop.spring.jpa.cores.security.interfaces.UserDao;

@Repository
@Transactional
public class UserDaoImp implements UserDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserEntity findById(Long id) {		
		return entityManager.find(UserEntity.class, id);
	}

	@Override
	public void deleteUserOperatorByUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserGroupByUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserOperatorByUser(UserEntity user) {
		List<UserOperatorEntity> list = user.getUserOperators();
		if(list != null) {
			for (UserOperatorEntity obj : list) {
				entityManager.persist(obj);				
			}
		}
		
	}

	@Override
	public void addUserGroupByUser(UserEntity user) {
		List<UserGroupEntity> list = user.getUserGroups();
		if(list != null) {
			for (UserGroupEntity obj : list) {
				entityManager.persist(obj);				
			}
		}
	}
	

}
