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
@Table(name = "patienturinalysis", schema = "lrms")
public class PatientUrinalysis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private PatientLabExam patientLabExam;
	private String color;
	private String transparency;
	private String reaction;
	private String ph;
	private String specificGravity;
	private String chemicalTest;
	private String glucose;
	private String protein;
	private String urobili;
	private String bili;
	private String ketone;
	private String nitrite;
	private String cells;
	private String rbc;
	private String pusCells;
	private String epiCells;
	private String mucThreads;
	private String yeastCells;
	private String renalCells;
	private String bacteria;
	private String others1;
	private String hyaline;
	private String granular;
	private String waxy;
	private String amorphurate;
	private String uricAcid;
	private String calcium;
	private String amorPhphosphates;
	private String triple;
	private String others2;
	private String pregtest;	
	private String remarks;
	private Professional pic;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;

	
	public PatientUrinalysis() {}
	
	public PatientUrinalysis(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientUrinalysisId_generator")
	@SequenceGenerator(name="patientUrinalysisId_generator", sequenceName = "lrms.urinalysisseq", allocationSize=1)
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

	@Column(name = "transparency")
	public String getTransparency() {
		return transparency;
	}

	public void setTransparency(String transparency) {
		this.transparency = transparency;
	}

	@Column(name = "reaction")
	public String getReaction() {
		return reaction;
	}

	public void setReaction(String reaction) {
		this.reaction = reaction;
	}

	@Column(name = "ph")
	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	@Column(name = "specificgravity")
	public String getSpecificGravity() {
		return specificGravity;
	}

	public void setSpecificGravity(String specificGravity) {
		this.specificGravity = specificGravity;
	}

	@Column(name = "chemicaltest")
	public String getChemicalTest() {
		return chemicalTest;
	}

	public void setChemicalTest(String chemicalTest) {
		this.chemicalTest = chemicalTest;
	}

	@Column(name = "glucose")
	public String getGlucose() {
		return glucose;
	}

	public void setGlucose(String glucose) {
		this.glucose = glucose;
	}

	@Column(name = "protein")
	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	@Column(name = "urobili")
	public String getUrobili() {
		return urobili;
	}

	public void setUrobili(String urobili) {
		this.urobili = urobili;
	}

	@Column(name = "bili")
	public String getBili() {
		return bili;
	}

	public void setBili(String bili) {
		this.bili = bili;
	}

	@Column(name = "ketone")
	public String getKetone() {
		return ketone;
	}

	public void setKetone(String ketone) {
		this.ketone = ketone;
	}

	@Column(name = "nitrite")
	public String getNitrite() {
		return nitrite;
	}

	public void setNitrite(String nitrite) {
		this.nitrite = nitrite;
	}

	@Column(name = "cells")
	public String getCells() {
		return cells;
	}

	public void setCells(String cells) {
		this.cells = cells;
	}

	@Column(name = "rbc")
	public String getRbc() {
		return rbc;
	}

	public void setRbc(String rbc) {
		this.rbc = rbc;
	}

	@Column(name = "puscells")
	public String getPusCells() {
		return pusCells;
	}

	public void setPusCells(String pusCells) {
		this.pusCells = pusCells;
	}

	@Column(name = "epicells")
	public String getEpiCells() {
		return epiCells;
	}

	public void setEpiCells(String epiCells) {
		this.epiCells = epiCells;
	}

	@Column(name = "mucthreads")
	public String getMucThreads() {
		return mucThreads;
	}

	public void setMucThreads(String mucThreads) {
		this.mucThreads = mucThreads;
	}

	@Column(name = "yeastcells")
	public String getYeastCells() {
		return yeastCells;
	}

	public void setYeastCells(String yeastCells) {
		this.yeastCells = yeastCells;
	}

	@Column(name = "renalcells")
	public String getRenalCells() {
		return renalCells;
	}

	public void setRenalCells(String renalCells) {
		this.renalCells = renalCells;
	}

	@Column(name = "bacteria")
	public String getBacteria() {
		return bacteria;
	}

	public void setBacteria(String bacteria) {
		this.bacteria = bacteria;
	}

	@Column(name = "others1")
	public String getOthers1() {
		return others1;
	}

	public void setOthers1(String others1) {
		this.others1 = others1;
	}

	@Column(name = "hyaline")
	public String getHyaline() {
		return hyaline;
	}

	public void setHyaline(String hyaline) {
		this.hyaline = hyaline;
	}

	@Column(name = "granular")
	public String getGranular() {
		return granular;
	}

	public void setGranular(String granular) {
		this.granular = granular;
	}

	@Column(name = "waxy")
	public String getWaxy() {
		return waxy;
	}

	public void setWaxy(String waxy) {
		this.waxy = waxy;
	}

	@Column(name = "amorphurate")
	public String getAmorphurate() {
		return amorphurate;
	}

	public void setAmorphurate(String amorphurate) {
		this.amorphurate = amorphurate;
	}

	@Column(name = "uricacid")
	public String getUricAcid() {
		return uricAcid;
	}

	public void setUricAcid(String uricAcid) {
		this.uricAcid = uricAcid;
	}

	@Column(name = "calcium")
	public String getCalcium() {
		return calcium;
	}

	public void setCalcium(String calcium) {
		this.calcium = calcium;
	}

	@Column(name = "amorphphosphates")
	public String getAmorPhphosphates() {
		return amorPhphosphates;
	}

	public void setAmorPhphosphates(String amorPhphosphates) {
		this.amorPhphosphates = amorPhphosphates;
	}

	@Column(name = "triple")
	public String getTriple() {
		return triple;
	}

	public void setTriple(String triple) {
		this.triple = triple;
	}

	@Column(name = "others2")
	public String getOthers2() {
		return others2;
	}

	public void setOthers2(String others2) {
		this.others2 = others2;
	}

	@Column(name = "pregtest")
	public String getPregtest() {
		return pregtest;
	}

	public void setPregtest(String pregtest) {
		this.pregtest = pregtest;
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
		return "PatientUrinalysis [id=" + id + ", patientLabExam="
				+ (patientLabExam!=null ? String.valueOf(patientLabExam.getId()) : "null") + ", color=" + color + ", transparency="
				+ transparency + ", reaction=" + reaction + ", ph=" + ph
				+ ", specificGravity=" + specificGravity + ", chemicalTest="
				+ chemicalTest + ", glucose=" + glucose + ", protein="
				+ protein + ", urobili=" + urobili + ", bili=" + bili
				+ ", ketone=" + ketone + ", nitrite=" + nitrite + ", cells="
				+ cells + ", rbc=" + rbc + ", pusCells=" + pusCells
				+ ", epiCells=" + epiCells + ", mucThreads=" + mucThreads
				+ ", yeastCells=" + yeastCells + ", renalCells=" + renalCells
				+ ", bacteria=" + bacteria + ", others1=" + others1
				+ ", hyaline=" + hyaline + ", granular=" + granular + ", waxy="
				+ waxy + ", amorphurate=" + amorphurate + ", uricAcid="
				+ uricAcid + ", calcium=" + calcium + ", amorPhphosphates="
				+ amorPhphosphates + ", triple=" + triple + ", others2="
				+ others2 + ", pregtest=" + pregtest + ", remarks=" + remarks
				+ ", pic=" + (pic!=null ? String.valueOf(pic.getId()) : "null") + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn="
				+ modifiedOn + ", version=" + version + "]";
	}

	
}
