package com.transport.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 13Apr2020
 */
public class TireDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String serialNo;
	private String recapNo;
	private Date dateUpdated;
	private String plateNo;
	private String lorryNo;
	private String wheelPosition;
	private Date dateFitted;
	private int odometerFitted;
	private Date dateRemoved;
	private int odometerRemoved;
	private int distanceTraveled;
	private String reasonForRemoval;
	private int threadDepth1;
	private int threadDepth2;
	private int threadDepth3;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	//non persistent
	private String brandName;
	
	public TireDetails(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getRecapNo() {
		return recapNo;
	}

	public void setRecapNo(String recapNo) {
		this.recapNo = recapNo;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getWheelPosition() {
		return wheelPosition;
	}

	public void setWheelPosition(String wheelPosition) {
		this.wheelPosition = wheelPosition;
	}

	public Date getDateFitted() {
		return dateFitted;
	}

	public void setDateFitted(Date dateFitted) {
		this.dateFitted = dateFitted;
	}

	public int getOdometerFitted() {
		return odometerFitted;
	}

	public void setOdometerFitted(int odometerFitted) {
		this.odometerFitted = odometerFitted;
	}

	public Date getDateRemoved() {
		return dateRemoved;
	}

	public void setDateRemoved(Date dateRemoved) {
		this.dateRemoved = dateRemoved;
	}

	public int getOdometerRemoved() {
		return odometerRemoved;
	}

	public void setOdometerRemoved(int odometerRemoved) {
		this.odometerRemoved = odometerRemoved;
	}

	public int getDistanceTraveled() {
		return distanceTraveled;
	}

	public void setDistanceTraveled(int distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}

	public String getReasonForRemoval() {
		return reasonForRemoval;
	}

	public void setReasonForRemoval(String reasonForRemoval) {
		this.reasonForRemoval = reasonForRemoval;
	}

	public int getThreadDepth1() {
		return threadDepth1;
	}

	public void setThreadDepth1(int threadDepth1) {
		this.threadDepth1 = threadDepth1;
	}

	public int getThreadDepth2() {
		return threadDepth2;
	}

	public void setThreadDepth2(int threadDepth2) {
		this.threadDepth2 = threadDepth2;
	}

	public int getThreadDepth3() {
		return threadDepth3;
	}

	public void setThreadDepth3(int threadDepth3) {
		this.threadDepth3 = threadDepth3;
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

	public String getLorryNo() {
		return lorryNo;
	}

	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}	
	
}
