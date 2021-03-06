package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultAssociationEntity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SEC_GROUP_OPERATOR database table.
 * 
 */
@Entity
@Table(name="SEC_GROUP_OPERATOR")
public class GroupOperatorEntity extends DefaultAssociationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GROUP_ID", referencedColumnName="GROUP_ID")
	@ToStringExclude
	private GroupEntity group;
	
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

	public GroupOperatorEntity() {
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


	public GroupEntity getGroup() {
		return group;
	}


	public void setGroup(GroupEntity group) {
		this.group = group;
	}


	public OperatorEntity getOperator() {
		return operator;
	}


	public void setOperator(OperatorEntity operator) {
		this.operator = operator;
	}

}