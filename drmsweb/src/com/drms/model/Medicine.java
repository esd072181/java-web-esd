package com.drms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author dward
 *
 */
@Entity
@Table(name = "med", schema = "drms")
public class Medicine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String itemCode;
	private String description;
	private String genericName;
	private String remarks;
	private String lotNo;
	private Date dateManufactured;
	private Date expirationDate;
	private BigDecimal retailSellingPrice;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;

	
	public Medicine() {}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicineId_generator")
	@SequenceGenerator(name="medicineId_generator", sequenceName = "drms.medseq", allocationSize=1)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "itemcode", length = 20)
	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "description", length = 60)
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "genericname", length = 50)
	public String getGenericName() {
		return genericName;
	}


	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	@Column(name = "remarks", length = 100)
	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "lotno", length = 50)
	public String getLotNo() {
		return lotNo;
	}


	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	@Column(name = "datemanufactured")
	public Date getDateManufactured() {
		return dateManufactured;
	}


	public void setDateManufactured(Date dateManufactured) {
		this.dateManufactured = dateManufactured;
	}

	@Column(name = "expirationdate")
	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "retailsellingprice", precision = 9)
	public BigDecimal getRetailSellingPrice() {
		return retailSellingPrice;
	}


	public void setRetailSellingPrice(BigDecimal retailSellingPrice) {
		this.retailSellingPrice = retailSellingPrice;
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
	
	
	
}
