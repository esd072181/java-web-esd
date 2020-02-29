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
@Table(name = "iteminventorydetails", schema = "sims")
public class ItemInventoryDetails implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private ItemInventory itemInventory;
	private Integer physicalQty;
	private Integer inQty;
	private Integer outQty;
	private Integer updatedQty;
	private ListValue module;
	private String transRefNo;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemInventoryDetailsId_generator")
	@SequenceGenerator(name="itemInventoryDetailsId_generator", sequenceName = "sims.iteminventorydetailsseq", allocationSize=1)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "iteminventoryid", nullable = false)
	public ItemInventory getItemInventory() {
		return itemInventory;
	}
	public void setItemInventory(ItemInventory itemInventory) {
		this.itemInventory = itemInventory;
	}

	@Column(name = "physicalqty")
	public Integer getPhysicalQty() {
		return physicalQty;
	}

	public void setPhysicalQty(Integer physicalQty) {
		this.physicalQty = physicalQty;
	}

	@Column(name = "inqty")
	public Integer getInQty() {
		return inQty;
	}

	public void setInQty(Integer inQty) {
		this.inQty = inQty;
	}
	
	@Column(name = "outqty")
	public Integer getOutQty() {
		return outQty;
	}

	public void setOutQty(Integer outQty) {
		this.outQty = outQty;
	}
	
	@Column(name = "updatedqty")
	public Integer getUpdatedQty() {
		return updatedQty;
	}

	public void setUpdatedQty(Integer updatedQty) {
		this.updatedQty = updatedQty;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "moduleid", nullable = false)
	public ListValue getModule() {
		return module;
	}

	public void setModule(ListValue module) {
		this.module = module;
	}

	@Column(name = "transrefno", length = 20)
	public String getTransRefNo() {
		return transRefNo;
	}

	public void setTransRefNo(String transRefNo) {
		this.transRefNo = transRefNo;
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
		return "ItemInventoryDetails [id=" + id + ", itemInventory="
				+ (itemInventory!=null ? itemInventory.getId() : "0") + ", physicalQty=" + physicalQty + ", inQty="
				+ inQty + ", outQty=" + outQty + ", updatedQty=" + updatedQty
				+ ", module=" + (module!=null ? module.getId() : "0") + ", transRefNo=" + transRefNo
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
				+ ", version=" + version + ", active=" + active + "]";
	}



}
