/*
 * Created on Jan 28, 2015
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.pibs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Edward.David
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Room implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String roomNo;
	private int roomCategoryId;
	private int buildingId;
	private int floorNo;
	private int noOfBeds;
	private int availableBeds;
	private String description;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String roomCategory;
	private String building;
	private BigDecimal rate;
	
	private String roomFullName;


	public Room() {}
	
	

	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return
	 */
	public int getBuildingId() {
		return buildingId;
	}

	/**
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return
	 */
	public int getFloorNo() {
		return floorNo;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public int getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @return
	 */
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @return
	 */
	public int getNoOfBeds() {
		return noOfBeds;
	}

	/**
	 * @return
	 */
	public int getRoomCategoryId() {
		return roomCategoryId;
	}

	/**
	 * @return
	 */
	public String getRoomNo() {
		return roomNo;
	}

	/**
	 * @return
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param b
	 */
	public void setActive(boolean b) {
		active = b;
	}

	/**
	 * @param i
	 */
	public void setBuildingId(int i) {
		buildingId = i;
	}

	/**
	 * @param i
	 */
	public void setCreatedBy(int i) {
		createdBy = i;
	}

	/**
	 * @param timestamp
	 */
	public void setCreatedOn(Timestamp timestamp) {
		createdOn = timestamp;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param i
	 */
	public void setFloorNo(int i) {
		floorNo = i;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @param i
	 */
	public void setModifiedBy(int i) {
		modifiedBy = i;
	}

	/**
	 * @param timestamp
	 */
	public void setModifiedOn(Timestamp timestamp) {
		modifiedOn = timestamp;
	}

	/**
	 * @param i
	 */
	public void setNoOfBeds(int i) {
		noOfBeds = i;
	}

	/**
	 * @param i
	 */
	public void setRoomCategoryId(int i) {
		roomCategoryId = i;
	}

	/**
	 * @param string
	 */
	public void setRoomNo(String string) {
		roomNo = string;
	}

	/**
	 * @param i
	 */
	public void setVersion(int i) {
		version = i;
	}
	
	public String getRoomCategory() {
		return roomCategory;
	}



	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}



	public String getBuilding() {
		return building;
	}



	public void setBuilding(String building) {
		this.building = building;
	}



	public BigDecimal getRate() {
		return rate;
	}



	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}



	public String getRoomFullName() {
		return roomFullName;
	}

	public void setRoomFullName() {
		StringBuilder sb = new StringBuilder(30);
		sb.append(this.roomNo);
		sb.append("-");
		sb.append(this.roomCategory);
		this.roomFullName = sb.toString();
	}



	public int getAvailableBeds() {
		return availableBeds;
	}



	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}
	
	
	
}
