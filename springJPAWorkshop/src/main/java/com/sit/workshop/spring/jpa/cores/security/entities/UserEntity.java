package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultActiveStationEntity;

import java.math.BigDecimal;
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
	@Column(name="USER_ID")
	private long userId;

	private Character active;

	private String answer;
	
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

	@Column(name="CELL_PHONE_1")
	private String cellPhone1;

	@Column(name="CELL_PHONE_2")
	private String cellPhone2;

	@Column(name="CELL_PHONE_3")
	private String cellPhone3;

	@Column(name="CHANGE_LOG")
	private Character changeLog;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_STATION")
	private Long createStation;

	@Column(name="CREATE_STATION_IP")
	private String createStationIp;

	@Column(name="CREATE_USER")
	private Long createUser;

	@Column(name="DOCTYPE_REF_USER")
	private Character doctypeRefUser;

	@Column(name="DOCTYPE_REF_USER_NO")
	private String doctypeRefUserNo;

	private String email;

	@Column(name="EMPLOYEE_CODE")
	private String employeeCode;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="FORENAME_EN")
	private String forenameEn;

	@Column(name="FORENAME_TH")
	private String forenameTh;

	@Column(name="\"LANGUAGE\"")
	private Character language;

	@Temporal(TemporalType.DATE)
	@Column(name="LOCK_DATE")
	private Date lockDate;

	@Column(name="LOCK_STATUS")
	private Character lockStatus;

	@Column(name="ORGANIZATION_ID")
	private Long organizationId;

	private String pass;

	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="PASSWORD_DATE")
	private Date passwordDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PASSWORD_EXP")
	private Date passwordExp;

	@Column(name="POSITION_NAME")
	private String positionName;

	@Column(name="PREFIX_ID")
	private BigDecimal prefixId;

	private Character question;

	private String remark;

	@Column(name="RESET_PASSWORD_STATUS")
	private Character resetPasswordStatus;

	private String salt;

	@Column(name="SITE_ID")
	private Integer siteId;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="SURNAME_EN")
	private String surnameEn;

	@Column(name="SURNAME_TH")
	private String surnameTh;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_STATION")
	private Long updateStation;

	@Column(name="UPDATE_STATION_IP")
	private String updateStationIp;

	@Column(name="UPDATE_USER")
	private Long updateUser;

	private String username;

	public UserEntity() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Character getActive() {
		return this.active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCellPhone1() {
		return this.cellPhone1;
	}

	public void setCellPhone1(String cellPhone1) {
		this.cellPhone1 = cellPhone1;
	}

	public String getCellPhone2() {
		return this.cellPhone2;
	}

	public void setCellPhone2(String cellPhone2) {
		this.cellPhone2 = cellPhone2;
	}

	public String getCellPhone3() {
		return this.cellPhone3;
	}

	public void setCellPhone3(String cellPhone3) {
		this.cellPhone3 = cellPhone3;
	}

	public Character getChangeLog() {
		return this.changeLog;
	}

	public void setChangeLog(Character changeLog) {
		this.changeLog = changeLog;
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

	public Character getDoctypeRefUser() {
		return this.doctypeRefUser;
	}

	public void setDoctypeRefUser(Character doctypeRefUser) {
		this.doctypeRefUser = doctypeRefUser;
	}

	public String getDoctypeRefUserNo() {
		return this.doctypeRefUserNo;
	}

	public void setDoctypeRefUserNo(String doctypeRefUserNo) {
		this.doctypeRefUserNo = doctypeRefUserNo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getForenameEn() {
		return this.forenameEn;
	}

	public void setForenameEn(String forenameEn) {
		this.forenameEn = forenameEn;
	}

	public String getForenameTh() {
		return this.forenameTh;
	}

	public void setForenameTh(String forenameTh) {
		this.forenameTh = forenameTh;
	}

	public Character getLanguage() {
		return this.language;
	}

	public void setLanguage(Character language) {
		this.language = language;
	}

	public Date getLockDate() {
		return this.lockDate;
	}

	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	public Character getLockStatus() {
		return this.lockStatus;
	}

	public void setLockStatus(Character lockStatus) {
		this.lockStatus = lockStatus;
	}

	public Long getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPasswordDate() {
		return this.passwordDate;
	}

	public void setPasswordDate(Date passwordDate) {
		this.passwordDate = passwordDate;
	}

	public Date getPasswordExp() {
		return this.passwordExp;
	}

	public void setPasswordExp(Date passwordExp) {
		this.passwordExp = passwordExp;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public BigDecimal getPrefixId() {
		return this.prefixId;
	}

	public void setPrefixId(BigDecimal prefixId) {
		this.prefixId = prefixId;
	}

	public Character getQuestion() {
		return this.question;
	}

	public void setQuestion(Character question) {
		this.question = question;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Character getResetPasswordStatus() {
		return this.resetPasswordStatus;
	}

	public void setResetPasswordStatus(Character resetPasswordStatus) {
		this.resetPasswordStatus = resetPasswordStatus;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getSurnameEn() {
		return this.surnameEn;
	}

	public void setSurnameEn(String surnameEn) {
		this.surnameEn = surnameEn;
	}

	public String getSurnameTh() {
		return this.surnameTh;
	}

	public void setSurnameTh(String surnameTh) {
		this.surnameTh = surnameTh;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdateStation() {
		return this.updateStation;
	}

	public void setUpdateStation(Long updateStation) {
		this.updateStation = updateStation;
	}

	public String getUpdateStationIp() {
		return this.updateStationIp;
	}

	public void setUpdateStationIp(String updateStationIp) {
		this.updateStationIp = updateStationIp;
	}

	public Long getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public String getUsername() {
		return this.username;
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

	public List<UserGroupEntity> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroupEntity> userGroups) {
		this.userGroups = userGroups;
	}

}