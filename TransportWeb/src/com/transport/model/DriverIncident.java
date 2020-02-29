package com.transport.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 
 * @author dward
 * @since 09-Dec-2019
 */
public class DriverIncident implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String acknowStat;
	private String acknowRemarks;
	private String reportStat;
	private String reportRemarks;
	private String companyStat;
	private String companyRemarks;
	private String incabStat;
	private String incabRemarks;	
	private String dwhStat;
	private String dwhRemarks;
	private String gpsStat;
	private String gpsRemarks;	
	private String ebStat;
	private String ebRemarks;	
	private String alcoholStat;
	private String alcoholRemarks;
	private String driversStat;
	private String driversRemarks;	
	private String policeStat;
	private String policeRemarks;		
	private String photoStat;
	private String photoRemarks;	
	private String picDamageStat;
	private String picDamageRemarks;	
	private String picPlateStat;
	private String picPlateRemarks;	
	private String startStat;
	private String startRemarks;							
	private String withInvestStat;
	private String withInvestRemarks;					
	private String priorStat;
	private String priorRemarks;
	private String nameOne;
	private String positionOne;
	private String nameTwo;
	private String positionTwo;
	private Date incidentDate;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	public DriverIncident(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcknowStat() {
		return acknowStat;
	}

	public void setAcknowStat(String acknowStat) {
		this.acknowStat = acknowStat;
	}

	public String getAcknowRemarks() {
		return acknowRemarks;
	}

	public void setAcknowRemarks(String acknowRemarks) {
		this.acknowRemarks = acknowRemarks;
	}

	public String getReportStat() {
		return reportStat;
	}

	public void setReportStat(String reportStat) {
		this.reportStat = reportStat;
	}

	public String getReportRemarks() {
		return reportRemarks;
	}

	public void setReportRemarks(String reportRemarks) {
		this.reportRemarks = reportRemarks;
	}

	public String getCompanyStat() {
		return companyStat;
	}

	public void setCompanyStat(String companyStat) {
		this.companyStat = companyStat;
	}

	public String getCompanyRemarks() {
		return companyRemarks;
	}

	public void setCompanyRemarks(String companyRemarks) {
		this.companyRemarks = companyRemarks;
	}

	public String getIncabStat() {
		return incabStat;
	}

	public void setIncabStat(String incabStat) {
		this.incabStat = incabStat;
	}

	public String getIncabRemarks() {
		return incabRemarks;
	}

	public void setIncabRemarks(String incabRemarks) {
		this.incabRemarks = incabRemarks;
	}

	public String getDwhStat() {
		return dwhStat;
	}

	public void setDwhStat(String dwhStat) {
		this.dwhStat = dwhStat;
	}

	public String getDwhRemarks() {
		return dwhRemarks;
	}

	public void setDwhRemarks(String dwhRemarks) {
		this.dwhRemarks = dwhRemarks;
	}

	public String getGpsStat() {
		return gpsStat;
	}

	public void setGpsStat(String gpsStat) {
		this.gpsStat = gpsStat;
	}

	public String getGpsRemarks() {
		return gpsRemarks;
	}

	public void setGpsRemarks(String gpsRemarks) {
		this.gpsRemarks = gpsRemarks;
	}

	public String getEbStat() {
		return ebStat;
	}

	public void setEbStat(String ebStat) {
		this.ebStat = ebStat;
	}

	public String getEbRemarks() {
		return ebRemarks;
	}

	public void setEbRemarks(String ebRemarks) {
		this.ebRemarks = ebRemarks;
	}

	public String getAlcoholStat() {
		return alcoholStat;
	}

	public void setAlcoholStat(String alcoholStat) {
		this.alcoholStat = alcoholStat;
	}

	public String getAlcoholRemarks() {
		return alcoholRemarks;
	}

	public void setAlcoholRemarks(String alcoholRemarks) {
		this.alcoholRemarks = alcoholRemarks;
	}

	public String getDriversStat() {
		return driversStat;
	}

	public void setDriversStat(String driversStat) {
		this.driversStat = driversStat;
	}

	public String getDriversRemarks() {
		return driversRemarks;
	}

	public void setDriversRemarks(String driversRemarks) {
		this.driversRemarks = driversRemarks;
	}

	public String getPoliceStat() {
		return policeStat;
	}

	public void setPoliceStat(String policeStat) {
		this.policeStat = policeStat;
	}

	public String getPoliceRemarks() {
		return policeRemarks;
	}

	public void setPoliceRemarks(String policeRemarks) {
		this.policeRemarks = policeRemarks;
	}

	public String getPhotoStat() {
		return photoStat;
	}

	public void setPhotoStat(String photoStat) {
		this.photoStat = photoStat;
	}

	public String getPhotoRemarks() {
		return photoRemarks;
	}

	public void setPhotoRemarks(String photoRemarks) {
		this.photoRemarks = photoRemarks;
	}

	public String getPicDamageStat() {
		return picDamageStat;
	}

	public void setPicDamageStat(String picDamageStat) {
		this.picDamageStat = picDamageStat;
	}

	public String getPicDamageRemarks() {
		return picDamageRemarks;
	}

	public void setPicDamageRemarks(String picDamageRemarks) {
		this.picDamageRemarks = picDamageRemarks;
	}

	public String getPicPlateStat() {
		return picPlateStat;
	}

	public void setPicPlateStat(String picPlateStat) {
		this.picPlateStat = picPlateStat;
	}

	public String getPicPlateRemarks() {
		return picPlateRemarks;
	}

	public void setPicPlateRemarks(String picPlateRemarks) {
		this.picPlateRemarks = picPlateRemarks;
	}

	public String getStartStat() {
		return startStat;
	}

	public void setStartStat(String startStat) {
		this.startStat = startStat;
	}

	public String getStartRemarks() {
		return startRemarks;
	}

	public void setStartRemarks(String startRemarks) {
		this.startRemarks = startRemarks;
	}

	public String getWithInvestStat() {
		return withInvestStat;
	}

	public void setWithInvestStat(String withInvestStat) {
		this.withInvestStat = withInvestStat;
	}

	public String getWithInvestRemarks() {
		return withInvestRemarks;
	}

	public void setWithInvestRemarks(String withInvestRemarks) {
		this.withInvestRemarks = withInvestRemarks;
	}

	
	public String getPriorStat() {
		return priorStat;
	}

	public void setPriorStat(String priorStat) {
		this.priorStat = priorStat;
	}

	public String getPriorRemarks() {
		return priorRemarks;
	}

	public void setPriorRemarks(String priorRemarks) {
		this.priorRemarks = priorRemarks;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getNameOne() {
		return nameOne;
	}

	public void setNameOne(String nameOne) {
		this.nameOne = nameOne;
	}

	public String getPositionOne() {
		return positionOne;
	}

	public void setPositionOne(String positionOne) {
		this.positionOne = positionOne;
	}

	public String getNameTwo() {
		return nameTwo;
	}

	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}

	public String getPositionTwo() {
		return positionTwo;
	}

	public void setPositionTwo(String positionTwo) {
		this.positionTwo = positionTwo;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}
	

}
