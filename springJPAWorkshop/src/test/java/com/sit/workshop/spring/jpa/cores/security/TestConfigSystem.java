package com.sit.workshop.spring.jpa.cores.security;

import static org.junit.Assert.assertNotNull;

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
import com.sit.workshop.spring.jpa.cores.security.entities.ConfigIpEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.ConfigSystemEntity;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DataAccessConfig.class} )
public class TestConfigSystem {

	@Autowired
	@Qualifier("configSystemDaoImp")
	private CommonDao<ConfigSystemEntity> configSystemDao;
	
	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void getConfigSystemById() {
		ConfigSystemEntity configSystemEntity = configSystemDao.findById(12L);
		assertNotNull(configSystemEntity);
		if(configSystemEntity != null) {
			System.out.println("=== Config System Entity ===");
			System.out.println(configSystemEntity.toString());
			
			if(configSystemEntity.getConfigIPs() != null) {
				System.out.println("=== Config IP Entity ===");
				for (ConfigIpEntity configIpEntity : configSystemEntity.getConfigIPs()) {
					System.out.println(configIpEntity.toString());
				}
			}
		}
	}
}
