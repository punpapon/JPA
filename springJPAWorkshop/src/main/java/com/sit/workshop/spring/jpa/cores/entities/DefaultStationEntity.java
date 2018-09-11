package com.sit.workshop.spring.jpa.cores.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class DefaultStationEntity extends DefaultEntity {

	@NotNull
	@Column(name="SITE_ID")
	private Integer siteId;

	@Column(name = "CREATE_STATION_IP", updatable = false)
	protected String createStationIp;

	@Column(name = "CREATE_STATION", updatable = false)
	protected Long createStation;
	
	@Column(name = "UPDATE_STATION_IP")
	protected String updateStationIp;

	@Column(name = "UPDATE_STATION")
	protected Long updateStation;

	@PrePersist
	@Override
	public void onPrePersist() {
		super.onPrePersist();
		
		siteId = 3;
		
		createUser = 0L;
		createStation = 0L;
		createStationIp = "XXX";
		
		updateUser = 0L;
		updateStation = 0L;
		updateStationIp = "XXX";
	}
	
	@PreUpdate
	@Override
	public void onPreUpdate() {
		super.onPreUpdate();
		
		updateUser = 0L;
		updateStation = 0L;
		updateStationIp = "XXX";
	}
	
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
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
	
	public String getUpdateStationIp() {
		return updateStationIp;
	}

	public void setUpdateStationIp(String updateStationIp) {
		this.updateStationIp = updateStationIp;
	}

	public Long getUpdateStation() {
		return updateStation;
	}

	public void setUpdateStation(Long updateStation) {
		this.updateStation = updateStation;
	}

}
