package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.Immutable;

import com.sit.workshop.spring.jpa.cores.entities.DefaultEntity;

/**
 * The persistent class for the SEC_OPERATOR database table.
 * 
 */
@Entity
@Immutable
@Table(name="SEC_OPERATOR")
public class OperatorEntity extends DefaultEntity implements Serializable {
	private static final long serialVersionUID = 3304453350414369498L;

	@Id
	@Column(name="OPERATOR_ID")
	private Long operatorId;

	@Column(name="DETAIL")
	private String detail;

	@Column(name="GROUP_SYSTEM")
	private BigDecimal groupSystem;

	@Column(name="HELP")
	private String help;

	@Column(name="LABEL_EN")
	private String labelEn;

	@Column(name="LABEL_TH")
	private String labelTh;

	@Column(name="LIST_NO")
	private BigDecimal listNo;

	@Column(name="OPERATOR_LEVEL")
	private BigDecimal operatorLevel;

	@Column(name="OPERATOR_TYPE")
	private Character operatorType;

	@Column(name="PATH")
	private String path;

	@Column(name="REPORT_CODE")
	private String reportCode;

	@Column(name="REPORT_LAYOUT")
	private String reportLayout;

	@Column(name="REPORT_TYPE")
	private Character reportType;

	@Column(name="SITE_ID")
	private String siteId;

	@Column(name="URL")
	private String url;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT_ID", referencedColumnName ="OPERATOR_ID")
	@ToStringExclude
	private OperatorEntity parentOperator;
	
	@OneToMany(mappedBy="parentOperator", fetch=FetchType.LAZY)
	@ToStringExclude
	private List<OperatorEntity> operators;
	
	@OneToMany(mappedBy="operator", fetch=FetchType.LAZY)
	@ToStringExclude
	private List<GroupOperatorEntity> groupOperators;
	
	@OneToMany(mappedBy="operator", fetch=FetchType.LAZY)
	@ToStringExclude
	private List<UserOperatorEntity> userOperators;

	public OperatorEntity() {
		
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getGroupSystem() {
		return groupSystem;
	}

	public void setGroupSystem(BigDecimal groupSystem) {
		this.groupSystem = groupSystem;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getLabelEn() {
		return labelEn;
	}

	public void setLabelEn(String labelEn) {
		this.labelEn = labelEn;
	}

	public String getLabelTh() {
		return labelTh;
	}

	public void setLabelTh(String labelTh) {
		this.labelTh = labelTh;
	}

	public BigDecimal getListNo() {
		return listNo;
	}

	public void setListNo(BigDecimal listNo) {
		this.listNo = listNo;
	}

	public BigDecimal getOperatorLevel() {
		return operatorLevel;
	}

	public void setOperatorLevel(BigDecimal operatorLevel) {
		this.operatorLevel = operatorLevel;
	}

	public Character getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Character operatorType) {
		this.operatorType = operatorType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getReportLayout() {
		return reportLayout;
	}

	public void setReportLayout(String reportLayout) {
		this.reportLayout = reportLayout;
	}

	public Character getReportType() {
		return reportType;
	}

	public void setReportType(Character reportType) {
		this.reportType = reportType;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public OperatorEntity getParentOperator() {
		return parentOperator;
	}

	public void setParentOperator(OperatorEntity parentOperator) {
		this.parentOperator = parentOperator;
	}

	public List<OperatorEntity> getOperators() {
		return operators;
	}

	public void setOperators(List<OperatorEntity> operators) {
		this.operators = operators;
	}

	public List<GroupOperatorEntity> getGroupOperators() {
		return groupOperators;
	}

	public void setGroupOperators(List<GroupOperatorEntity> groupOperators) {
		this.groupOperators = groupOperators;
	}

	public List<UserOperatorEntity> getUserOperators() {
		return userOperators;
	}

	public void setUserOperators(List<UserOperatorEntity> userOperators) {
		this.userOperators = userOperators;
	}
	
}