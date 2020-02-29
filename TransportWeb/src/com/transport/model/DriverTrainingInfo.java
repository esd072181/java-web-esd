package com.transport.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.transport.util.DateUtils;

/**
 * 
 * @author dward
 * @since 26August2019
 * DateUpdated: 26Nov2019
 */
public class DriverTrainingInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int driverTrainingId;
	private int trainingId;
	private Date expiryDate;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	
	//non-persistent
	private String training;
	private String driverName;
	private String expiryDateStr;
	
	
	public DriverTrainingInfo() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getDriverTrainingId() {
		return driverTrainingId;
	}


	public void setDriverTrainingId(int driverTrainingId) {
		this.driverTrainingId = driverTrainingId;
	}


	public int getTrainingId() {
		return trainingId;
	}


	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public String getTraining() {
		return training;
	}


	public void setTraining(String training) {
		this.training = training;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getExpiryDateStr() {
		try {
			this.expiryDateStr = DateUtils.sqlDateToString(this.expiryDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expiryDateStr;
	}


	public void setExpiryDateStr(String expiryDateStr) {
		this.expiryDateStr = expiryDateStr;
	}

	
}
