package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultAssociationEntity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SEC_USER_GROUP database table.
 * 
 */
@Entity
@Table(name="SEC_USER_GROUP")
public class UserGroupEntity extends DefaultAssociationEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	@ToStringExclude
	private UserEntity user;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GROUP_ID", referencedColumnName="GROUP_ID")
	@ToStringExclude
	private GroupEntity group;
	

	public UserGroupEntity() {
	}




	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	public GroupEntity getGroup() {
		return group;
	}


	public void setGroup(GroupEntity group) {
		this.group = group;
	}

}