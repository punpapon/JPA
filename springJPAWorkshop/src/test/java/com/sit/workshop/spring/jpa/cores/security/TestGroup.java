package com.sit.workshop.spring.jpa.cores.security;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.configs.DataAccessConfig;
import com.sit.workshop.spring.jpa.cores.security.entities.GroupEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.GroupOperatorEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.OperatorEntity;
import com.sit.workshop.spring.jpa.cores.security.interfaces.GroupDao;
import com.sit.workshop.spring.jpa.cores.security.repositories.GroupDaoImp;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DataAccessConfig.class})
public class TestGroup {

	@Autowired
	private GroupDao groupDao;

	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void getGroupById() {		
		GroupEntity groupEntity = groupDao.findById(46L);
		assertNotNull(groupEntity);
		
		if(groupEntity != null) {
			System.out.println("=== Group Entity ===");
			System.out.println(groupEntity.toString());
			
			if(groupEntity.getGroupOperators() != null) {
				System.out.println("=== Operator Entity ===");
				for (GroupOperatorEntity groupOperator : groupEntity.getGroupOperators()) {
					System.out.println(groupOperator.getOperator().getOperatorId());
				}
			}
		}		
	}
	
	/*@Test
	@Transactional
	@Rollback(false)
	public void addGroup() {
		GroupEntity groupEntity = new GroupEntity();
		groupEntity.setGroupCode("TEST HRM");
		groupEntity.setGroupName("TEST HRM");
		
		GroupEntity old = groupDao.findById(8L);
		List<GroupOperatorEntity> oldGroupOperatorList = old.getGroupOperators();
		for (GroupOperatorEntity oldGroupOperator : oldGroupOperatorList) {
			OperatorEntity operator = oldGroupOperator.getOperator();
			
			GroupOperatorEntity groupOperator = new GroupOperatorEntity();
			groupOperator.setGroup(groupEntity);
			groupOperator.setOperator(operator);
			groupEntity.addGroupOperator(groupOperator);
		}
		
		GroupEntity result = groupDao.add(groupEntity);
		assertNotNull(result);
		
		if(result != null) {
			System.out.println("=== Group Entity ===");
			System.out.println(result.toString());
			
			if(result.getGroupOperators() != null) {
				System.out.println("=== Operator Entity ===");
				for (GroupOperatorEntity groupOperator : result.getGroupOperators()) {
					System.out.println(groupOperator.getOperator().getOperatorId());
				}
			}
		}
	}*/
	
	/*@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Rollback(false)
	public void updateGroup() {
		GroupEntity groupEntity = groupDao.findById(<groupId>);
		groupEntity.setGroupCode("TEST HRM Update");
		groupEntity.setGroupName("TEST HRM Update");
		
		groupEntity = groupDao.update(groupEntity);
		System.out.println("=== Group Entity ===");		
		System.out.println(groupEntity.toString());		
				
		GroupEntity old = groupDao.findById(6L);
		List<GroupOperatorEntity> oldGroupOperatorList = old.getGroupOperators();
		if(oldGroupOperatorList.size() > 0) {
			// Delete Old Data
			groupDao.deleteGroupOperatorByGroup(groupEntity);	
			
			groupEntity = groupDao.findById(<groupId>);
			System.out.println("=== Operator Entity ===");	
			System.out.println("Operator is Empty [" + groupEntity.getGroupOperators().isEmpty() + "]");
			
			for (GroupOperatorEntity oldGroupOperator : oldGroupOperatorList) {
				OperatorEntity operator = oldGroupOperator.getOperator();
				
				GroupOperatorEntity groupOperator = new GroupOperatorEntity();
				groupOperator.setGroup(groupEntity);
				groupOperator.setOperator(operator);
				groupEntity.addGroupOperator(groupOperator);
			}
			
			groupDao.addGroupOperatorByGroup(groupEntity);
			
			if(groupEntity != null) {
				System.out.println("=== Group Entity ===");
				System.out.println(groupEntity.toString());
				
				if(groupEntity.getGroupOperators() != null) {
					System.out.println("=== Operator Entity ===");
					for (GroupOperatorEntity groupOperator : groupEntity.getGroupOperators()) {
						System.out.println(groupOperator.getOperator().getOperatorId());
					}
				}
			}
		}
	}*/
	
	/*@Test
	@Transactional
	@Rollback(false)
	public void deleteGroup() {
		GroupEntity groupEntity = groupDao.findById(<groupId>);
		groupDao.delete(groupEntity);
		assertNotNull(groupEntity);
	}*/
}
