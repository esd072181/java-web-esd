package com.transport.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.transport.util.DateUtils;

/**
 * 
 * @author edwarddavid
 * @since 21Mar2020
 * DateUpdated: 02Aug2020
 */
public class InspectionDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int headerId;
	private int inspectionId;
	private int statusId;
	private String remarks;
	private Date planDate;
	private Date actualDate;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	//non-persistent
	private String mainCategoryName;
	private String categoryName;
	private Integer categoryNo;
	private String itemNo;
	private String subItemNo;
	private String description;
	private Boolean labelOnly;
	private Integer sequenceOrder;
	
	public InspectionDetails() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public int getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(int inspectionId) {
		this.inspectionId = inspectionId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getMainCategoryName() {
		return mainCategoryName;
	}

	public void setMainCategoryName(String mainCategoryName) {
		this.mainCategoryName = mainCategoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getSubItemNo() {
		return subItemNo;
	}

	public void setSubItemNo(String subItemNo) {
		this.subItemNo = subItemNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getLabelOnly() {
		return labelOnly;
	}

	public void setLabelOnly(Boolean labelOnly) {
		this.labelOnly = labelOnly;
	}

	public Integer getSequenceOrder() {
		return sequenceOrder;
	}

	public void setSequenceOrder(Integer sequenceOrder) {
		this.sequenceOrder = sequenceOrder;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Date getActualDate() {
		return actualDate;
	}

	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}
	
	public String getPlanDateStr() throws Exception {
		return planDate!=null ? DateUtils.sqlDateToString(planDate) : "";
	}
	
	public String getActualDateStr() throws Exception {
		return actualDate!=null ? DateUtils.sqlDateToString(actualDate): "";
	}
	

}
