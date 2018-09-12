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


	public UserOperatorEntity() {
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