package com.sit.workshop.spring.jpa.cores.security.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.GroupEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.GroupOperatorEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.UserGroupEntity;
import com.sit.workshop.spring.jpa.cores.security.interfaces.GroupDao;

@Repository
@Transactional
public class GroupDaoImp implements GroupDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public GroupEntity findById(Long id) {
		return entityManager.find(GroupEntity.class, id);
	}


	@Override
	public GroupEntity add(GroupEntity group) {
		entityManager.persist(group);
		return group;
	}

	@Override
	public GroupEntity update(GroupEntity group) {
		entityManager.merge(group);
		return group;
	}

	@Override
	public void delete(GroupEntity group) {
		entityManager.remove(group);
	}

	@Override
	public void deleteGroupOperatorByGroup(GroupEntity group) {
		Query query = entityManager.createNamedQuery("Group.deleteGroupOperatorBygroupId");
		query.setParameter("groupId", group.getGroupId());
		query.executeUpdate();	
		
		entityManager.flush();
		entityManager.clear();
	}

	@Override
	public void deleteGroupUserByGroup(GroupEntity group) {
		Query query = entityManager.createNamedQuery("Group.deleteGroupUserBygroupId");
		query.setParameter("groupId", group.getGroupId());
		query.executeUpdate();	
		
		entityManager.flush();
		entityManager.clear();
	}

	@Override
	public void addGroupOperatorByGroup(GroupEntity group) {
		List<GroupOperatorEntity> list = group.getGroupOperators();
		if (list != null) {
			for (GroupOperatorEntity obj : list) {
				entityManager.persist(obj);
			}
		}
	}

	@Override
	public void addUserGroupByGroup(GroupEntity group) {
		List<UserGroupEntity> list = group.getUserGroups();
		if (list != null) {
			for (UserGroupEntity obj : list) {
				entityManager.persist(obj);
			}
		}
	}

}
