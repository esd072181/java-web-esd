package com.crms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * 
 * @author dward
 *
 */
@Entity
@Table(name = "labexam", schema = "crms")
public class LabExam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String description;
	private String remarks;
	private BigDecimal fee;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;

	
	public LabExam() {}
	
	public LabExam(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "labExamId_generator")
	@SequenceGenerator(name="labExamId_generator", sequenceName = "crms.labexamseq", allocationSize=1)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "description", length = 60)
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "remarks", length = 100)
	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Column(name = "fee", precision = 9)
	public BigDecimal getFee() {
		return fee;
	}


	public void setFee(BigDecimal fee) {
		this.fee = fee;
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

	@Override
	public String toString() {
		return "LabExam [id=" + id + ", description=" + description
				+ ", remarks=" + remarks + ", fee=" + fee + ", reportTemplate="
				+ ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn="
				+ modifiedOn + ", version=" + version + "]";
	}

}
