package com.sims.model;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author dward
 *
 */

@Entity
@Table(name = "physicalinventorydetails", schema = "sims")
public class PhysicalInventoryDetails implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private PhysicalInventory physicalInventory;
	private Item item;
	private Integer systemQty;
	private Integer physicalCount;
	private Integer qtyVariance;
	private String variance;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "physicalInventoryDetailsId_generator")
	@SequenceGenerator(name="physicalInventoryDetailsId_generator", sequenceName = "sims.physicalinventorydetailsseq", allocationSize=1)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "physicalinventoryid", nullable = false)
	public PhysicalInventory getPhysicalInventory() {
		return physicalInventory;
	}
	public void setPhysicalInventory(PhysicalInventory physicalInventory) {
		this.physicalInventory = physicalInventory;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itemid", nullable = false)
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "systemqty")
	public Integer getSystemQty() {
		return systemQty;
	}

	public void setSystemQty(Integer systemQty) {
		this.systemQty = systemQty;
	}

	@Column(name = "physicalcount")
	public Integer getPhysicalCount() {
		return physicalCount;
	}

	public void setPhysicalCount(Integer physicalCount) {
		this.physicalCount = physicalCount;
	}
	
	@Column(name = "qtyvariance")
	public Integer getQtyVariance() {
		return qtyVariance;
	}

	public void setQtyVariance(Integer qtyVariance) {
		this.qtyVariance = qtyVariance;
	}
	
	@Column(name = "variance", length = 10)
	public String getVariance() {
		return variance;
	}

	public void setVariance(String variance) {
		this.variance = variance;
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
		return "PhysicalInventoryDetails [id=" + id + ", physicalInventory="
				+ (physicalInventory!=null ? physicalInventory.getId() : "0") + ", item=" + (item!=null ? item.getId() : "0") + ", systemQty="
				+ systemQty + ", physicalCount=" + physicalCount
				+ ", qtyVariance=" + qtyVariance + ", variance=" + variance
				+ ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + ", version=" + version
				+ ", active=" + active + "]";
	}

	

}
