package com.sims.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listvalue", schema = "sims")
public class ListValue implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private Integer listTypeId;
	private String listValue;
	private String description;
	private Integer sequenceOrder;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;

	public ListValue() {}
	
	public ListValue(int id) {
		this.id = id;
	}
	

	/**
	 * @return
	 */
	@Column(name = "active")
	public Boolean isActive() {
		return active;
	}

	/**
	 * @return
	 */
	@Column(name = "createdby")
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return
	 */
	@Column(name = "createdon")
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return
	 */
	@Column(name = "description", length = 50)
	public String getDescription() {
		return description;
	}

	/**
	 * @return
	 */
	@Id
	public Integer getId() {
		return id;
	}

	/**
	 * @return
	 */
	@Column(name="listtypeid")
	public Integer getListTypeId() {
		return listTypeId;
	}

	/**
	 * @return
	 */
	@Column(name="listvalue", length=40)
	public String getListValue() {
		return listValue;
	}

	/**
	 * @return
	 */
	@Column(name="modifiedby")
	public Integer getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @return
	 */
	@Column(name="modifiedon")
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @return
	 */
	@Column(name="sequenceorder")
	public Integer getSequenceOrder() {
		return sequenceOrder;
	}

	/**
	 * @return
	 */
	@Column(name="version")
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param b
	 */
	public void setActive(Boolean b) {
		active = b;
	}

	/**
	 * @param i
	 */
	public void setCreatedBy(Integer i) {
		createdBy = i;
	}

	/**
	 * @param timestamp
	 */
	public void setCreatedOn(Timestamp timestamp) {
		createdOn = timestamp;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param i
	 */
	public void setId(Integer i) {
		id = i;
	}

	/**
	 * @param i
	 */
	public void setListTypeId(Integer i) {
		listTypeId = i;
	}

	/**
	 * @param string
	 */
	public void setListValue(String string) {
		listValue = string;
	}

	/**
	 * @param i
	 */
	public void setModifiedBy(Integer i) {
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
	public void setSequenceOrder(Integer i) {
		sequenceOrder = i;
	}

	/**
	 * @param i
	 */
	public void setVersion(Integer i) {
		version = i;
	}

	@Override
	public String toString() {
		return "ListValue [id=" + id + "]";
	}

	
}
