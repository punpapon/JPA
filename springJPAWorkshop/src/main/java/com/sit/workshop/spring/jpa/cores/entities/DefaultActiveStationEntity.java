package com.sit.workshop.spring.jpa.cores.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class DefaultActiveStationEntity extends DefaultAbstractEntity {

	@Column(name = "SITE_ID")
	private Integer siteId;

	@Column(name = "CREATE_STATION_IP", updatable = false)
	protected String createStationIp;

	@Column(name = "CREATE_STATION", updatable = false)
	protected Long createStation;

	@Column(name = "UPDATE_STATION_IP")
	protected String updateStationIp;

	@Column(name = "UPDATE_STATION")
	protected Long updateStation;

	@Column(name = "UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	protected Date updateDate;

	@Column(name = "UPDATE_USER")
	protected Long updateUser;
	
	@PrePersist
	@Override
	public void onPrePersist() {
		System.out.println("[DefaultActiveStationEntity] onPrePersist");
		
		siteId = 3;
		
		createUser = 0L;
		createStation = 0L;
		createStationIp = "XXX";
		
		updateUser = 0L;
		updateStation = 0L;
		updateStationIp = "XXX";
		
		Date date = Calendar.getInstance().getTime();
		createDate = date;
		updateDate = date;
	}

	@PreUpdate
	public void onPreUpdate() {
		System.out.println("[DefaultActiveStationEntity] onPreUpdate");
		
		updateUser = 0L;
		updateStation = 0L;
		updateStationIp = "XXX";
		
		updateDate = Calendar.getInstance().getTime();

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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

}
