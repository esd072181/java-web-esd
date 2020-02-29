package com.sims.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

/**
 * 
 * @author dward
 *
 */

@Entity
@Table(name = "physicalinventory", schema = "sims")
public class PhysicalInventory implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private String piNo;
	private Date dateOfInventory;
	private String inventoryBy;
	private String remarks;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	private Integer itemId; //transient
	
	private List<PhysicalInventoryDetails> piDetailsList = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "physicalInventory")
	@Where(clause = "Active = true")
	@OrderBy("item")
	public List<PhysicalInventoryDetails> getPiDetailsList() {
		return piDetailsList;
	}

	public void setPiDetailsList(List<PhysicalInventoryDetails> piDetailsList) {
		this.piDetailsList = piDetailsList;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "physicalInventoryId_generator")
	@SequenceGenerator(name="physicalInventoryId_generator", sequenceName = "sims.physicalinventoryseq", allocationSize=1)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "pino")
	public String getPiNo() {
		return piNo;
	}

	public void setPiNo(String piNo) {
		this.piNo = piNo;
	}
	
	@Column(name = "dateofinventory")
	public Date getDateOfInventory() {
		return dateOfInventory;
	}

	public void setDateOfInventory(Date dateOfInventory) {
		this.dateOfInventory = dateOfInventory;
	}

	@Column(name = "inventoryby", length = 30)
	public String getInventoryBy() {
		return inventoryBy;
	}

	public void setInventoryBy(String inventoryBy) {
		this.inventoryBy = inventoryBy;
	}
	
	@Column(name = "remarks", length = 100)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}



	@Override
	public String toString() {
		return "PhysicalInventory [id=" + id + ", piNo=" + piNo
				+ ", dateOfInventory=" + dateOfInventory + ", inventoryBy="
				+ inventoryBy + ", remarks=" + remarks + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy="
				+ modifiedBy + ", modifiedOn=" + modifiedOn + ", version="
				+ version + ", active=" + active + "]";
	}

	@Transient
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}




}
