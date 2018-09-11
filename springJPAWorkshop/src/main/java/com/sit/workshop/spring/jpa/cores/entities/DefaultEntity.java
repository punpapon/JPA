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
public abstract class DefaultEntity extends DefaultAbstractEntity {

	@Column(name = "ACTIVE")
	protected Character active;

	@Column(name = "UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	protected Date updateDate;

	@Column(name = "UPDATE_USER")
	protected Long updateUser;
	
	@PrePersist
	@Override	
	public void onPrePersist() {
		active = 'Y';
				
		Date date = Calendar.getInstance().getTime();
		createDate = date;
		updateDate = date;
	}

	@PreUpdate
	public void onPreUpdate() {
		updateDate = Calendar.getInstance().getTime();
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
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
	
}
