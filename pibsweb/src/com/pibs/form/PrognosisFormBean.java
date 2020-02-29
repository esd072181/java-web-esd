package com.pibs.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.Prognosis;
import com.pibs.util.DateUtils;

public class PrognosisFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int prognosisId;//ID in database
	private int patientCaseSystemId;
	private String statementOfPrognosis;
	private String remarks;
	private String dateOfPrognosis;
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public PrognosisFormBean() {}


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
	
	public void populateFormBean(Prognosis model) throws Exception {
		setPrognosisId(model.getId());
		setPatientCaseSystemId(model.getPatientCaseSystemId());
		setStatementOfPrognosis(model.getStatementOfPrognosis());
		setRemarks(model.getRemarks());
		if (model.getDateOfPrognosis()!=null) {
			setDateOfPrognosis(DateUtils.sqlDateToString(model.getDateOfPrognosis()));
		}
	}
	
	public Prognosis populateModel (PrognosisFormBean formbean) throws Exception {
		Prognosis model = new Prognosis();
		model.setId(formbean.getPrognosisId());
		model.setPatientCaseSystemId(formbean.getPatientCaseSystemId());
		model.setStatementOfPrognosis(formbean.getStatementOfPrognosis());
		model.setRemarks(formbean.getRemarks());
		if (formbean.getDateOfPrognosis()!=null && formbean.getDateOfPrognosis().trim().length() > 0) {
			model.setDateOfPrognosis(DateUtils.strToSQLDate(formbean.getDateOfPrognosis()));	
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
			if (this.getStatementOfPrognosis()==null || this.getStatementOfPrognosis().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.statement.req"));
			}
			if (this.getDateOfPrognosis()==null || this.getDateOfPrognosis().trim().length() < 1) {
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







	public int getPrognosisId() {
		return prognosisId;
	}







	public void setPrognosisId(int prognosisId) {
		this.prognosisId = prognosisId;
	}







	public String getStatementOfPrognosis() {
		return statementOfPrognosis;
	}







	public void setStatementOfPrognosis(String statementOfPrognosis) {
		this.statementOfPrognosis = statementOfPrognosis;
	}







	public String getDateOfPrognosis() {
		return dateOfPrognosis;
	}







	public void setDateOfPrognosis(String dateOfPrognosis) {
		this.dateOfPrognosis = dateOfPrognosis;
	}


		
	
}
