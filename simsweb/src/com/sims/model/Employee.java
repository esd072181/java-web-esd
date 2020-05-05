package com.sims.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

/**
 * 
 * @author dward
 *
 */
@Entity
@Table(name = "employee", schema = "sims")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private ListValue empType;
	private String lastName;
	private String firstName;
	private String middleName;
	private String gender;
	private String contactNo;
	private String address;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	@SuppressWarnings("unused")
	private String fullName;
	
	private List<UserAccount> userAccountList = new ArrayList<>();

	
	public Employee() {}
	
	public Employee(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeId_generator")
	@SequenceGenerator(name="employeeId_generator", sequenceName = "sims.employeeseq", allocationSize=1)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emptypeid", nullable = false)
	public ListValue getEmpType() {
		return empType;
	}
	
	public void setEmpType(ListValue empType) {
		this.empType = empType;
	}

	@Column(name = "lastname", length = 40)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "firstname", length = 40)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "middlename", length = 40)
	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "gender", length = 10)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "contactno", length = 20)
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}

	@Transient
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Transient
	public String getFullName2() {
		return this.lastName + ", " + this.firstName + " " +  (this.middleName!=null ? this.middleName : "");
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emp")
	@Where(clause = "active = true")
	public List<UserAccount> getUserAccountList() {
		return userAccountList;
	}

	public void setUserAccountList(List<UserAccount> userAccountList) {
		this.userAccountList = userAccountList;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empType=" + (empType!=null ? empType.getId() : "null") + ", lastName="
				+ lastName + ", firstName=" + firstName + ", middleName="
				+ middleName + ", gender=" + gender + ", contactNo="
				+ contactNo + ", address=" + address + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + ", active=" + active + "]";
	}

}
