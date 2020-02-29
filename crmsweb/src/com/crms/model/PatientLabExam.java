package com.crms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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
@Table(name = "patientlabexam", schema = "crms")
public class PatientLabExam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private PatientConsultation patientConsultation;
	private LabExam labExam;
	private Integer qty;
	private BigDecimal fee;
	private BigDecimal amount;
	private Date dateTaken;
	private String timeTaken;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	public PatientLabExam(){}
	
	public PatientLabExam(int id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientLabExamId_generator")
	@SequenceGenerator(name="patientLabExamId_generator", sequenceName = "crms.patientlabexamseq", allocationSize=1)
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
	@JoinColumn(name = "labexamid", nullable = false)
	public LabExam getLabExam() {
		return labExam;
	}

	public void setLabExam(LabExam labExam) {
		this.labExam = labExam;
	}

	@Column(name = "qty")
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Column(name = "fee",precision=9)
	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	@Column(name = "amount",precision=9)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "datetaken")
	public Date getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}

	@Column(name = "timetaken", length=20)
	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
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
				+ (patientConsultation!=null ? String.valueOf(patientConsultation.getId()) : "null") + ", labExam=" + (labExam!=null ? String.valueOf(labExam.getId()) : "null") + ", qty=" + qty
				+ ", fee=" + fee + ", amount=" + amount + ", dateTaken="
				+ dateTaken + ", timeTaken=" + timeTaken + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + "]";
	}

	

}
