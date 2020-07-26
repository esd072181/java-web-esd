package com.transport.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author dward
 * @since June2015
 * DateUpdated: 26Jul2020
 */
public class Lorry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6968356176923170250L;

	private int id;
	private String lorryNo;
	private String plateNo;
	private String trailerNo;
	private int capacity;
	private String category;
	private int transportId;
	private String tractorModel;
	private String trailerModel;
	private String tractorYear;
	private String trailerYear;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String transport;//non-persistent
		
	public Lorry() {}

	public String getTrailerNo() {
		return trailerNo;
	}

	public void setTrailerNo(String trailerNo) {
		this.trailerNo = trailerNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLorryNo() {
		return lorryNo;
	}

	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
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

	public String getLorryAndPlateNo() {
		return getPlateNo() + "|" + getLorryNo();
	}
	
	public String getLorryNoWithPlateNo() {
		return getLorryNo() + " (" + getPlateNo()+")";
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getTransportId() {
		return transportId;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getTractorModel() {
		return tractorModel;
	}

	public void setTractorModel(String tractorModel) {
		this.tractorModel = tractorModel;
	}

	public String getTrailerModel() {
		return trailerModel;
	}

	public void setTrailerModel(String trailerModel) {
		this.trailerModel = trailerModel;
	}

	public String getTractorYear() {
		return tractorYear;
	}

	public void setTractorYear(String tractorYear) {
		this.tractorYear = tractorYear;
	}

	public String getTrailerYear() {
		return trailerYear;
	}

	public void setTrailerYear(String trailerYear) {
		this.trailerYear = trailerYear;
	}
	
	
}
