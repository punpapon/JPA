package com.sit.workshop.spring.jpa.cores.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public abstract class DefaultAssociationEntity extends DefaultAbstractEntity {

	@Column(name = "CREATE_STATION_IP", updatable = false)
	protected String createStationIp;

	@Column(name = "CREATE_STATION", updatable = false)
	protected Long createStation;

	@PrePersist
	@Override
	public void onPrePersist() {
		createUser = 0L;
		createStation = 0L;
		createStationIp = "XXX";
		
		Date date = Calendar.getInstance().getTime();
		createDate = date;
	}

	public String getCreateStationIp() {
		return createStationIp;
	}

	public void setCreateStationIp(String createStationIp) {
		this.createStationIp = createStationIp;
	}

	public Long getCreateStation() {
		return createStation;
	}

	public void setCreateStation(Long createStation) {
		this.createStation = createStation;
	}
	
}
