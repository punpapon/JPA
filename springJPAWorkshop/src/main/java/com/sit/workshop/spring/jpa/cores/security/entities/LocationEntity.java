package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultStationEntity;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the STD_LOCATION database table.
 * 
 */
@Entity
@Table(name="STD_LOCATION")

public class LocationEntity extends DefaultStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STD_LOCATION_LOCATIONID_GENERATOR" , schema="APPS_TRAINING" , sequenceName="STD_LOCATION_SEQ" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STD_LOCATION_LOCATIONID_GENERATOR")
	@Column(name="LOCATION_ID")
	private long locationId;

	private Character active;

	@OneToMany( mappedBy = "location"
			, fetch = FetchType.LAZY
			, cascade = CascadeType.ALL
			, orphanRemoval = true)
	@ToStringExclude
	private List<StationEntity> stations;
	
	
	
	@Column(name="LOCATION_NAME_EN")
	private String locationNameEn;

	@Column(name="LOCATION_NAME_TH")
	private String locationNameTh;

	@Column(name="SITE_ID")
	private Integer siteId;


	public LocationEntity() {
	}

	public long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
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


	public String getLocationNameEn() {
		return this.locationNameEn;
	}

	public void setLocationNameEn(String locationNameEn) {
		this.locationNameEn = locationNameEn;
	}

	public String getLocationNameTh() {
		return this.locationNameTh;
	}

	public void setLocationNameTh(String locationNameTh) {
		this.locationNameTh = locationNameTh;
	}


	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getUpdateStationIp() {
		return this.updateStationIp;
	}

	public void setUpdateStationIp(String updateStationIp) {
		this.updateStationIp = updateStationIp;
	}

	public List<StationEntity> getStations() {
		return stations;
	}

	public void setStations(List<StationEntity> stations) {
		this.stations = stations;
	}
	
}