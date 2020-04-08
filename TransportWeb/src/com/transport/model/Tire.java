package com.transport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 08Apr2020
 */
public class Tire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int brandId;
	private String serialNo;
	private String recapNo;
	private String sizeAndPly;
	private BigDecimal price;
	private Date datePurchased;
	private Date datePurchasedForRecap1;
	private Date datePurchasedForRecap2;
	private String invoiceNo;
	private String analysis;
	private String comments;
	private String retired;
	private Date dateRetired;
	private String lorryNo;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	//non-persistent
	private String brandName;
	
	
	public Tire(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getRecapNo() {
		return recapNo;
	}

	public void setRecapNo(String recapNo) {
		this.recapNo = recapNo;
	}

	public String getSizeAndPly() {
		return sizeAndPly;
	}

	public void setSizeAndPly(String sizeAndPly) {
		this.sizeAndPly = sizeAndPly;
	}

	public Date getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}

	public String getRetired() {
		return retired;
	}

	public void setRetired(String retired) {
		this.retired = retired;
	}
	
	public Date getDateRetired() {
		return dateRetired;
	}

	public void setDateRetired(Date dateRetired) {
		this.dateRetired = dateRetired;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDatePurchasedForRecap1() {
		return datePurchasedForRecap1;
	}

	public void setDatePurchasedForRecap1(Date datePurchasedForRecap1) {
		this.datePurchasedForRecap1 = datePurchasedForRecap1;
	}

	public Date getDatePurchasedForRecap2() {
		return datePurchasedForRecap2;
	}

	public void setDatePurchasedForRecap2(Date datePurchasedForRecap2) {
		this.datePurchasedForRecap2 = datePurchasedForRecap2;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLorryNo() {
		return lorryNo;
	}

	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}	

	
	
}
