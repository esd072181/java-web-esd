package com.crms.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "professional", schema = "crms")
public class Professional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private ListValue professionalType;
	private String designation;
	private String lastName;
	private String firstName;
	private String middleName;
	private String gender;
	private BigDecimal fee;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	@SuppressWarnings("unused")
	private String fullName;
	
	private List<UserAccount> userAccountList = new ArrayList<>();

	
	public Professional() {}
	
	public Professional(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professionalId_generator")
	@SequenceGenerator(name="professionalId_generator", sequenceName = "crms.professionalseq", allocationSize=1)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "professionaltypeid", nullable = false)
	public ListValue getProfessionalType() {
		return professionalType;
	}
	
	public void setProfessionalType(ListValue professionalType) {
		this.professionalType = professionalType;
	}

	@Column(name = "designation", length = 5)
	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
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
		return this.designation + " " + this.firstName + " " + this.lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prof")
	@Where(clause = "active = true")
	public List<UserAccount> getUserAccountList() {
		return userAccountList;
	}

	public void setUserAccountList(List<UserAccount> userAccountList) {
		this.userAccountList = userAccountList;
	}

	@Column(name = "fee", precision = 9)
	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Professional [id=" + id + ", professionalType="
				+ (professionalType!=null ? String.valueOf(professionalType.getId()) : "null") + ", designation=" + designation
				+ ", lastName=" + lastName + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", gender=" + gender
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
				+ ", fee=" + fee + ", version=" + version + "]";
	}

	
}
