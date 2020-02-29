package com.lrms.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author dward
 *
 */
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "callRetrievePatientFunction",
	query = "select * from lrms.retrieve_patient(:id)",
	resultClass = Patient.class
	)
})
@Entity
@Table(name = "patient", schema = "lrms")
public class Patient implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;	
	private String patientNo;
	private String lastName;
	private String middleName;
	private String firstName;
	private String gender;
	private Date birthday;
	private String contactNo;
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String zipCode;
	private String province;
	private String contactPerson;
	private String contactPersonNo;
	private Date dateRegistered;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	@SuppressWarnings("unused")
	private String fullName;
	
	private List<PatientLabRequest> patientLabRequestRecords = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientId_generator")
	@SequenceGenerator(name="patientId_generator", sequenceName = "lrms.patientseq", allocationSize=1)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "patientno", length = 15)
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	
	@Column(name = "lastname", length = 30)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "middlename", length = 30)
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Column(name = "firstname", length = 30)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "gender", length = 10)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "birthday")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "contactno", length = 30)
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "addressline1", length = 100)
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "addressline2", length = 100)
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "town", length = 60)
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Column(name = "zipcode", length = 60)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "province", length = 10)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "contactperson", length = 50)
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "contactpersonno", length = 30)
	public String getContactPersonNo() {
		return contactPersonNo;
	}

	public void setContactPersonNo(String contactPersonNo) {
		this.contactPersonNo = contactPersonNo;
	}

	@Column(name = "dateregistered")
	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	@Column(name = "createdby")
	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "createdon")
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "modifiedby")
	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "modifiedon")
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name = "version")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "active")
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient" )
	public List<PatientLabRequest> getPatientLabRequestRecords() {
		return patientLabRequestRecords;
	}

	public void setPatientLabRequestRecords(List<PatientLabRequest> patientLabRequestRecords) {
		this.patientLabRequestRecords = patientLabRequestRecords;
	}

	@Transient
	public String getFullName() {
		return this.lastName + ", " + this.firstName + " " + this.middleName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientNo=" + patientNo + ", lastName="
				+ lastName + ", middleName=" + middleName + ", firstName="
				+ firstName + ", gender=" + gender + ", birthday=" + birthday
				+ ", contactNo=" + contactNo + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", town=" + town
				+ ", zipCode=" + zipCode + ", province=" + province
				+ ", contactPerson=" + contactPerson + ", contactPersonNo="
				+ contactPersonNo + ", dateRegistered=" + dateRegistered
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
				+ ", version=" + version + "]";
	}
	
	
	
}
