package com.lrms.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author dward
 *
 */
@Entity
@Table(name = "patienthematology", schema = "lrms")
public class PatientHematology implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private PatientLabExam patientLabExam;
	private String wbc;
	private String rbc;
	private String hemo;
	private String hema;
	private String plate;
	private String blood;
	private String retic;
	private String polys;
	private String lympho;
	private String mono;
	private String eosino;
	private String baso;
	private String atyp;
	private String esr;
	private String ct;
	private String bt;
	private String patient;
	private String control;
	private String normal;
	private String thromb;
	private String remarks;
	private Professional pic;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;

	
	public PatientHematology() {}
	
	public PatientHematology(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientHematologyId_generator")
	@SequenceGenerator(name="patientHematologyId_generator", sequenceName = "lrms.hematologyseq", allocationSize=1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientlabexamid", nullable = false)
	public PatientLabExam getPatientLabExam() {
		return patientLabExam;
	}

	public void setPatientLabExam(PatientLabExam patientLabExam) {
		this.patientLabExam = patientLabExam;
	}

	@Column(name = "wbc")
	public String getWbc() {
		return wbc;
	}

	public void setWbc(String wbc) {
		this.wbc = wbc;
	}

	@Column(name = "rbc")
	public String getRbc() {
		return rbc;
	}

	public void setRbc(String rbc) {
		this.rbc = rbc;
	}

	@Column(name = "hemo")
	public String getHemo() {
		return hemo;
	}

	public void setHemo(String hemo) {
		this.hemo = hemo;
	}

	@Column(name = "hema")
	public String getHema() {
		return hema;
	}

	public void setHema(String hema) {
		this.hema = hema;
	}

	@Column(name = "plate")
	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	@Column(name = "blood")
	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	@Column(name = "retic")
	public String getRetic() {
		return retic;
	}

	public void setRetic(String retic) {
		this.retic = retic;
	}

	@Column(name = "polys")
	public String getPolys() {
		return polys;
	}

	public void setPolys(String polys) {
		this.polys = polys;
	}

	@Column(name = "lympho")
	public String getLympho() {
		return lympho;
	}

	public void setLympho(String lympho) {
		this.lympho = lympho;
	}

	@Column(name = "mono")
	public String getMono() {
		return mono;
	}

	public void setMono(String mono) {
		this.mono = mono;
	}

	@Column(name = "eosino")
	public String getEosino() {
		return eosino;
	}

	public void setEosino(String eosino) {
		this.eosino = eosino;
	}

	@Column(name = "baso")
	public String getBaso() {
		return baso;
	}

	public void setBaso(String baso) {
		this.baso = baso;
	}

	@Column(name = "atyp")
	public String getAtyp() {
		return atyp;
	}

	public void setAtyp(String atyp) {
		this.atyp = atyp;
	}

	@Column(name = "esr")
	public String getEsr() {
		return esr;
	}

	public void setEsr(String esr) {
		this.esr = esr;
	}

	@Column(name = "ct")
	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	@Column(name = "bt")
	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}

	@Column(name = "patient")
	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	@Column(name = "control")
	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	@Column(name = "normal")
	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	@Column(name = "thromb")
	public String getThromb() {
		return thromb;
	}
 
	public void setThromb(String thromb) {
		this.thromb = thromb;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "picid", nullable = true)	
	public Professional getPic() {
		return pic;
	}

	public void setPic(Professional pic) {
		this.pic = pic;
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
		return "PatientHematology [id=" + id + ", patientLabExam="
				+ (patientLabExam!=null ? String.valueOf(patientLabExam.getId()) : "null") + ", wbc=" + wbc + ", rbc=" + rbc + ", hemo="
				+ hemo + ", hema=" + hema + ", plate=" + plate + ", blood="
				+ blood + ", retic=" + retic + ", polys=" + polys + ", lympho="
				+ lympho + ", mono=" + mono + ", eosino=" + eosino + ", baso="
				+ baso + ", atyp=" + atyp + ", esr=" + esr + ", ct=" + ct
				+ ", bt=" + bt + ", patient=" + patient + ", control="
				+ control + ", normal=" + normal + ", thromb=" + thromb
				+ ", remarks=" + remarks + ", pic=" + (pic!=null ? String.valueOf(pic.getId()) : "null") + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + "]";
	}

	
	
}
