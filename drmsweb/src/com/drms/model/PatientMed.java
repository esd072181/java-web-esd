package com.drms.model;

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
@Table(name = "patientmed", schema = "drms")
public class PatientMed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private PatientConsultation patientConsultation;
	private Medicine med;
	private Integer qty;
	private BigDecimal price;
	private BigDecimal amount;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	public PatientMed(){}
	
	public PatientMed(int id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientMedId_generator")
	@SequenceGenerator(name="patientMedId_generator", sequenceName = "drms.patientmedseq", allocationSize=1)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patientconsultsystemid", nullable = false)
	public PatientConsultation getPatientConsultation() {
		return patientConsultation;
	}

	public void setPatientConsultation(PatientConsultation patientConsultation) {
		this.patientConsultation = patientConsultation;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medid", nullable = false)
	public Medicine getMed() {
		return med;
	}

	public void setMed(Medicine med) {
		this.med = med;
	}

	@Column(name = "qty")
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Column(name = "price",precision=9)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "amount",precision=9)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
		return "PatientLabExam [id=" + id + ", patientLabRequest="
				+ (patientConsultation!=null ? String.valueOf(patientConsultation.getId()) : "null") + ", med=" + (med!=null ? String.valueOf(med.getId()) : "null") + ", qty=" + qty
				+ ", price=" + price + ", amount=" + amount + ", dateTaken="
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn 
				+ ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn 
				+ ", version=" + version + "]";
	}

	

}
