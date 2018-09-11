package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultStationEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SEC_GROUP database table.
 * 
 */
@Entity
@Table(name="SEC_GROUP")
public class GroupEntity extends DefaultStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEC_GROUP_GROUPID_GENERATOR" , schema="APPS_TRAINING" , sequenceName="SEC_GROUP_SEQ" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEC_GROUP_GROUPID_GENERATOR")
	@Column(name="GROUP_ID")
	private long groupId;

	private Character active;
	
	@OneToMany(mappedBy = "group"
			, fetch = FetchType.LAZY
			, cascade = CascadeType.ALL
			, orphanRemoval = true)
	@ToStringExclude
	private List<GroupOperatorEntity> groupOperators;
	
	@OneToMany(mappedBy = "group"
			, fetch = FetchType.LAZY
			, cascade = CascadeType.ALL
			, orphanRemoval = true)
	@ToStringExclude
	private List<UserGroupEntity> userGroups;

	

	@Column(name="GROUP_CODE")
	private String groupCode;

	@Column(name="GROUP_NAME")
	private String groupName;

	@Column(name="REMARK")
	private String remark;

	


	public GroupEntity() {
	}

	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public List<GroupOperatorEntity> getGroupOperators() {
		return groupOperators;
	}

	public void setGroupOperators(List<GroupOperatorEntity> groupOperators) {
		this.groupOperators = groupOperators;
	}

	public List<UserGroupEntity> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroupEntity> userGroups) {
		this.userGroups = userGroups;
	}
	
	public void addGroupOperator(GroupOperatorEntity groupOperator) {
		if(groupOperators == null) {
			groupOperators = new ArrayList<GroupOperatorEntity>();
		}
		
		groupOperators.add(groupOperator);
		groupOperator.setGroup(this);
	}
	
	public void addUserGroup(UserGroupEntity userGroup) {
		if(userGroups == null) {
			userGroups = new ArrayList<UserGroupEntity>();
		}
		
		userGroups.add(userGroup);
		userGroup.setGroup(this);
	}

}