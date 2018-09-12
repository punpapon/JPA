package com.sit.workshop.spring.jpa.cores.security;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.configs.DataAccessConfig;
import com.sit.workshop.spring.jpa.cores.security.entities.LocationEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.StationEntity;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DataAccessConfig.class})
public class TestStation {

	@Autowired
	@Qualifier("stationDaoImp")
	private CommonDao<StationEntity> stationDao;
	
	@Autowired
	@Qualifier("locationDaoImp")
	private CommonDao<LocationEntity> locationDao;

	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void getStationById() {
		StationEntity stationEntity = stationDao.findById(1L);
		assertNotNull(stationEntity);
		
		if(stationEntity != null) {
			System.out.println("=== Station Entity ===");
			System.out.println(stationEntity.toString());
			
			System.out.println("=== Location Entity ===");
			System.out.println(stationEntity.getLocation().toString());
		}
	}
	
	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void getLocationById() {
		LocationEntity locationEntity = locationDao.findById(8L);
		assertNotNull(locationEntity);
		
		if(locationEntity != null) {
			System.out.println("=== Location Entity ===");
			System.out.println(locationEntity.toString());
			
			if(locationEntity.getStations() != null) {
				System.out.println("=== Station Entity ===");
				for (StationEntity stationEntity : locationEntity.getStations()) {
					System.out.println(stationEntity.toString());
				}				
			}
		}
	}
	
		@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void getActiveLocation() {
		List<LocationEntity> locationList = locationDao.findAll();
		assertNotNull(locationList);
		
		if(locationList != null) {
			System.out.println("=== Location Entity ===");
			for (LocationEntity location : locationList) {
				System.out.println(location.toString());
			}
		}
	}
	
  @Test
	@Transactional
	@Rollback(false)
	public void addStation() {
		LocationEntity location = locationDao.findById(8L);
		
		StationEntity station = new StationEntity();
		station.setStationCode("punpapon");
		station.setStationName("testnaja");
		station.setActive('Y');
		station.setSiteId(1);
		station.setLocation(location);
		
		StationEntity result = stationDao.add(station);
		assertNotNull(result);
		
		if(result != null) {
			System.out.println("=== Station Entity ===");
			System.out.println(result.toString());
			
			System.out.println("=== Location Entity ===");
			System.out.println(result.getLocation().toString());
		}
	}
	
	/*@Test
	@Transactional
	@Rollback(false)
	public void updateStation() {
		LocationEntity location = locationDao.findById(5L);
		
		StationEntity station = stationDao.findById(<stationId>);
		station.setStationCode("HHHHHH");
		station.setStationName("HHHHHH");
		station.setLocation(location);
		
		StationEntity result = stationDao.update(station);
		assertNotNull(result);
		
		if(result != null) {
			System.out.println("=== Station Entity ===");
			System.out.println(result.toString());
			
			System.out.println("=== Location Entity ===");
			System.out.println(result.getLocation().toString());
		}
	}*/
	
	/*@Test
	@Transactional
	@Rollback(false)
	public void deleteConfigSystem() {
		StationEntity station = stationDao.findById(<stationId>);
		stationDao.delete(station);
		assertNotNull(station);
	}*/
}
