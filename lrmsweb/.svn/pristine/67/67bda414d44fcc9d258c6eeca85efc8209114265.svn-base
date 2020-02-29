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
@Table(name = "patientfecalysis", schema = "lrms")
public class PatientFecalysis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private PatientLabExam patientLabExam;
	private String color;
	private String consistency;
	private String occultBlood;
	private String others1;
	private String pusCells;
	private String rbc;
	private String fatGlobules;
	private String macrophage;
	private String yeastCells;
	private String others2;
	private String ascarisl;
	private String trichiurist;
	private String enterobiusv;
	private String hookWorm;
	private String ecoli;
	private String ehistolytica;
	private String glamblia;
	private String thominis;
	private String strongyloides;
	private String others3;
	private String remarks;
	private Professional pic;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;

	
	public PatientFecalysis() {}
	
	public PatientFecalysis(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientFecalysisId_generator")
	@SequenceGenerator(name="patientFecalysisId_generator", sequenceName = "lrms.fecalysisseq", allocationSize=1)
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

	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	@Column(name = "consistency")
	public String getConsistency() {
		return consistency;
	}

	public void setConsistency(String consistency) {
		this.consistency = consistency;
	}

	@Column(name = "occultblood")
	public String getOccultBlood() {
		return occultBlood;
	}

	public void setOccultBlood(String occultBlood) {
		this.occultBlood = occultBlood;
	}

	@Column(name = "others1")
	public String getOthers1() {
		return others1;
	}

	public void setOthers1(String others1) {
		this.others1 = others1;
	}

	@Column(name = "puscells")
	public String getPusCells() {
		return pusCells;
	}

	public void setPusCells(String pusCells) {
		this.pusCells = pusCells;
	}

	@Column(name = "rbc")
	public String getRbc() {
		return rbc;
	}

	public void setRbc(String rbc) {
		this.rbc = rbc;
	}

	@Column(name = "fatglobules")
	public String getFatGlobules() {
		return fatGlobules;
	}

	public void setFatGlobules(String fatGlobules) {
		this.fatGlobules = fatGlobules;
	}

	@Column(name = "macrophage")
	public String getMacrophage() {
		return macrophage;
	}

	public void setMacrophage(String macrophage) {
		this.macrophage = macrophage;
	}

	@Column(name = "yeastcells")
	public String getYeastCells() {
		return yeastCells;
	}

	public void setYeastCells(String yeastCells) {
		this.yeastCells = yeastCells;
	}

	@Column(name = "others2")
	public String getOthers2() {
		return others2;
	}

	public void setOthers2(String others2) {
		this.others2 = others2;
	}

	@Column(name = "ascarisl")
	public String getAscarisl() {
		return ascarisl;
	}

	public void setAscarisl(String ascarisl) {
		this.ascarisl = ascarisl;
	}
	
	@Column(name = "trichiurist")
	public String getTrichiurist() {
		return trichiurist;
	}

	public void setTrichiurist(String trichiurist) {
		this.trichiurist = trichiurist;
	}

	@Column(name = "enterobiusv")
	public String getEnterobiusv() {
		return enterobiusv;
	}

	public void setEnterobiusv(String enterobiusv) {
		this.enterobiusv = enterobiusv;
	}

	@Column(name = "hookworm")
	public String getHookWorm() {
		return hookWorm;
	}

	public void setHookWorm(String hookWorm) {
		this.hookWorm = hookWorm;
	}

	@Column(name = "ecoli")
	public String getEcoli() {
		return ecoli;
	}

	public void setEcoli(String ecoli) {
		this.ecoli = ecoli;
	}

	@Column(name = "ehistolytica")
	public String getEhistolytica() {
		return ehistolytica;
	}

	public void setEhistolytica(String ehistolytica) {
		this.ehistolytica = ehistolytica;
	}

	@Column(name = "glamblia")
	public String getGlamblia() {
		return glamblia;
	}

	public void setGlamblia(String glamblia) {
		this.glamblia = glamblia;
	}

	@Column(name = "thominis")
	public String getThominis() {
		return thominis;
	}

	public void setThominis(String thominis) {
		this.thominis = thominis;
	}

	@Column(name = "strongyloides")
	public String getStrongyloides() {
		return strongyloides;
	}

	public void setStrongyloides(String strongyloides) {
		this.strongyloides = strongyloides;
	}

	@Column(name = "others3")
	public String getOthers3() {
		return others3;
	}

	public void setOthers3(String others3) {
		this.others3 = others3;
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
		return "PatientFecalysis [id=" + id + ", patientLabExam="
				+ (patientLabExam!=null ? String.valueOf(patientLabExam.getId()) : "null") + ", color=" + color + ", consistency="
				+ consistency + ", occultBlood=" + occultBlood + ", others1="
				+ others1 + ", pusCells=" + pusCells + ", rbc=" + rbc
				+ ", fatGlobules=" + fatGlobules + ", macrophage=" + macrophage
				+ ", yeastCells=" + yeastCells + ", others2=" + others2
				+ ", ascarisl=" + ascarisl + ", trichiurist=" + trichiurist
				+ ", enterobiusv=" + enterobiusv + ", hookWorm=" + hookWorm
				+ ", ecoli=" + ecoli + ", ehistolytica=" + ehistolytica
				+ ", glamblia=" + glamblia + ", thominis=" + thominis
				+ ", strongyloides=" + strongyloides + ", others3=" + others3
				+ ", remarks=" + remarks + ", pic=" + (pic!=null ? String.valueOf(pic.getId()) : "null") + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + "]";
	}

	
	
}
