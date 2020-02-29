package com.transport.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.transport.util.DateUtils;

/**
 * 
 * @author dward
 * @since 31August2019
 * UpdateDate: 09Sep2019
 */
public class DriverTrainingProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int driverTrainingId;
	private String vnv;
	private String incab;
	private String spotcheck;
	private String incident;
	private String notes;
	private Date profileDate;
	private int statusId;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	//non-persistent
	private String status;
	private String driverName;
	private String profileDateStr;
		
	public String getProfileDateStr() {
		try {
			this.profileDateStr = DateUtils.sqlDateToString(this.profileDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profileDateStr;
	}

	public void setProfileDateStr(String profileDateStr) {
		this.profileDateStr = profileDateStr;
	}

	public DriverTrainingProfile(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDriverTrainingId() {
		return driverTrainingId;
	}

	public void setDriverTrainingId(int driverTrainingId) {
		this.driverTrainingId = driverTrainingId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getProfileDate() {
		return profileDate;
	}

	public void setProfileDate(Date profileDate) {
		this.profileDate = profileDate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getVnv() {
		return vnv;
	}

	public void setVnv(String vnv) {
		this.vnv = vnv;
	}

	public String getIncab() {
		return incab;
	}

	public void setIncab(String incab) {
		this.incab = incab;
	}

	public String getSpotcheck() {
		return spotcheck;
	}

	public void setSpotcheck(String spotcheck) {
		this.spotcheck = spotcheck;
	}

	public String getIncident() {
		return incident;
	}

	public void setIncident(String incident) {
		this.incident = incident;
	}
	
	
	
	
}
