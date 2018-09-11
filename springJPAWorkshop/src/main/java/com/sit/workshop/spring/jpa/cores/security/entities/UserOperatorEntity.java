package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultAssociationEntity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SEC_USER_OPERATOR database table.
 * 
 */
@Entity
@Table(name="SEC_USER_OPERATOR")
public class UserOperatorEntity extends DefaultAssociationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	@ToStringExclude
	private UserEntity user;

	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OPERATOR_ID", referencedColumnName="OPERATOR_ID")
	@ToStringExclude
	private OperatorEntity operator;

	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_STATION")
	private Long createStation;

	@Column(name="CREATE_STATION_IP")
	private String createStationIp;

	@Column(name="CREATE_USER")
	private Long createUser;

	public UserOperatorEntity() {
	}


	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreateStation() {
		return this.createStation;
	}

	public void setCreateStation(Long createStation) {
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


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	public OperatorEntity getOperator() {
		return operator;
	}


	public void setOperator(OperatorEntity operator) {
		this.operator = operator;
	}

}