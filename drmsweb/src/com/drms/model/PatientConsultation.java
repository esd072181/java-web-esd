package com.drms.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @since Jan2019
 * DateUpdated: 02Apr2020
 */
@Entity
@Table(name = "patientconsultation", schema = "drms")
public class PatientConsultation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String consultNo;
	private Patient patient;
	private Professional professional;
	private String chiefComplaint;
	private String diagnosis;
	private String consultationProcedure;
	private String medicationStatement;
	private Date consultDate;
	private Integer age;
	private String height;
	private String weight;
	private String remarks;
	private ListValue status;
	private ListValue paymentStatus;
	private Date nextConsultDate;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	private Integer medId;//transient
	private Integer labExamId;//transient
	private BigDecimal totalMedAmount;
	
	private List<PatientMed> patientMedRecords = new ArrayList<>();
	
	public PatientConsultation() {}
	
	public PatientConsultation(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientConsultId_generator")
	@SequenceGenerator(name="patientConsultId_generator", sequenceName = "drms.consultationseq", allocationSize=1)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "consultno", length = 20)
	public String getConsultNo() {
		return consultNo;
	}

	public void setConsultNo(String consultNo) {
		this.consultNo = consultNo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientsystemid", nullable = false)
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "professionalid", nullable = false)
	public Professional getProfessional() {
		return professional;
	}
	
	public void setProfessional(Professional professional) {
		this.professional = professional;
	}
	
	@Column(name = "consultationdate")
	public Date getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patientConsultation")
	@Where(clause = "active = true")
	public List<PatientMed> getPatientMedRecords() {
		return patientMedRecords;
	}

	public void setPatientMedRecords(List<PatientMed> patientMedRecords) {
		this.patientMedRecords = patientMedRecords;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "statusid", nullable = false)
	public ListValue getStatus() {
		return status;
	}

	public void setStatus(ListValue status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentstatusid", nullable = false)
	public ListValue getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(ListValue paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Transient
	public BigDecimal getTotalMedAmount() {
		double total = 0.00;
		for (PatientMed item : this.patientMedRecords) {
			total += item.getAmount().doubleValue();
		}
		return BigDecimal.valueOf(total);
	}

	public void setTotalMedAmount(BigDecimal totalMedAmount) {
		this.totalMedAmount = totalMedAmount;
	}
	
	@Column(name = "chiefcomplaint")
	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	@Column(name = "diagnosis")
	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Column(name = "medicationstatement")
	public String getMedicationStatement() {
		return medicationStatement;
	}

	public void setMedicationStatement(String medicationStatement) {
		this.medicationStatement = medicationStatement;
	}

	@Column(name = "consultationprocedure")
	public String getConsultationProcedure() {
		return consultationProcedure;
	}

	public void setConsultationProcedure(String consultationProcedure) {
		this.consultationProcedure = consultationProcedure;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "nextconsultationdate")
	public Date getNextConsultDate() {
		return nextConsultDate;
	}

	public void setNextConsultDate(Date nextConsultDate) {
		this.nextConsultDate = nextConsultDate;
	}

	@Override
	public String toString() {
		//shorten this string because it can cause stackoverflow error
		return "PatientConsultation [id=" + id + ", consultNo=" + consultNo
				+ ", patient=" + (patient!=null ? String.valueOf(patient.getId()) : "null") + ", professional=" + (professional!=null ? String.valueOf(professional.getId()) : "null")
				+ ", consultDate=" + consultDate + ", age=" + age + ", height=" + height + ", weight=" + weight + ", status="
				+ (status!=null ? String.valueOf(status.getId()) : "null") + ", paymentStatus=" + (paymentStatus!=null ? String.valueOf(paymentStatus.getId()) : "null") + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + ", totalMedAmount=" + totalMedAmount + "]";
	}

	@Transient
	public Integer getLabExamId() {
		return labExamId;
	}

	public void setLabExamId(Integer labExamId) {
		this.labExamId = labExamId;
	}
	
	@Transient
	public Integer getMedId() {
		return medId;
	}

	public void setMedId(Integer medId) {
		this.medId = medId;
	}

	@Column(name = "height")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Column(name = "weight")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}	
	
	
}
