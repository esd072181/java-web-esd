package com.pibs.form;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import com.pibs.constant.ParamConstant;
import com.pibs.model.Patient;

public class PatientInquiryFormBean extends PIBSFormBean {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Patient> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	
	public PatientInquiryFormBean() {}


	
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



	public List<Patient> getModelList() {
		return modelList;
	}



	public void setModelList(List<Patient> modelList) {
		this.modelList = modelList;
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



	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE))) {
			
		} 

		return errors;
	}

}
