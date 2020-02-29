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
public class AdditionalServices implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5799366744805200161L;
	
	private int id;
	private int additionalServicesCategoryId;
	private String description;
	private String remarks;
	private BigDecimal fee;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String additionalServicesCategory;
	
	public AdditionalServices() {}
	
	
	
	public String getAdditionalServicesCategory() {
		return additionalServicesCategory;
	}



	public void setAdditionalServicesCategory(String additionalServicesCategory) {
		this.additionalServicesCategory = additionalServicesCategory;
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
	public String getDescription() {
		return description;
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
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
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



	public int getAdditionalServicesCategoryId() {
		return additionalServicesCategoryId;
	}



	public void setAdditionalServicesCategoryId(int additionalServicesCategoryId) {
		this.additionalServicesCategoryId = additionalServicesCategoryId;
	}



	public BigDecimal getFee() {
		return fee;
	}



	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	
	
}
