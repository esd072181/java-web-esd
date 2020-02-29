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
@Table(name = "patientbloodchem", schema = "lrms")
public class PatientBloodChem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private PatientLabExam patientLabExam;
	private String fbs;
	private String rbs;
	private String timeLast;
	private String hbaic;
	private String chole;
	private String trig;
	private String hdl;
	private String ldl;
	private String vldl;
	private String ratio;
	private String uricAcid;
	private String bun;
	private String creat;
	private String sgot;
	private String sgpt;
	private String extraction;
	private String t3;
	private String t4;
	private String tsh;
	private String na;
	private String k;
	private String ca;
	private String cl;
	private String amv;
	private String lipase;
	private String alkaline;
	private String acid;
	private String total;
	private String albumin;
	private String globulin;
	private String agratio;	
	private String remarks;
	private Professional pic;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;

	
	public PatientBloodChem() {}
	
	public PatientBloodChem(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientBloodChemId_generator")
	@SequenceGenerator(name="patientBloodChemId_generator", sequenceName = "lrms.bloodchemseq", allocationSize=1)
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

	@Column(name = "fbs")
	public String getFbs() {
		return fbs;
	}

	public void setFbs(String fbs) {
		this.fbs = fbs;
	}

	@Column(name = "rbs")
	public String getRbs() {
		return rbs;
	}

	public void setRbs(String rbs) {
		this.rbs = rbs;
	}

	@Column(name = "timelast")
	public String getTimeLast() {
		return timeLast;
	}

	public void setTimeLast(String timeLast) {
		this.timeLast = timeLast;
	}

	@Column(name = "hbaic")
	public String getHbaic() {
		return hbaic;
	}

	public void setHbaic(String hbaic) {
		this.hbaic = hbaic;
	}

	@Column(name = "chole")
	public String getChole() {
		return chole;
	}

	public void setChole(String chole) {
		this.chole = chole;
	}

	@Column(name = "trig")
	public String getTrig() {
		return trig;
	}

	public void setTrig(String trig) {
		this.trig = trig;
	}

	@Column(name = "hdl")
	public String getHdl() {
		return hdl;
	}

	public void setHdl(String hdl) {
		this.hdl = hdl;
	}

	@Column(name = "ldl")
	public String getLdl() {
		return ldl;
	}

	public void setLdl(String ldl) {
		this.ldl = ldl;
	}

	@Column(name = "vldl")
	public String getVldl() {
		return vldl;
	}

	public void setVldl(String vldl) {
		this.vldl = vldl;
	}

	@Column(name = "ratio")
	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	@Column(name = "uricacid")
	public String getUricAcid() {
		return uricAcid;
	}

	public void setUricAcid(String uricAcid) {
		this.uricAcid = uricAcid;
	}

	@Column(name = "bun")
	public String getBun() {
		return bun;
	}

	public void setBun(String bun) {
		this.bun = bun;
	}

	@Column(name = "creat")
	public String getCreat() {
		return creat;
	}

	public void setCreat(String creat) {
		this.creat = creat;
	}

	@Column(name = "sgot")
	public String getSgot() {
		return sgot;
	}

	public void setSgot(String sgot) {
		this.sgot = sgot;
	}

	@Column(name = "sgpt")
	public String getSgpt() {
		return sgpt;
	}

	public void setSgpt(String sgpt) {
		this.sgpt = sgpt;
	}

	@Column(name = "extraction")
	public String getExtraction() {
		return extraction;
	}

	public void setExtraction(String extraction) {
		this.extraction = extraction;
	}

	@Column(name = "t3")
	public String getT3() {
		return t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}

	@Column(name = "t4")
	public String getT4() {
		return t4;
	}

	public void setT4(String t4) {
		this.t4 = t4;
	}

	@Column(name = "tsh")
	public String getTsh() {
		return tsh;
	}

	public void setTsh(String tsh) {
		this.tsh = tsh;
	}

	@Column(name = "na")
	public String getNa() {
		return na;
	}

	public void setNa(String na) {
		this.na = na;
	}

	@Column(name = "k")
	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	@Column(name = "ca")
	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	@Column(name = "cl")
	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	@Column(name = "amv")
	public String getAmv() {
		return amv;
	}

	public void setAmv(String amv) {
		this.amv = amv;
	}

	@Column(name = "lipase")
	public String getLipase() {
		return lipase;
	}

	public void setLipase(String lipase) {
		this.lipase = lipase;
	}

	@Column(name = "alkaline")
	public String getAlkaline() {
		return alkaline;
	}

	public void setAlkaline(String alkaline) {
		this.alkaline = alkaline;
	}

	@Column(name = "acid")
	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	@Column(name = "total")
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Column(name = "albumin")
	public String getAlbumin() {
		return albumin;
	}

	public void setAlbumin(String albumin) {
		this.albumin = albumin;
	}

	@Column(name = "globulin")
	public String getGlobulin() {
		return globulin;
	}

	public void setGlobulin(String globulin) {
		this.globulin = globulin;
	}

	@Column(name = "agratio")
	public String getAgratio() {
		return agratio;
	}

	public void setAgratio(String agratio) {
		this.agratio = agratio;
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
		return "PatientBloodChem [id=" + id + ", patientLabExam="
				+ (patientLabExam!=null ? String.valueOf(patientLabExam.getId()) : "null") + ", fbs=" + fbs + ", rbs=" + rbs
				+ ", timeLast=" + timeLast + ", hbaic=" + hbaic + ", chole="
				+ chole + ", trig=" + trig + ", hdl=" + hdl + ", ldl=" + ldl
				+ ", vldl=" + vldl + ", ratio=" + ratio + ", uricAcid="
				+ uricAcid + ", bun=" + bun + ", creat=" + creat + ", sgot="
				+ sgot + ", sgpt=" + sgpt + ", extraction=" + extraction
				+ ", t3=" + t3 + ", t4=" + t4 + ", tsh=" + tsh + ", na=" + na
				+ ", k=" + k + ", ca=" + ca + ", cl=" + cl + ", amv=" + amv
				+ ", lipase=" + lipase + ", alkaline=" + alkaline + ", acid="
				+ acid + ", total=" + total + ", albumin=" + albumin
				+ ", globulin=" + globulin + ", agratio=" + agratio
				+ ", remarks=" + remarks + ", pic=" + (pic!=null ? String.valueOf(pic.getId()) : "null") + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + "]";
	}

	
	
}
