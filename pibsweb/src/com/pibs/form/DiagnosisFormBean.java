package com.pibs.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.Diagnosis;
import com.pibs.util.DateUtils;

public class DiagnosisFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int diagnosisId;//ID in database
	private int patientCaseSystemId;
	private String statementOfDiagnosis;
	private String remarks;
	private String dateOfDiagnosis;
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public DiagnosisFormBean() {}



	public int getDiagnosisId() {
		return diagnosisId;
	}



	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
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
	
	public void populateFormBean(Diagnosis model) throws Exception {
		setDiagnosisId(model.getId());
		setPatientCaseSystemId(model.getPatientCaseSystemId());
		setStatementOfDiagnosis(model.getStatementOfDiagnosis());
		setRemarks(model.getRemarks());
		if (model.getDateOfDiagnosis()!=null) {
			setDateOfDiagnosis(DateUtils.sqlDateToString(model.getDateOfDiagnosis()));
		}
	}
	
	public Diagnosis populateModel (DiagnosisFormBean formbean) throws Exception {
		Diagnosis model = new Diagnosis();
		model.setId(formbean.getDiagnosisId());
		model.setPatientCaseSystemId(formbean.getPatientCaseSystemId());
		model.setStatementOfDiagnosis(formbean.getStatementOfDiagnosis());
		model.setRemarks(formbean.getRemarks());
		if (formbean.getDateOfDiagnosis()!=null && formbean.getDateOfDiagnosis().trim().length() > 0) {
			model.setDateOfDiagnosis(DateUtils.strToSQLDate(formbean.getDateOfDiagnosis()));	
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
			if (this.getStatementOfDiagnosis()==null || this.getStatementOfDiagnosis().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.statement.req"));
			}
			if (this.getDateOfDiagnosis()==null || this.getDateOfDiagnosis().trim().length() < 1) {
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

	public String getStatementOfDiagnosis() {
		return statementOfDiagnosis;
	}

	public void setStatementOfDiagnosis(String statementOfDiagnosis) {
		this.statementOfDiagnosis = statementOfDiagnosis;
	}

	public String getDateOfDiagnosis() {
		return dateOfDiagnosis;
	}

	public void setDateOfDiagnosis(String dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}
		
	
}
