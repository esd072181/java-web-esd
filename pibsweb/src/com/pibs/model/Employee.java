package com.pibs.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String lastName;
	private String firstName;
	private String middleName;
	private int empCategoryId;
	private int empPositionId;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String empCategory;//non-persistent
	private String empPosition;//non-persistent
	
	private String fullName;
	
	public Employee() {}
	

	public String getEmpCategory() {
		return empCategory;
	}

	public void setEmpCategory(String empCategory) {
		this.empCategory = empCategory;
	}

	public int getEmpCategoryId() {
		return empCategoryId;
	}

	public void setEmpCategoryId(int empCategoryId) {
		this.empCategoryId = empCategoryId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName() {
		this.fullName = getLastName() + ", " + getFirstName() + " " + getMiddleName() ;
	}


	public int getEmpPositionId() {
		return empPositionId;
	}


	public void setEmpPositionId(int empPositionId) {
		this.empPositionId = empPositionId;
	}


	public String getEmpPosition() {
		return empPosition;
	}


	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}
	
	
	
	
}
