package com.transport.model;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 
 * @author dward
 *
 */
public class DriverTraining implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int driverId;
	private String sss;
	private String pagibig;
	private String tin;
	private String picName;
	private File pic;
	private Date birthday;
	private int terminalId;
	private String articulated;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	private Date dateHired;
	private String licenseNo;
	private Date licenseValidity;
	private String contactNo;
	private String religion;
	private String gender;
	private String civilStatus;
	private String spouse;
	private String philhealthNo;
	private String height;
	private String weight;
	private String mothersName;
	private String fathersName;
	private String address;
	private String elementary;
	private String elementaryDate;
	private String secondary;
	private String secondaryDate;
	private String tertiary;
	private String tertiaryDate;
	private String employmentDateFrom1;
	private String employmentDateTo1;
	private String employmentPosition1;
	private String employmentCompany1;
	private String employmentDateFrom2;
	private String employmentDateTo2;
	private String employmentPosition2;
	private String employmentCompany2;
	private String employmentDateFrom3;
	private String employmentDateTo3;
	private String employmentPosition3;
	private String employmentCompany3;
	private Date ftw;
	private Date nbi;
	
	//non-persistent
	private String lastName;
	private String firstName;
	private String terminalName;
	private int age;
	private String picStr;


	public DriverTraining() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}



	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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


	public String getTerminalName() {
		return terminalName;
	}


	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getFullName() {
		return this.getLastName() + ", " + this.getFirstName();
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPicName() {
		return picName;
	}


	public void setPicName(String picName) {
		this.picName = picName;
	}


	public File getPic() {
		return pic;
	}


	public void setPic(File pic) {
		this.pic = pic;
	}


	public String getPicStr() {
		return picStr;
	}


	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}


	public String getSss() {
		return sss;
	}


	public void setSss(String sss) {
		this.sss = sss;
	}


	public String getPagibig() {
		return pagibig;
	}


	public void setPagibig(String pagibig) {
		this.pagibig = pagibig;
	}


	public String getTin() {
		return tin;
	}


	public void setTin(String tin) {
		this.tin = tin;
	}


	public int getTerminalId() {
		return terminalId;
	}


	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}


	public String getArticulated() {
		return articulated;
	}


	public void setArticulated(String articulated) {
		this.articulated = articulated;
	}


	public Date getDateHired() {
		return dateHired;
	}


	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}


	public String getLicenseNo() {
		return licenseNo;
	}


	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}


	public Date getLicenseValidity() {
		return licenseValidity;
	}


	public void setLicenseValidity(Date licenseValidity) {
		this.licenseValidity = licenseValidity;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCivilStatus() {
		return civilStatus;
	}


	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}


	public String getSpouse() {
		return spouse;
	}


	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}


	public String getPhilhealthNo() {
		return philhealthNo;
	}


	public void setPhilhealthNo(String philhealthNo) {
		this.philhealthNo = philhealthNo;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getMothersName() {
		return mothersName;
	}


	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}


	public String getFathersName() {
		return fathersName;
	}


	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getElementary() {
		return elementary;
	}


	public void setElementary(String elementary) {
		this.elementary = elementary;
	}


	public String getElementaryDate() {
		return elementaryDate;
	}


	public void setElementaryDate(String elementaryDate) {
		this.elementaryDate = elementaryDate;
	}


	public String getSecondary() {
		return secondary;
	}


	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}


	public String getSecondaryDate() {
		return secondaryDate;
	}


	public void setSecondaryDate(String secondaryDate) {
		this.secondaryDate = secondaryDate;
	}


	public String getTertiary() {
		return tertiary;
	}


	public void setTertiary(String tertiary) {
		this.tertiary = tertiary;
	}


	public String getTertiaryDate() {
		return tertiaryDate;
	}


	public void setTertiaryDate(String tertiaryDate) {
		this.tertiaryDate = tertiaryDate;
	}


	public String getEmploymentDateFrom1() {
		return employmentDateFrom1;
	}


	public void setEmploymentDateFrom1(String employmentDateFrom1) {
		this.employmentDateFrom1 = employmentDateFrom1;
	}


	public String getEmploymentDateTo1() {
		return employmentDateTo1;
	}


	public void setEmploymentDateTo1(String employmentDateTo1) {
		this.employmentDateTo1 = employmentDateTo1;
	}


	public String getEmploymentPosition1() {
		return employmentPosition1;
	}


	public void setEmploymentPosition1(String employmentPosition1) {
		this.employmentPosition1 = employmentPosition1;
	}


	public String getEmploymentCompany1() {
		return employmentCompany1;
	}


	public void setEmploymentCompany1(String employmentCompany1) {
		this.employmentCompany1 = employmentCompany1;
	}


	public String getEmploymentDateFrom2() {
		return employmentDateFrom2;
	}


	public void setEmploymentDateFrom2(String employmentDateFrom2) {
		this.employmentDateFrom2 = employmentDateFrom2;
	}


	public String getEmploymentDateTo2() {
		return employmentDateTo2;
	}


	public void setEmploymentDateTo2(String employmentDateTo2) {
		this.employmentDateTo2 = employmentDateTo2;
	}


	public String getEmploymentPosition2() {
		return employmentPosition2;
	}


	public void setEmploymentPosition2(String employmentPosition2) {
		this.employmentPosition2 = employmentPosition2;
	}


	public String getEmploymentCompany2() {
		return employmentCompany2;
	}


	public void setEmploymentCompany2(String employmentCompany2) {
		this.employmentCompany2 = employmentCompany2;
	}


	public String getEmploymentDateFrom3() {
		return employmentDateFrom3;
	}


	public void setEmploymentDateFrom3(String employmentDateFrom3) {
		this.employmentDateFrom3 = employmentDateFrom3;
	}


	public String getEmploymentDateTo3() {
		return employmentDateTo3;
	}


	public void setEmploymentDateTo3(String employmentDateTo3) {
		this.employmentDateTo3 = employmentDateTo3;
	}


	public String getEmploymentPosition3() {
		return employmentPosition3;
	}


	public void setEmploymentPosition3(String employmentPosition3) {
		this.employmentPosition3 = employmentPosition3;
	}


	public String getEmploymentCompany3() {
		return employmentCompany3;
	}


	public void setEmploymentCompany3(String employmentCompany3) {
		this.employmentCompany3 = employmentCompany3;
	}


	public Date getFtw() {
		return ftw;
	}


	public void setFtw(Date ftw) {
		this.ftw = ftw;
	}


	public Date getNbi() {
		return nbi;
	}


	public void setNbi(Date nbi) {
		this.nbi = nbi;
	}



	
}
