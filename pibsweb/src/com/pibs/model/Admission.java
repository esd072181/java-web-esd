package com.pibs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Admission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String caseNo;
	private String chiefComplaint;
	private int patientSystemId;
	private int roomId;
	private int professionalId;
	private int patientTypeId;
	private Timestamp dateOfCase;
	private Timestamp dateDischarged;
	private int patientCaseStatusId;
	private int ageAdmitted;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	//patient info
	private String patientId;
	private String lastName;
	private String firstName;
	private String middleName;
	private String gender;
	private String patientStatus;
	private String patientType;
	private String roomNo;
	private String doctor;
	private BigDecimal roomFee;
	private BigDecimal doctorFee;
	private String patientFullName;
	
	//room transfer
	private String roomNoTransfer;
	
	private String roomCategory;
	
	
	public String getPatientFullName() {
		return patientFullName;
	}

	public void setPatientFullName(String patientFullName) {
		this.patientFullName = patientFullName;
	}

	public Admission() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public int getPatientSystemId() {
		return patientSystemId;
	}

	public void setPatientSystemId(int patientSystemId) {
		this.patientSystemId = patientSystemId;
	}


	public Timestamp getDateOfCase() {
		return dateOfCase;
	}

	public void setDateOfCase(Timestamp dateOfCase) {
		this.dateOfCase = dateOfCase;
	}

	public Timestamp getDateDischarged() {
		return dateDischarged;
	}

	public void setDateDischarged(Timestamp dateDischarged) {
		this.dateDischarged = dateDischarged;
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

	public int getPatientTypeId() {
		return patientTypeId;
	}

	public void setPatientTypeId(int patientTypeId) {
		this.patientTypeId = patientTypeId;
	}

	public int getPatientCaseStatusId() {
		return patientCaseStatusId;
	}

	public void setPatientCaseStatusId(int patientCaseStatusId) {
		this.patientCaseStatusId = patientCaseStatusId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(int professionalId) {
		this.professionalId = professionalId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
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

	public BigDecimal getRoomFee() {
		return roomFee;
	}

	public void setRoomFee(BigDecimal roomFee) {
		this.roomFee = roomFee;
	}

	public BigDecimal getDoctorFee() {
		return doctorFee;
	}

	public void setDoctorFee(BigDecimal doctorFee) {
		this.doctorFee = doctorFee;
	}

	public String getRoomNoTransfer() {
		return roomNoTransfer;
	}

	public void setRoomNoTransfer(String roomNoTransfer) {
		this.roomNoTransfer = roomNoTransfer;
	}

	public int getAgeAdmitted() {
		return ageAdmitted;
	}

	public void setAgeAdmitted(int ageAdmitted) {
		this.ageAdmitted = ageAdmitted;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}	
	
	
	
}
