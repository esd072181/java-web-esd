package com.crms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "patientbill", schema = "crms")
public class PatientBill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private PatientConsultation patientConsultation;
	private BigDecimal totalLabExamFee;
	private BigDecimal totalMedFee;
	private BigDecimal consultFee;
	private BigDecimal totalBill;
	private Timestamp dateProcessed;
	private Boolean cleared;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	public PatientBill(){}
	
	public PatientBill(int id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientBillId_generator")
	@SequenceGenerator(name="patientBillId_generator", sequenceName = "crms.patientbillseq", allocationSize=1)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientconsultsystemid", nullable = false)
	public PatientConsultation getPatientConsultation() {
		return patientConsultation;
	}

	public void setPatientConsultation(PatientConsultation patientConsultation) {
		this.patientConsultation = patientConsultation;
	}

	@Column(name = "totallabexamfee", precision=9)
	public BigDecimal getTotalLabExamFee() {
		return totalLabExamFee;
	}

	public void setTotalLabExamFee(BigDecimal totalLabExamFee) {
		this.totalLabExamFee = totalLabExamFee;
	}

	@Column(name = "totalmedfee", precision=9)
	public BigDecimal getTotalMedFee() {
		return totalMedFee;
	}

	public void setTotalMedFee(BigDecimal totalMedFee) {
		this.totalMedFee = totalMedFee;
	}

	@Column(name = "consultationfee", precision=9)
	public BigDecimal getConsultFee() {
		return consultFee;
	}

	public void setConsultFee(BigDecimal consultFee) {
		this.consultFee = consultFee;
	}

	@Column(name = "totalbill", precision=9)
	public BigDecimal getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(BigDecimal totalBill) {
		this.totalBill = totalBill;
	}

	@Column(name = "dateprocessed")
	public Timestamp getDateProcessed() {
		return dateProcessed;
	}

	public void setDateProcessed(Timestamp dateProcessed) {
		this.dateProcessed = dateProcessed;
	}

	@Column(name = "cleared")
	public Boolean getCleared() {
		return cleared;
	}

	public void setCleared(Boolean cleared) {
		this.cleared = cleared;
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
		return "PatientBill [id=" + id + ", patientLabRequest="
				+ (patientConsultation!=null ? String.valueOf(patientConsultation.getId()) : "null") + ", totalLabExamFee=" + totalLabExamFee
				+ ", totalBill=" + totalBill + ", dateProcessed="
				+ dateProcessed + ", cleared=" + cleared + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + "]";
	}
	

}
