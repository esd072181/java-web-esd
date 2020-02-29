/*
 * Created on Jan 28, 2015
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.pibs.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;

/**
 * @author Edward.David
 * @since 28Jan2015
 * LastDateUpdated: 18Apr2018
 */
public class Patient implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String patientId;
	private String lastName;
	private String firstName;
	private String middleName;
	private String gender;
	private Date birthday;
	private String contactNo;
	private String address;
	private String contactPerson;
	private String contactPersonNo;
	private String dateRegistered;
	private int patientStatusId;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String status;
	private Date dateAdmitted;
	private String caseNo;
	private int patientCaseSystemId;
	
	private int roomId; //for admission to update the available beds of room selected
	
	//to show in admitted patients
	private String roomNo;
	private String doctor;
	
	//after payment 
	private int billingId;
	
	private String birthdayStr;
	
	//patient inquiry
	private String chiefComplaint;
	private Date dateDischarged;
	private String fullName;
	private String admissionStatus;
	
	//patient history
	private String diagnosis;
	private String diagnosisRemarks;
	private Date dateOfDiagnosis;
	private String medicationStatement;
	private String medicationStatementRemarks;
	private Date dateOfMedicationStatement;
	private String prognosis;
	private String prognosisRemarks;
	private Date dateOfPrognosis;
	
	private int ageAdmitted;
	
	public int getBillingId() {
		return billingId;
	}



	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}



	public int getRoomId() {
		return roomId;
	}



	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}



	public Date getDateAdmitted() {
		return dateAdmitted;
	}



	public void setDateAdmitted(Date dateAdmitted) {
		this.dateAdmitted = dateAdmitted;
	}





	public int getPatientCaseSystemId() {
		return patientCaseSystemId;
	}



	public void setPatientCaseSystemId(int patientCaseSystemId) {
		this.patientCaseSystemId = patientCaseSystemId;
	}



	public String getCaseNo() {
		return caseNo;
	}



	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}



	public Patient() {}
	


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
	public String getDateRegistered() {
		return dateRegistered;
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
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @return
	 */
	public int getPatientStatusId() {
		return patientStatusId;
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
	public void setDateRegistered(String string) {
		dateRegistered = string;
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
	 * @param string
	 */
	public void setPatientId(String string) {
		patientId = string;
	}

	/**
	 * @param i
	 */
	public void setPatientStatusId(int i) {
		patientStatusId = i;
	}

	/**
	 * @param i
	 */
	public void setVersion(int i) {
		version = i;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getContactNo() {
		return contactNo;
	}



	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getContactPerson() {
		return contactPerson;
	}



	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}



	public String getContactPersonNo() {
		return contactPersonNo;
	}



	public void setContactPersonNo(String contactPersonNo) {
		this.contactPersonNo = contactPersonNo;
	}



	public String getRoomNo() {
		return roomNo;
	}



	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}



	public String getDoctor() {
		return doctor;
	}



	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}



	public String getBirthdayStr() {
		return birthdayStr;
	}



	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}



	public String getChiefComplaint() {
		return chiefComplaint;
	}



	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}



	public Date getDateDischarged() {
		return dateDischarged;
	}



	public void setDateDischarged(Date dateDischarged) {
		this.dateDischarged = dateDischarged;
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



	public String getAdmissionStatus() {
		return admissionStatus;
	}



	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}



	public String getDiagnosis() {
		return diagnosis;
	}



	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}



	public String getDiagnosisRemarks() {
		return diagnosisRemarks;
	}



	public void setDiagnosisRemarks(String diagnosisRemarks) {
		this.diagnosisRemarks = diagnosisRemarks;
	}



	public Date getDateOfDiagnosis() {
		return dateOfDiagnosis;
	}



	public void setDateOfDiagnosis(Date dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}



	public String getMedicationStatement() {
		return medicationStatement;
	}



	public void setMedicationStatement(String medicationStatement) {
		this.medicationStatement = medicationStatement;
	}



	public String getMedicationStatementRemarks() {
		return medicationStatementRemarks;
	}



	public void setMedicationStatementRemarks(String medicationStatementRemarks) {
		this.medicationStatementRemarks = medicationStatementRemarks;
	}



	public Date getDateOfMedicationStatement() {
		return dateOfMedicationStatement;
	}



	public void setDateOfMedicationStatement(Date dateOfMedicationStatement) {
		this.dateOfMedicationStatement = dateOfMedicationStatement;
	}



	public String getPrognosis() {
		return prognosis;
	}



	public void setPrognosis(String prognosis) {
		this.prognosis = prognosis;
	}



	public String getPrognosisRemarks() {
		return prognosisRemarks;
	}



	public void setPrognosisRemarks(String prognosisRemarks) {
		this.prognosisRemarks = prognosisRemarks;
	}



	public Date getDateOfPrognosis() {
		return dateOfPrognosis;
	}



	public void setDateOfPrognosis(Date dateOfPrognosis) {
		this.dateOfPrognosis = dateOfPrognosis;
	}



	public int getAgeAdmitted() {
		return ageAdmitted;
	}



	public void setAgeAdmitted(int ageAdmitted) {
		this.ageAdmitted = ageAdmitted;
	}



}
