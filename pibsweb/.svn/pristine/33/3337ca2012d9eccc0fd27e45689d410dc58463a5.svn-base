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
public class Professional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3611579919260217619L;
	
	private int id;
	private int professionalTypeId;
	private int specializationId;
	private String designation;
	private String lastName;
	private String firstName;
	private String middleName;
	private String gender;
	private Date birthday;
	private Date dateHired;
	private String licenseNo;
	private int professionalStatusId;
	private BigDecimal standardConsultationFee;
	private BigDecimal standardAdmissionFee;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String professionalType;
	private String specialization;
	private String status;
	
	private String fullName;
	
	public Professional() {}
	
	
	

	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
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
	public Date getDateHired() {
		return dateHired;
	}

	/**
	 * @return
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getGender() {
		return gender;
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
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * @return
	 */
	public String getMiddleName() {
		return middleName;
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
	public int getProfessionalStatusId() {
		return professionalStatusId;
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
	 * @param date
	 */
	public void setBirthday(Date date) {
		birthday = date;
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
	public void setDateHired(Date date) {
		dateHired = date;
	}

	/**
	 * @param string
	 */
	public void setDesignation(String string) {
		designation = string;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setGender(String string) {
		gender = string;
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
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setLicenseNo(String string) {
		licenseNo = string;
	}

	/**
	 * @param string
	 */
	public void setMiddleName(String string) {
		middleName = string;
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
	public void setProfessionalStatusId(int i) {
		professionalStatusId = i;
	}

	/**
	 * @param i
	 */
	public void setVersion(int i) {
		version = i;
	}




	public int getProfessionalTypeId() {
		return professionalTypeId;
	}




	public void setProfessionalTypeId(int professionalTypeId) {
		this.professionalTypeId = professionalTypeId;
	}




	public int getSpecializationId() {
		return specializationId;
	}




	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}




	public String getProfessionalType() {
		return professionalType;
	}




	public void setProfessionalType(String professionalType) {
		this.professionalType = professionalType;
	}




	public String getSpecialization() {
		return specialization;
	}




	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public BigDecimal getStandardConsultationFee() {
		return standardConsultationFee;
	}




	public void setStandardConsultationFee(BigDecimal standardConsultationFee) {
		this.standardConsultationFee = standardConsultationFee;
	}




	public BigDecimal getStandardAdmissionFee() {
		return standardAdmissionFee;
	}

	public void setStandardAdmissionFee(BigDecimal standardAdmissionFee) {
		this.standardAdmissionFee = standardAdmissionFee;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName() {
		StringBuilder sb = new StringBuilder(30);
		sb.append(this.lastName);
		sb.append(", ");
		sb.append(this.firstName);
		sb.append(" ");
		sb.append(this.middleName);
		this.fullName = sb.toString();
	}

	
	
}
