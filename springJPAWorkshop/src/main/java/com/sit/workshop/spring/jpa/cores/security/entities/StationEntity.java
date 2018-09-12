package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultStationEntity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SEC_STATION database table.
 * 
 */
@Entity
@Table(name="SEC_STATION")
public class StationEntity extends DefaultStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEC_STATION_STATIONID_GENERATOR" , schema="APPS_TRAINING" , sequenceName="SEC_STATION_SEQ" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEC_STATION_STATIONID_GENERATOR")
	@Column(name="STATION_ID")
	private long stationId;

	private Character active;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LOCATION_ID" , referencedColumnName="LOCATION_ID")
	@ToStringExclude
	private LocationEntity location;

	@Column(name="INACTIVE_REASON")
	private String inactiveReason;

	@Column(name="IP_NUMBER")
	private String ipNumber;

	@Column(name="IP_TYPE")
	private Character ipType;

	/*@Column(name="LOCATION_ID")
	private BigDecimal locationId;*/

	private String remark;

	@Column(name="SITE_ID")
	private Integer siteId;

	@Column(name="STATION_CODE")
	private String stationCode;

	@Column(name="STATION_NAME")
	private String stationName;

	

	public StationEntity() {
	}

	public long getStationId() {
		return this.stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public Character getActive() {
		return this.active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateStationIp() {
		return this.createStationIp;
	}

	public void setCreateStationIp(String createStationIp) {
		this.createStationIp = createStationIp;
	}


	public String getInactiveReason() {
		return this.inactiveReason;
	}

	public void setInactiveReason(String inactiveReason) {
		this.inactiveReason = inactiveReason;
	}

	public String getIpNumber() {
		return this.ipNumber;
	}

	public void setIpNumber(String ipNumber) {
		this.ipNumber = ipNumber;
	}

	public Character getIpType() {
		return this.ipType;
	}

	public void setIpType(Character ipType) {
		this.ipType = ipType;
	}

/*	public BigDecimal getLocationId() {
		return this.locationId;
	}

	public void setLocationId(BigDecimal locationId) {
		this.locationId = locationId;
	}*/

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getStationCode() {
		return this.stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}



	public String getUpdateStationIp() {
		return this.updateStationIp;
	}

	public void setUpdateStationIp(String updateStationIp) {
		this.updateStationIp = updateStationIp;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}



}