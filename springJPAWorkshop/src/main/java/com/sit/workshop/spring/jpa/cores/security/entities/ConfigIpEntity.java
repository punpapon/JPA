package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.sit.workshop.spring.jpa.cores.entities.DefaultEntity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SEC_CONFIG_IP database table.
 * 
 */
@Entity
@Table(name="SEC_CONFIG_IP")
@NamedQuery(name="ConfigIpEntity.findAll", query="SELECT c FROM ConfigIpEntity c")
public class ConfigIpEntity extends DefaultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEC_CONFIG_IP_CONFIGIPID_GENERATOR" , schema="APPS_TRAINING" , sequenceName="SEC_CONFIG_IP_SEQ" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEC_CONFIG_IP_CONFIGIPID_GENERATOR")
	@Column(name="CONFIG_IP_ID")
	private long configIpId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONFIG_SYSTEM_ID" , referencedColumnName="CONFIG_SYSTEM_ID")
	private ConfigSystemEntity configSystem;
	
	/*@Column(name="CONFIG_SYSTEM_ID")
	private BigDecimal configSystemId;*/

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_STATION")
	private BigDecimal createStation;

	@Column(name="CREATE_STATION_IP")
	private String createStationIp;

	@Column(name="CREATE_USER")
	private Long createUser;

	@Column(name="IP_NUMBER")
	private String ipNumber;

	@Column(name="IP_TYPE")
	private Character ipType;

	private String remark;


	@Column(name="UPDATE_STATION")
	private BigDecimal updateStation;

	@Column(name="UPDATE_STATION_IP")
	private String updateStationIp;


	public ConfigIpEntity() {
	}

	public long getConfigIpId() {
		return this.configIpId;
	}

	public void setConfigIpId(long configIpId) {
		this.configIpId = configIpId;
	}


/*	public BigDecimal getConfigSystemId() {
		return this.configSystemId;
	}

	public void setConfigSystemId(BigDecimal configSystemId) {
		this.configSystemId = configSystemId;
	}*/

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getCreateStation() {
		return this.createStation;
	}

	public void setCreateStation(BigDecimal createStation) {
		this.createStation = createStation;
	}

	public String getCreateStationIp() {
		return this.createStationIp;
	}

	public void setCreateStationIp(String createStationIp) {
		this.createStationIp = createStationIp;
	}

	public Long getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public BigDecimal getUpdateStation() {
		return this.updateStation;
	}

	public void setUpdateStation(BigDecimal updateStation) {
		this.updateStation = updateStation;
	}

	public String getUpdateStationIp() {
		return this.updateStationIp;
	}

	public void setUpdateStationIp(String updateStationIp) {
		this.updateStationIp = updateStationIp;
	}

	public ConfigSystemEntity getConfigSystem() {
		return configSystem;
	}

	public void setConfigSystem(ConfigSystemEntity configSystem) {
		this.configSystem = configSystem;
	}

	@PrePersist
	@Override
	public void onPrePersist() {
		super.onPrePersist();
		
		createUser = 0L;
		createStation = new BigDecimal(0);
		createStationIp = "XXX";
		
		updateUser = 0L;
		updateStation = new BigDecimal(0);
		updateStationIp = "XXX";
	}
	
	@PreUpdate
	@Override
	public void onPreUpdate() {
		super.onPreUpdate();
		
		updateUser = 0L;
		updateStation = new BigDecimal(0);
		updateStationIp = "XXX";
	}


}