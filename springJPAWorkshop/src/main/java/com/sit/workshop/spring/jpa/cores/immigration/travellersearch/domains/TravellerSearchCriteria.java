package com.sit.workshop.spring.jpa.cores.immigration.travellersearch.domains;

import java.util.List;

import com.sit.commons.CommonSearchCriteria;

public class TravellerSearchCriteria extends CommonSearchCriteria {
	private Integer siteId;
	private Integer riskStatusStopList;
	private Integer riskStatusBlackList;
	private String flightStatus;
	private String transactionDataStart;
	private String transactionDataEnd;
	private String transactionTimeStart;
	private String transactionTimeEnd;
	private String convertType;
	private String documentType;
	private String documentNo;
	private String serviceNumber;
	private String flightDirection;
	private String departureAirport;
	private String arrivalAirport;
	private String carrierCode;
	private String departureDateStart;
	private String departureDateEnd;
	private String departureTimeStart;
	private String departureTimeEnd;
	private String arrivalDataStart;
	private String arrivalDataEnd;
	private String arrivalTimeStart;
	private String arrivalTimeEnd;
	private String surname;
	private String name;
	private String yyyy;
	private String mm;
	private String dd;
	private String gender;
	private String nationalityCode;

	private List<Character> boardingStatusList;
	private List<Character> journeyTypeList;

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getRiskStatusStopList() {
		return riskStatusStopList;
	}

	public void setRiskStatusStopList(Integer riskStatusStopList) {
		this.riskStatusStopList = riskStatusStopList;
	}

	public Integer getRiskStatusBlackList() {
		return riskStatusBlackList;
	}

	public void setRiskStatusBlackList(Integer riskStatusBlackList) {
		this.riskStatusBlackList = riskStatusBlackList;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	public String getTransactionDataStart() {
		return transactionDataStart;
	}

	public void setTransactionDataStart(String transactionDataStart) {
		this.transactionDataStart = transactionDataStart;
	}

	public String getTransactionDataEnd() {
		return transactionDataEnd;
	}

	public void setTransactionDataEnd(String transactionDataEnd) {
		this.transactionDataEnd = transactionDataEnd;
	}

	public String getTransactionTimeStart() {
		return transactionTimeStart;
	}

	public void setTransactionTimeStart(String transactionTimeStart) {
		this.transactionTimeStart = transactionTimeStart;
	}

	public String getTransactionTimeEnd() {
		return transactionTimeEnd;
	}

	public void setTransactionTimeEnd(String transactionTimeEnd) {
		this.transactionTimeEnd = transactionTimeEnd;
	}

	public String getConvertType() {
		return convertType;
	}

	public void setConvertType(String convertType) {
		this.convertType = convertType;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public String getFlightDirection() {
		return flightDirection;
	}

	public void setFlightDirection(String flightDirection) {
		this.flightDirection = flightDirection;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getDepartureDateStart() {
		return departureDateStart;
	}

	public void setDepartureDateStart(String departureDateStart) {
		this.departureDateStart = departureDateStart;
	}

	public String getDepartureDateEnd() {
		return departureDateEnd;
	}

	public void setDepartureDateEnd(String departureDateEnd) {
		this.departureDateEnd = departureDateEnd;
	}

	public String getDepartureTimeStart() {
		return departureTimeStart;
	}

	public void setDepartureTimeStart(String departureTimeStart) {
		this.departureTimeStart = departureTimeStart;
	}

	public String getDepartureTimeEnd() {
		return departureTimeEnd;
	}

	public void setDepartureTimeEnd(String departureTimeEnd) {
		this.departureTimeEnd = departureTimeEnd;
	}

	public String getArrivalDataStart() {
		return arrivalDataStart;
	}

	public void setArrivalDataStart(String arrivalDataStart) {
		this.arrivalDataStart = arrivalDataStart;
	}

	public String getArrivalDataEnd() {
		return arrivalDataEnd;
	}

	public void setArrivalDataEnd(String arrivalDataEnd) {
		this.arrivalDataEnd = arrivalDataEnd;
	}

	public String getArrivalTimeStart() {
		return arrivalTimeStart;
	}

	public void setArrivalTimeStart(String arrivalTimeStart) {
		this.arrivalTimeStart = arrivalTimeStart;
	}

	public String getArrivalTimeEnd() {
		return arrivalTimeEnd;
	}

	public void setArrivalTimeEnd(String arrivalTimeEnd) {
		this.arrivalTimeEnd = arrivalTimeEnd;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYyyy() {
		return yyyy;
	}

	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationalityCode() {
		return nationalityCode;
	}

	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	public List<Character> getBoardingStatusList() {
		return boardingStatusList;
	}

	public void setBoardingStatusList(List<Character> boardingStatusList) {
		this.boardingStatusList = boardingStatusList;
	}

	public List<Character> getJourneyTypeList() {
		return journeyTypeList;
	}

	public void setJourneyTypeList(List<Character> journeyTypeList) {
		this.journeyTypeList = journeyTypeList;
	}

}
