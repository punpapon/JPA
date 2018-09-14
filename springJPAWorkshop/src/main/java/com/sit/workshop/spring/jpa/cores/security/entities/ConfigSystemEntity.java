package com.sit.workshop.spring.jpa.cores.security.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.sit.workshop.spring.jpa.cores.entities.DefaultActiveStationEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SEC_CONFIG_SYSTEM database table.
 * 
 */
@Entity
@Table(name="SEC_CONFIG_SYSTEM")
@NamedQuery(name="ConfigSystemEntity.findAll", query="SELECT c FROM ConfigSystemEntity c")
public class ConfigSystemEntity extends DefaultActiveStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEC_CONFIG_SYSTEM_CONFIGSYSTEMID_GENERATOR" ,schema="APPS_TRAINING" , sequenceName="SEC_CONFIG_SYSTEM_SEQ" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEC_CONFIG_SYSTEM_CONFIGSYSTEMID_GENERATOR")
	@Column(name="CONFIG_SYSTEM_ID")
	private long configSystemId;

	@OneToMany(mappedBy="configSystem"
			, cascade = CascadeType.ALL
			, fetch = FetchType.LAZY
			, orphanRemoval = true)
	@ToStringExclude
	private List<ConfigIpEntity> configIPs;
	
	@Column(name="ACCESS_IP")
	private Character accessIp;

	@Column(name="CONDITION_RIGHT")
	private Character conditionRight;

	@Column(name="CONNECT_TIME_OUT")
	private BigDecimal connectTimeOut;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_USER")
	private Long createUser;

	private String email;

	@Column(name="LOGIN_CAPTCHA")
	private Character loginCaptcha;

	@Column(name="LOGIN_WRONG")
	private Character loginWrong;

	@Column(name="LOGIN_WRONG_CAPTCHA")
	private BigDecimal loginWrongCaptcha;

	@Column(name="LOGIN_WRONG_IN")
	private BigDecimal loginWrongIn;

	@Column(name="LOGIN_WRONG_TIME")
	private BigDecimal loginWrongTime;

	@Column(name="MAIL_PORT")
	private String mailPort;

	@Column(name="MAIL_PROTOCOL")
	private String mailProtocol;

	@Column(name="MAIL_SERVER")
	private String mailServer;

	@Column(name="METHOD_UNLOCK")
	private Character methodUnlock;

	@Column(name="METHOD_UNLOCK_AUTO")
	private BigDecimal methodUnlockAuto;

	private String password;

	@Column(name="PW_EXP")
	private Character pwExp;

	@Column(name="PW_EXP_RENEW")
	private BigDecimal pwExpRenew;

	@Column(name="PW_FORMAT_BIG_CHAR")
	private Character pwFormatBigChar;

	@Column(name="PW_FORMAT_LIT_CHAR")
	private Character pwFormatLitChar;

	@Column(name="PW_FORMAT_NUM")
	private Character pwFormatNum;

	@Column(name="PW_FORMAT_SPECIAL")
	private Character pwFormatSpecial;

	@Column(name="PW_LENGTH")
	private BigDecimal pwLength;

	public ConfigSystemEntity() {
	}

	public long getConfigSystemId() {
		return this.configSystemId;
	}

	public void setConfigSystemId(long configSystemId) {
		this.configSystemId = configSystemId;
	}

	public Character getAccessIp() {
		return this.accessIp;
	}

	public void setAccessIp(Character accessIp) {
		this.accessIp = accessIp;
	}

	public Character getConditionRight() {
		return this.conditionRight;
	}

	public void setConditionRight(Character conditionRight) {
		this.conditionRight = conditionRight;
	}

	public BigDecimal getConnectTimeOut() {
		return this.connectTimeOut;
	}

	public void setConnectTimeOut(BigDecimal connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	

	public Long getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getLoginCaptcha() {
		return this.loginCaptcha;
	}

	public void setLoginCaptcha(Character loginCaptcha) {
		this.loginCaptcha = loginCaptcha;
	}

	public Character getLoginWrong() {
		return this.loginWrong;
	}

	public void setLoginWrong(Character loginWrong) {
		this.loginWrong = loginWrong;
	}

	public BigDecimal getLoginWrongCaptcha() {
		return this.loginWrongCaptcha;
	}

	public void setLoginWrongCaptcha(BigDecimal loginWrongCaptcha) {
		this.loginWrongCaptcha = loginWrongCaptcha;
	}

	public BigDecimal getLoginWrongIn() {
		return this.loginWrongIn;
	}

	public void setLoginWrongIn(BigDecimal loginWrongIn) {
		this.loginWrongIn = loginWrongIn;
	}

	public BigDecimal getLoginWrongTime() {
		return this.loginWrongTime;
	}

	public void setLoginWrongTime(BigDecimal loginWrongTime) {
		this.loginWrongTime = loginWrongTime;
	}

	public String getMailPort() {
		return this.mailPort;
	}

	public void setMailPort(String mailPort) {
		this.mailPort = mailPort;
	}

	public String getMailProtocol() {
		return this.mailProtocol;
	}

	public void setMailProtocol(String mailProtocol) {
		this.mailProtocol = mailProtocol;
	}

	public String getMailServer() {
		return this.mailServer;
	}

	public void setMailServer(String mailServer) {
		this.mailServer = mailServer;
	}

	public Character getMethodUnlock() {
		return this.methodUnlock;
	}

	public void setMethodUnlock(Character methodUnlock) {
		this.methodUnlock = methodUnlock;
	}

	public BigDecimal getMethodUnlockAuto() {
		return this.methodUnlockAuto;
	}

	public void setMethodUnlockAuto(BigDecimal methodUnlockAuto) {
		this.methodUnlockAuto = methodUnlockAuto;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getPwExp() {
		return this.pwExp;
	}

	public void setPwExp(Character pwExp) {
		this.pwExp = pwExp;
	}

	public BigDecimal getPwExpRenew() {
		return this.pwExpRenew;
	}

	public void setPwExpRenew(BigDecimal pwExpRenew) {
		this.pwExpRenew = pwExpRenew;
	}

	public Character getPwFormatBigChar() {
		return this.pwFormatBigChar;
	}

	public void setPwFormatBigChar(Character pwFormatBigChar) {
		this.pwFormatBigChar = pwFormatBigChar;
	}

	public Character getPwFormatLitChar() {
		return this.pwFormatLitChar;
	}

	public void setPwFormatLitChar(Character pwFormatLitChar) {
		this.pwFormatLitChar = pwFormatLitChar;
	}

	public Character getPwFormatNum() {
		return this.pwFormatNum;
	}

	public void setPwFormatNum(Character pwFormatNum) {
		this.pwFormatNum = pwFormatNum;
	}

	public Character getPwFormatSpecial() {
		return this.pwFormatSpecial;
	}

	public void setPwFormatSpecial(Character pwFormatSpecial) {
		this.pwFormatSpecial = pwFormatSpecial;
	}

	public BigDecimal getPwLength() {
		return this.pwLength;
	}

	public void setPwLength(BigDecimal pwLength) {
		this.pwLength = pwLength;
	}

	public List<ConfigIpEntity> getConfigIPs() {
		return configIPs;
	}

	public void setConfigIPs(List<ConfigIpEntity> configIPs) {
		this.configIPs = configIPs;
	}

	

	

}