package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultActiveStationEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SEC_USER database table.
 * 
 */
@Entity
@Table(name="SEC_USER")
public class UserEntity extends DefaultActiveStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEC_USER_USERID_GENERATOR" , schema="APPS_TRAINING" , sequenceName="SEC_USER_SEQ" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEC_USER_USERID_GENERATOR")
	@Column(name = "USER_ID")
	private Long userId;


	@OneToMany(mappedBy = "user"
			, fetch = FetchType.LAZY
			, cascade = CascadeType.ALL
			, orphanRemoval = true)
	@ToStringExclude
	private List<UserOperatorEntity> userOperators;

	@OneToMany(mappedBy = "user"
			, fetch = FetchType.LAZY
			, cascade = CascadeType.ALL
			, orphanRemoval = true)
	@ToStringExclude
	private List<UserGroupEntity> userGroups;
	
	@Column(name = "ANSWER")
	private String answer;

	@Column(name = "CELL_PHONE_1")
	private String cellPhone1;

	@Column(name = "CELL_PHONE_2")
	private String cellPhone2;

	@Column(name = "CELL_PHONE_3")
	private String cellPhone3;

	@Column(name = "CHANGE_LOG")
	private Character changeLog;

	@Column(name = "DOCTYPE_REF_USER")
	private Character doctypeRefUser;

	@Column(name = "DOCTYPE_REF_USER_NO")
	private String doctypeRefUserNo;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "EMPLOYEE_CODE")
	private String employeeCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "FORENAME_EN")
	private String forenameEn;

	@Column(name = "FORENAME_TH")
	private String forenameTh;

	@Column(name = "LANGUAGE")
	private Character language;

	@Temporal(TemporalType.DATE)
	@Column(name = "LOCK_DATE")
	private Date lockDate;

	@Column(name = "LOCK_STATUS")
	private Character lockStatus;

	@Column(name = "ORGANIZATION_ID")
	private BigDecimal organizationId;

	@Column(name = "PASS")
	private String pass;

	@Column(name = "PASSWORD")
	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWORD_DATE")
	private Date passwordDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWORD_EXP")
	private Date passwordExp;

	@Column(name = "POSITION_NAME")
	private String positionName;

	@Column(name = "PREFIX_ID")
	private BigDecimal prefixId;

	@Column(name = "QUESTION")
	private Character question;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "RESET_PASSWORD_STATUS")
	private Character resetPasswordStatus;

	@Column(name = "SALT")
	private String salt;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "SURNAME_EN")
	private String surnameEn;

	@Column(name = "SURNAME_TH")
	private String surnameTh;

	@Column(name = "USERNAME")
	private String username;


	public UserEntity() {

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCellPhone1() {
		return cellPhone1;
	}

	public void setCellPhone1(String cellPhone1) {
		this.cellPhone1 = cellPhone1;
	}

	public String getCellPhone2() {
		return cellPhone2;
	}

	public void setCellPhone2(String cellPhone2) {
		this.cellPhone2 = cellPhone2;
	}

	public String getCellPhone3() {
		return cellPhone3;
	}

	public void setCellPhone3(String cellPhone3) {
		this.cellPhone3 = cellPhone3;
	}

	public Character getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(Character changeLog) {
		this.changeLog = changeLog;
	}

	public Character getDoctypeRefUser() {
		return doctypeRefUser;
	}

	public void setDoctypeRefUser(Character doctypeRefUser) {
		this.doctypeRefUser = doctypeRefUser;
	}

	public String getDoctypeRefUserNo() {
		return doctypeRefUserNo;
	}

	public void setDoctypeRefUserNo(String doctypeRefUserNo) {
		this.doctypeRefUserNo = doctypeRefUserNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getForenameEn() {
		return forenameEn;
	}

	public void setForenameEn(String forenameEn) {
		this.forenameEn = forenameEn;
	}

	public String getForenameTh() {
		return forenameTh;
	}

	public void setForenameTh(String forenameTh) {
		this.forenameTh = forenameTh;
	}

	public Character getLanguage() {
		return language;
	}

	public void setLanguage(Character language) {
		this.language = language;
	}

	public Date getLockDate() {
		return lockDate;
	}

	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	public Character getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(Character lockStatus) {
		this.lockStatus = lockStatus;
	}

	public BigDecimal getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(BigDecimal organizationId) {
		this.organizationId = organizationId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPasswordDate() {
		return passwordDate;
	}

	public void setPasswordDate(Date passwordDate) {
		this.passwordDate = passwordDate;
	}

	public Date getPasswordExp() {
		return passwordExp;
	}

	public void setPasswordExp(Date passwordExp) {
		this.passwordExp = passwordExp;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public BigDecimal getPrefixId() {
		return prefixId;
	}

	public void setPrefixId(BigDecimal prefixId) {
		this.prefixId = prefixId;
	}

	public Character getQuestion() {
		return question;
	}

	public void setQuestion(Character question) {
		this.question = question;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Character getResetPasswordStatus() {
		return resetPasswordStatus;
	}

	public void setResetPasswordStatus(Character resetPasswordStatus) {
		this.resetPasswordStatus = resetPasswordStatus;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getSurnameEn() {
		return surnameEn;
	}

	public void setSurnameEn(String surnameEn) {
		this.surnameEn = surnameEn;
	}

	public String getSurnameTh() {
		return surnameTh;
	}

	public void setSurnameTh(String surnameTh) {
		this.surnameTh = surnameTh;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserOperatorEntity> getUserOperators() {
		return userOperators;
	}

	public void setUserOperators(List<UserOperatorEntity> userOperators) {
		this.userOperators = userOperators;
	}

	public void addUserOperator(UserOperatorEntity userOperator) {
		if (userOperators == null) {
			userOperators = new ArrayList<UserOperatorEntity>();
		}

		userOperators.add(userOperator);
		userOperator.setUser(this);
	}

	public List<UserGroupEntity> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroupEntity> userGroups) {
		this.userGroups = userGroups;
	}

	public void addUserGroup(UserGroupEntity userGroup) {
		if (userGroups == null) {
			userGroups = new ArrayList<UserGroupEntity>();
		}

		userGroups.add(userGroup);
		userGroup.setUser(this);
	}
}