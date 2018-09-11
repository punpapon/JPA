package com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.sit.commons.CommonSearch;

public class TravellerSearch extends CommonSearch {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal rowNo;
	private BigDecimal travelInfoId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDatetime;

	private String transactionDatetimeFormat;
	private BigDecimal stopListHitId;
	private BigDecimal stopListStatus;
	private String mOverStopList;
	private BigDecimal blackListHitId;
	private BigDecimal blackListStatus;
	private String mOverBlackList;
	private Character travellerType;
	private String convertName;
	private String fullName;
	private Character gender;
	private String nationality;
	private String nationalityName;
	private Character boardingStatus;
	private String boardingStatusName;
	private BigDecimal journeyId;
	private String departurePort;
	private String arrivalPort;
	private String departureDatetimeOrig;
	private String arrivalDatetimeOrig;
	private String departureDatetime;
	private String arrivalDatetime;
	private String serviceNumber;
	private String cerrierCode;
	private String cerrierName;
	private String flightRoute;
	private Character journeyType;
	private String flightDirection;
	private Character journeyTraveller;
	private String journeyTypeName;
	private String flightStatusCode;
	private String flightStatusName;
	private Character active;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private BigDecimal createUser;
	private BigDecimal createStation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	private BigDecimal updateUser;
	private BigDecimal updateStation;
	private String dob;
	private String docNo;

	public BigDecimal getRowNo() {
		return rowNo;
	}

	public void setRowNo(BigDecimal rowNo) {
		this.rowNo = rowNo;
	}

	public BigDecimal getTravelInfoId() {
		return travelInfoId;
	}

	public void setTravelInfoId(BigDecimal travelInfoId) {
		this.travelInfoId = travelInfoId;
	}

	public Date getTransactionDatetime() {
		return transactionDatetime;
	}

	public void setTransactionDatetime(Date transactionDatetime) {
		this.transactionDatetime = transactionDatetime;
	}

	public String getTransactionDatetimeFormat() {
		return transactionDatetimeFormat;
	}

	public void setTransactionDatetimeFormat(String transactionDatetimeFormat) {
		this.transactionDatetimeFormat = transactionDatetimeFormat;
	}

	public BigDecimal getStopListHitId() {
		return stopListHitId;
	}

	public void setStopListHitId(BigDecimal stopListHitId) {
		this.stopListHitId = stopListHitId;
	}

	public BigDecimal getStopListStatus() {
		return stopListStatus;
	}

	public void setStopListStatus(BigDecimal stopListStatus) {
		this.stopListStatus = stopListStatus;
	}

	public String getmOverStopList() {
		return mOverStopList;
	}

	public void setmOverStopList(String mOverStopList) {
		this.mOverStopList = mOverStopList;
	}

	public BigDecimal getBlackListHitId() {
		return blackListHitId;
	}

	public void setBlackListHitId(BigDecimal blackListHitId) {
		this.blackListHitId = blackListHitId;
	}

	public BigDecimal getBlackListStatus() {
		return blackListStatus;
	}

	public void setBlackListStatus(BigDecimal blackListStatus) {
		this.blackListStatus = blackListStatus;
	}

	public String getmOverBlackList() {
		return mOverBlackList;
	}

	public void setmOverBlackList(String mOverBlackList) {
		this.mOverBlackList = mOverBlackList;
	}

	public Character getTravellerType() {
		return travellerType;
	}

	public void setTravellerType(Character travellerType) {
		this.travellerType = travellerType;
	}

	public String getConvertName() {
		return convertName;
	}

	public void setConvertName(String convertName) {
		this.convertName = convertName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationalityName() {
		return nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}

	public Character getBoardingStatus() {
		return boardingStatus;
	}

	public void setBoardingStatus(Character boardingStatus) {
		this.boardingStatus = boardingStatus;
	}

	public String getBoardingStatusName() {
		return boardingStatusName;
	}

	public void setBoardingStatusName(String boardingStatusName) {
		this.boardingStatusName = boardingStatusName;
	}

	public BigDecimal getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(BigDecimal journeyId) {
		this.journeyId = journeyId;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	public String getArrivalPort() {
		return arrivalPort;
	}

	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}

	public String getDepartureDatetimeOrig() {
		return departureDatetimeOrig;
	}

	public void setDepartureDatetimeOrig(String departureDatetimeOrig) {
		this.departureDatetimeOrig = departureDatetimeOrig;
	}

	public String getArrivalDatetimeOrig() {
		return arrivalDatetimeOrig;
	}

	public void setArrivalDatetimeOrig(String arrivalDatetimeOrig) {
		this.arrivalDatetimeOrig = arrivalDatetimeOrig;
	}

	public String getDepartureDatetime() {
		return departureDatetime;
	}

	public void setDepartureDatetime(String departureDatetime) {
		this.departureDatetime = departureDatetime;
	}

	public String getArrivalDatetime() {
		return arrivalDatetime;
	}

	public void setArrivalDatetime(String arrivalDatetime) {
		this.arrivalDatetime = arrivalDatetime;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public String getCerrierCode() {
		return cerrierCode;
	}

	public void setCerrierCode(String cerrierCode) {
		this.cerrierCode = cerrierCode;
	}

	public String getCerrierName() {
		return cerrierName;
	}

	public void setCerrierName(String cerrierName) {
		this.cerrierName = cerrierName;
	}

	public String getFlightRoute() {
		return flightRoute;
	}

	public void setFlightRoute(String flightRoute) {
		this.flightRoute = flightRoute;
	}

	public Character getJourneyType() {
		return journeyType;
	}

	public void setJourneyType(Character journeyType) {
		this.journeyType = journeyType;
	}

	public String getFlightDirection() {
		return flightDirection;
	}

	public void setFlightDirection(String flightDirection) {
		this.flightDirection = flightDirection;
	}

	public Character getJourneyTraveller() {
		return journeyTraveller;
	}

	public void setJourneyTraveller(Character journeyTraveller) {
		this.journeyTraveller = journeyTraveller;
	}

	public String getJourneyTypeName() {
		return journeyTypeName;
	}

	public void setJourneyTypeName(String journeyTypeName) {
		this.journeyTypeName = journeyTypeName;
	}

	public String getFlightStatusCode() {
		return flightStatusCode;
	}

	public void setFlightStatusCode(String flightStatusCode) {
		this.flightStatusCode = flightStatusCode;
	}

	public String getFlightStatusName() {
		return flightStatusName;
	}

	public void setFlightStatusName(String flightStatusName) {
		this.flightStatusName = flightStatusName;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getCreateUser() {
		return createUser;
	}

	public void setCreateUser(BigDecimal createUser) {
		this.createUser = createUser;
	}

	public BigDecimal getCreateStation() {
		return createStation;
	}

	public void setCreateStation(BigDecimal createStation) {
		this.createStation = createStation;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public BigDecimal getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(BigDecimal updateUser) {
		this.updateUser = updateUser;
	}

	public BigDecimal getUpdateStation() {
		return updateStation;
	}

	public void setUpdateStation(BigDecimal updateStation) {
		this.updateStation = updateStation;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
