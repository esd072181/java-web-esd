package com.pibs.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.MedicationStatement;
import com.pibs.util.DateUtils;

public class MedicationStatementFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int medicationStatementId;//ID in database
	private int patientCaseSystemId;
	private String medicationStatement;
	private String remarks;
	private String dateOfStatement;
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public MedicationStatementFormBean() {}

	public int getMedicationStatementId() {
		return medicationStatementId;
	}

	public void setMedicationStatementId(int medicationStatementId) {
		this.medicationStatementId = medicationStatementId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionMessage() {
		return transactionMessage;
	}

	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}
	
	public void populateFormBean(MedicationStatement model) throws Exception {
		setMedicationStatementId(model.getId());
		setPatientCaseSystemId(model.getPatientCaseSystemId());
		setMedicationStatement(model.getMedicationStatement());
		setRemarks(model.getRemarks());
		if (model.getDateOfStatement()!=null) {
			setDateOfStatement(DateUtils.sqlDateToString(model.getDateOfStatement()));
		}
	}
	
	public MedicationStatement populateModel (MedicationStatementFormBean formbean) throws Exception {
		MedicationStatement model = new MedicationStatement();
		model.setId(formbean.getMedicationStatementId());
		model.setPatientCaseSystemId(formbean.getPatientCaseSystemId());
		model.setMedicationStatement(formbean.getMedicationStatement());
		model.setRemarks(formbean.getRemarks());
		if (formbean.getDateOfStatement()!=null && formbean.getDateOfStatement().trim().length() > 0) {
			model.setDateOfStatement(DateUtils.strToSQLDate(formbean.getDateOfStatement()));	
		}
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getMedicationStatement()==null || this.getMedicationStatement().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.statement.req"));
			}
			if (this.getDateOfStatement()==null || this.getDateOfStatement().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.date.req"));
			}
		} 

		return errors;
	}

	public int getPatientCaseSystemId() {
		return patientCaseSystemId;
	}

	public void setPatientCaseSystemId(int patientCaseSystemId) {
		this.patientCaseSystemId = patientCaseSystemId;
	}



	public String getMedicationStatement() {
		return medicationStatement;
	}



	public void setMedicationStatement(String medicationStatement) {
		this.medicationStatement = medicationStatement;
	}



	public String getDateOfStatement() {
		return dateOfStatement;
	}



	public void setDateOfStatement(String dateOfStatement) {
		this.dateOfStatement = dateOfStatement;
	}


		
	
}
