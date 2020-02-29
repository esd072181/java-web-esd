package com.pibs.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Edward.David
 * @since 12Feb2018
 */
public class MedicationStatement implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int patientCaseSystemId;
	private String medicationStatement;
	private String remarks;
	private Date dateOfStatement;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	public MedicationStatement() {}



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



	public int getPatientCaseSystemId() {
		return patientCaseSystemId;
	}



	public void setPatientCaseSystemId(int patientCaseSystemId) {
		this.patientCaseSystemId = patientCaseSystemId;
	}



	public String getMedicationStatement() {
		return medicationStatement;
	}



	public void setMedicationStatement(String medicationStatement) {
		this.medicationStatement = medicationStatement;
	}



	public Date getDateOfStatement() {
		return dateOfStatement;
	}



	public void setDateOfStatement(Date dateOfStatement) {
		this.dateOfStatement = dateOfStatement;
	}
	
	
}
