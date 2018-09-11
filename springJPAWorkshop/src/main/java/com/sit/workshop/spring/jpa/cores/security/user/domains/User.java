package com.sit.workshop.spring.jpa.cores.security.user.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User {
	private Long userId;
	
	private Character doctypeRefUser;
	private String doctypeRefUserNo;
	
	@NotBlank
	@Size(min = 6, max = 6)
	private String employeeCode;
	
	@NotNull
	private Long prefixId;
	
	@NotBlank
	private String forenameEn;
	
	@NotBlank
	private String forenameTh;
	
	@NotBlank
	private String surnameEn;
	
	@NotBlank
	private String surnameTh;
	
	@NotNull
	private Long organizationId;
		
	private String positionName;	
	private String email;
	private String cellPhone1;
	private String cellPhone2;
	private String cellPhone3;
	private Date startDate;
	private Date endDate;
	private String remark;
	
	@NotNull
	private Character active;
	
	@NotBlank
	@Size(min = 6, max = 12)
	private String username;
	
	@NotBlank
	@Size(min = 6)
	private String password;	
	
	private List<Operator> operators;
	private List<Group> groups;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Long getPrefixId() {
		return prefixId;
	}

	public void setPrefixId(Long prefixId) {
		this.prefixId = prefixId;
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

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Operator> getOperators() {
		return operators;
	}

	public void setOperators(List<Operator> operators) {
		this.operators = operators;
	}
	
	public void addOperators(Operator operator) {
		if(operators == null) {
			operators = new ArrayList<Operator>();
		}
		operators.add(operator);
	}
	
	public List<Group> getGroups() {
		return groups;
	}
	
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	public void addGroup(Group group) {
		if(groups == null) {
			groups = new ArrayList<Group>();
		}
		groups.add(group);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
