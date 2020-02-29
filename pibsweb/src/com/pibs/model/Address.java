/*
 * Created on Jan 28, 2015
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.pibs.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Edward.David
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5361438969073770692L;
	
	private int id;
	private int entityId;
	private int addressTypeId;
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String province;
	private String postcode;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	public Address() {}
	
	

	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @return
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @return
	 */
	public int getAddressTypeId() {
		return addressTypeId;
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
	public int getEntityId() {
		return entityId;
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
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @return
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @return
	 */
	public String getTown() {
		return town;
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
	 * @param string
	 */
	public void setAddressLine1(String string) {
		addressLine1 = string;
	}

	/**
	 * @param string
	 */
	public void setAddressLine2(String string) {
		addressLine2 = string;
	}

	/**
	 * @param i
	 */
	public void setAddressTypeId(int i) {
		addressTypeId = i;
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
	 * @param i
	 */
	public void setEntityId(int i) {
		entityId = i;
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
	public void setPostcode(String string) {
		postcode = string;
	}

	/**
	 * @param string
	 */
	public void setProvince(String string) {
		province = string;
	}

	/**
	 * @param string
	 */
	public void setTown(String string) {
		town = string;
	}

	/**
	 * @param i
	 */
	public void setVersion(int i) {
		version = i;
	}

}
