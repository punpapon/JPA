package com.sit.workshop.spring.jpa.cores.security;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.configs.DataAccessConfig;
import com.sit.workshop.spring.jpa.cores.security.entities.OperatorEntity;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DataAccessConfig.class})
public class TestOperator {

	@Autowired
	@Qualifier("operatorDaoImp")
	private CommonDao<OperatorEntity> operationDao;

	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void getOperationById() {		
		OperatorEntity operatorEntity = operationDao.findById(10500100L);
		assertNotNull(operatorEntity);
		
		if(operatorEntity != null) {
			System.out.println("=== Operator Entity ===");
			System.out.println(operatorEntity.toString());
			
			System.out.println("=== Parent ===");
			recusiveParent(operatorEntity, 0);
			
			System.out.println("=== Child ===");
			recucive(operatorEntity, 0);		
		}
	}
	
	private void recusiveParent(OperatorEntity operatorEntity, int level) {
		if(operatorEntity.getParentOperator() != null) {
			System.out.println("Level [" + (level - 1) + "]" + operatorEntity.getParentOperator().toString());
			
			recusiveParent(operatorEntity.getParentOperator(), level - 1);
		}
	}

	private void recucive(OperatorEntity operatorEntity, int level) {
		List<OperatorEntity> operators = operatorEntity.getOperators();
		if(operators != null) {
			for (OperatorEntity obj : operators) {				
				System.out.println("Level [" + (level + 1) + "]" + obj.toString());
				recucive(obj, level + 1);
			}
		}
	}
}
