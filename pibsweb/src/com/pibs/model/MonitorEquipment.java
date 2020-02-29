package com.pibs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Edward.David
 * @since 14Feb2018
 */
public class MonitorEquipment implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int patientCaseSystemId;
	private int equipmentId;
	private int qty;
	private BigDecimal fee;
	private BigDecimal amount;
	private Date dateTaken;
	private String timeTaken;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String itemName;
	private String itemDescription;
	
	public String getTimeTaken() {
		return timeTaken;
	}



	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	
	public MonitorEquipment() {}



	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public int getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @return
	 */
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}



	/**
	 * @return
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param b
	 */
	public void setActive(boolean b) {
		active = b;
	}

	/**
	 * @param i
	 */
	public void setCreatedBy(int i) {
		createdBy = i;
	}

	/**
	 * @param timestamp
	 */
	public void setCreatedOn(Timestamp timestamp) {
		createdOn = timestamp;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @param i
	 */
	public void setModifiedBy(int i) {
		modifiedBy = i;
	}

	/**
	 * @param timestamp
	 */
	public void setModifiedOn(Timestamp timestamp) {
		modifiedOn = timestamp;
	}



	/**
	 * @param i
	 */
	public void setVersion(int i) {
		version = i;
	}



	public int getPatientCaseSystemId() {
		return patientCaseSystemId;
	}



	public void setPatientCaseSystemId(int patientCaseSystemId) {
		this.patientCaseSystemId = patientCaseSystemId;
	}






	public int getEquipmentId() {
		return equipmentId;
	}



	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}



	public Date getDateTaken() {
		return dateTaken;
	}



	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}






	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public BigDecimal getAmount() {
		return amount;
	}



	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	public BigDecimal getFee() {
		return fee;
	}



	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public String getItemDescription() {
		return itemDescription;
	}



	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}






	
	
}
