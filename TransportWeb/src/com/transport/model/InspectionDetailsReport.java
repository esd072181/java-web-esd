package com.transport.model;

import java.io.Serializable;

/**
 * 
 * @author edwarddavid
 * @since 28Mar2020
 * DateUpdated: 09Aug2020
 */
public class InspectionDetailsReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mainCategory;
	private String category;
	private String itemNo;
	private String subItemNo;
	private String itemDescription;
	private Boolean labelOnly;
	private String subItemDescription;
	private String imgGoodForItem;
	private String imgGoodForSubItem;
	private String imgRepairForItem;
	private String imgRepairForSubItem;
	private String imgReplaceForItem;
	private String imgReplaceForSubItem;
	private String imgNAForItem;
	private String imgNAForSubItem;
	private String remarksForItem;
	private String remarksForSubItem;
	private String planDateStrForItem;
	private String actualDateStrForItem;
	private String planDateStrForSubItem;
	private String actualDateStrForSubItem;
	
	public InspectionDetailsReport() {}


	public String getImgGoodForItem() {
		return imgGoodForItem;
	}


	public void setImgGoodForItem(String imgGoodForItem) {
		this.imgGoodForItem = imgGoodForItem;
	}


	public String getImgGoodForSubItem() {
		return imgGoodForSubItem;
	}


	public void setImgGoodForSubItem(String imgGoodForSubItem) {
		this.imgGoodForSubItem = imgGoodForSubItem;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getSubItemDescription() {
		return subItemDescription;
	}

	public void setSubItemDescription(String subItemDescription) {
		this.subItemDescription = subItemDescription;
	}


	public Boolean getLabelOnly() {
		return labelOnly;
	}


	public void setLabelOnly(Boolean labelOnly) {
		this.labelOnly = labelOnly;
	}


	public String getImgRepairForItem() {
		return imgRepairForItem;
	}


	public void setImgRepairForItem(String imgRepairForItem) {
		this.imgRepairForItem = imgRepairForItem;
	}


	public String getImgRepairForSubItem() {
		return imgRepairForSubItem;
	}


	public void setImgRepairForSubItem(String imgRepairForSubItem) {
		this.imgRepairForSubItem = imgRepairForSubItem;
	}


	public String getImgReplaceForItem() {
		return imgReplaceForItem;
	}


	public void setImgReplaceForItem(String imgReplaceForItem) {
		this.imgReplaceForItem = imgReplaceForItem;
	}


	public String getImgReplaceForSubItem() {
		return imgReplaceForSubItem;
	}


	public void setImgReplaceForSubItem(String imgReplaceForSubItem) {
		this.imgReplaceForSubItem = imgReplaceForSubItem;
	}


	public String getImgNAForItem() {
		return imgNAForItem;
	}


	public void setImgNAForItem(String imgNAForItem) {
		this.imgNAForItem = imgNAForItem;
	}


	public String getImgNAForSubItem() {
		return imgNAForSubItem;
	}


	public void setImgNAForSubItem(String imgNAForSubItem) {
		this.imgNAForSubItem = imgNAForSubItem;
	}


	public String getRemarksForItem() {
		return remarksForItem;
	}


	public void setRemarksForItem(String remarksForItem) {
		this.remarksForItem = remarksForItem;
	}


	public String getRemarksForSubItem() {
		return remarksForSubItem;
	}


	public void setRemarksForSubItem(String remarksForSubItem) {
		this.remarksForSubItem = remarksForSubItem;
	}


	public String getMainCategory() {
		return mainCategory;
	}


	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}


	public String getPlanDateStrForItem() {
		return planDateStrForItem;
	}


	public void setPlanDateStrForItem(String planDateStrForItem) {
		this.planDateStrForItem = planDateStrForItem;
	}


	public String getActualDateStrForItem() {
		return actualDateStrForItem;
	}


	public void setActualDateStrForItem(String actualDateStrForItem) {
		this.actualDateStrForItem = actualDateStrForItem;
	}


	public String getPlanDateStrForSubItem() {
		return planDateStrForSubItem;
	}


	public void setPlanDateStrForSubItem(String planDateStrForSubItem) {
		this.planDateStrForSubItem = planDateStrForSubItem;
	}


	public String getActualDateStrForSubItem() {
		return actualDateStrForSubItem;
	}


	public void setActualDateStrForSubItem(String actualDateStrForSubItem) {
		this.actualDateStrForSubItem = actualDateStrForSubItem;
	}



}
