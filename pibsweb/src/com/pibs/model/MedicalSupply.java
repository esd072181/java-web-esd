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
import java.sql.Date;

/**
 * @author Edward.David
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MedicalSupply implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int medicalSupplyTypeId;
	private String itemCode;
	private String description;
	private String genericName;
	private String remarks;
	private String lotNo;
	private Date dateManufactured;
	private Date expirationDate;
	private BigDecimal retailSellingPrice;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String medicalSupplyTypeName;
	
	public MedicalSupply() {}
	
	public String getMedicalSupplyTypeName() {
		return medicalSupplyTypeName;
	}

	public void setMedicalSupplyTypeName(String medicalSupplyTypeName) {
		this.medicalSupplyTypeName = medicalSupplyTypeName;
	}

	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
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
	public Date getDateManufactured() {
		return dateManufactured;
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
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @return
	 */
	public String getGenericName() {
		return genericName;
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
	public String getLotNo() {
		return lotNo;
	}

	/**
	 * @return
	 */
	public int getMedicalSupplyTypeId() {
		return medicalSupplyTypeId;
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
	public String getRemarks() {
		return remarks;
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
	 * @param date
	 */
	public void setDateManufactured(Date date) {
		dateManufactured = date;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param date
	 */
	public void setExpirationDate(Date date) {
		expirationDate = date;
	}

	/**
	 * @param string
	 */
	public void setGenericName(String string) {
		genericName = string;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @param string
	 */
	public void setLotNo(String string) {
		lotNo = string;
	}

	/**
	 * @param i
	 */
	public void setMedicalSupplyTypeId(int i) {
		medicalSupplyTypeId = i;
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
	 * @param string
	 */
	public void setRemarks(String string) {
		remarks = string;
	}

	/**
	 * @param i
	 */
	public void setVersion(int i) {
		version = i;
	}

	/**
	 * 
	 * @return
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * 
	 * @param itemCode
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * 
	 * @return
	 */
	public BigDecimal getRetailSellingPrice() {
		return retailSellingPrice;
	}

	/**
	 * 
	 * @param retailSellingPrice
	 */
	public void setRetailSellingPrice(BigDecimal retailSellingPrice) {
		this.retailSellingPrice = retailSellingPrice;
	}
	
}
