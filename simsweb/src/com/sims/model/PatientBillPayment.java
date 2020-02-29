package com.sims.model;

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
@Table(name = "patientbillpayment", schema = "crms")
public class PatientBillPayment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private SalesHeader patientBill;
	private BigDecimal amount;
	private Integer modeOfPayment;
	private Timestamp dateofpayment;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	public PatientBillPayment(){}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientBillPaymentId_generator")
	@SequenceGenerator(name="patientBillPaymentId_generator", sequenceName = "crms.patientbillpaymentseq", allocationSize=1)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "billid", nullable = false)
	public SalesHeader getPatientBill() {
		return patientBill;
	}

	public void setPatientBill(SalesHeader patientBill) {
		this.patientBill = patientBill;
	}

	@Column(name = "amount", precision=9)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "modeofpayment")
	public Integer getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(Integer modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	@Column(name = "dateofpayment")
	public Timestamp getDateOfPayment() {
		return dateofpayment;
	}

	public void setDateOfPayment(Timestamp dateofpayment) {
		this.dateofpayment = dateofpayment;
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
		return "PatientBillPayment [id=" + id + ", patientBill=" + (patientBill!=null ? String.valueOf(patientBill.getId()) : "null")
				+ ", amount=" + amount + ", modeOfPayment=" + modeOfPayment
				+ ", dateofpayment=" + dateofpayment + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + "]";
	}
	
	
	

}
