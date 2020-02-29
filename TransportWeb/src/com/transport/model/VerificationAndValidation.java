package com.transport.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class VerificationAndValidation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int itemId;
	private int findingsId;
	private int terminalId;
	private int driverId;
	private int lorryId;
	private Date verificationDate;
	private int correctionsId;
	private int verificationCheckedById;
	private int followUpId;
	private int terminalIdValidation;
	private int driverIdValidation;
	private int lorryIdValidation;
	private Date validationDate;
	private int validationCheckedById;
	private int remarksId;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	private int rootCauseId;
	private int closureId;
	
	//non-persistent
	private String item;
	private String findings;
	private String driver;
	private String terminal;
	private String lorry;
	private String trailer;
	private String verificationDateStr;
	private String corrections;
	private String verificationCheckedBy;
	private String followUp;
	private String driverValidation;
	private String terminalValidation;
	private String lorryValidation;
	private String trailerValidation;
	private String validationDateStr;
	private String validationCheckedBy;
	private String remarks;
	private String rootCause;
	private String closure;
	private String createdOnStr; //Added for 2016 Revision 2 - April 3, 2016
	
	
	public VerificationAndValidation() {}
	

	public int getClosureId() {
		return closureId;
	}


	public void setClosureId(int closureId) {
		this.closureId = closureId;
	}


	public String getClosure() {
		return closure;
	}


	public void setClosure(String closure) {
		this.closure = closure;
	}


	public String getRootCause() {
		return rootCause;
	}


	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public int getRootCauseId() {
		return rootCauseId;
	}


	public void setRootCauseId(int rootCauseId) {
		this.rootCauseId = rootCauseId;
	}


	public String getTrailerValidation() {
		return trailerValidation;
	}


	public void setTrailerValidation(String trailerValidation) {
		this.trailerValidation = trailerValidation;
	}


	public int getFindingsId() {
		return findingsId;
	}


	public void setFindingsId(int findingsId) {
		this.findingsId = findingsId;
	}


	public int getTerminalIdValidation() {
		return terminalIdValidation;
	}


	public void setTerminalIdValidation(int terminalIdValidation) {
		this.terminalIdValidation = terminalIdValidation;
	}


	public int getDriverIdValidation() {
		return driverIdValidation;
	}


	public void setDriverIdValidation(int driverIdValidation) {
		this.driverIdValidation = driverIdValidation;
	}


	public int getLorryIdValidation() {
		return lorryIdValidation;
	}


	public void setLorryIdValidation(int lorryIdValidation) {
		this.lorryIdValidation = lorryIdValidation;
	}


	public String getFindings() {
		return findings;
	}


	public void setFindings(String findings) {
		this.findings = findings;
	}


	public String getTrailer() {
		return trailer;
	}


	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}


	public String getTerminalValidation() {
		return terminalValidation;
	}


	public void setTerminalValidation(String terminalValidation) {
		this.terminalValidation = terminalValidation;
	}


	public String getDriverValidation() {
		return driverValidation;
	}


	public void setDriverValidation(String driverValidation) {
		this.driverValidation = driverValidation;
	}


	public String getLorryValidation() {
		return lorryValidation;
	}


	public void setLorryValidation(String lorryValidation) {
		this.lorryValidation = lorryValidation;
	}


	public String getTerminal() {
		return terminal;
	}


	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}


	public int getTerminalId() {
		return terminalId;
	}


	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getLorryId() {
		return lorryId;
	}

	public void setLorryId(int lorryId) {
		this.lorryId = lorryId;
	}


	public int getCorrectionsId() {
		return correctionsId;
	}

	public void setCorrectionsId(int correctionsId) {
		this.correctionsId = correctionsId;
	}

	public int getVerificationCheckedById() {
		return verificationCheckedById;
	}

	public void setVerificationCheckedById(int verificationCheckedById) {
		this.verificationCheckedById = verificationCheckedById;
	}

	public int getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(int followUpId) {
		this.followUpId = followUpId;
	}



	public Date getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(Date verificationDate) {
		this.verificationDate = verificationDate;
	}

	public Date getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	public int getValidationCheckedById() {
		return validationCheckedById;
	}

	public void setValidationCheckedById(int validationCheckedById) {
		this.validationCheckedById = validationCheckedById;
	}

	public int getRemarksId() {
		return remarksId;
	}

	public void setRemarksId(int remarksId) {
		this.remarksId = remarksId;
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getLorry() {
		return lorry;
	}

	public void setLorry(String lorry) {
		this.lorry = lorry;
	}

	public String getVerificationDateStr() {
		return verificationDateStr;
	}

	public void setVerificationDateStr(String verificationDateStr) {
		this.verificationDateStr = verificationDateStr;
	}

	public String getCorrections() {
		return corrections;
	}

	public void setCorrections(String corrections) {
		this.corrections = corrections;
	}

	public String getVerificationCheckedBy() {
		return verificationCheckedBy;
	}

	public void setVerificationCheckedBy(String verificationCheckedBy) {
		this.verificationCheckedBy = verificationCheckedBy;
	}

	public String getFollowUp() {
		return followUp;
	}

	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}

	public String getValidationDateStr() {
		return validationDateStr;
	}

	public void setValidationDateStr(String validationDateStr) {
		this.validationDateStr = validationDateStr;
	}

	public String getValidationCheckedBy() {
		return validationCheckedBy;
	}

	public void setValidationCheckedBy(String validationCheckedBy) {
		this.validationCheckedBy = validationCheckedBy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getCreatedOnStr() {
		return createdOnStr;
	}

	public void setCreatedOnStr(String createdOnStr) {
		this.createdOnStr = createdOnStr;
	}
	
}
