package com.sit.workshop.spring.jpa.cores.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public abstract class DefaultAbstractEntity {

	@Column(name = "CREATE_DATE", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	protected Date createDate;

	@Column(name = "CREATE_USER", updatable = false)
	protected Long createUser;

	public abstract void onPrePersist();
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

}
