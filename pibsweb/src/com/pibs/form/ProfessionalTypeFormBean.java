package com.pibs.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.ProfessionalType;

public class ProfessionalTypeFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private String remarks;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<ProfessionalType> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public ProfessionalTypeFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<ProfessionalType> getModelList() {
		return modelList;
	}

	public void setModelList(List<ProfessionalType> modelList) {
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
	
	public void populateFormBean(ProfessionalType model) {
		setId(model.getId());
		setDescription(model.getDescription());
		setRemarks(model.getRemarks());
	}
	
	public ProfessionalType populateModel (ProfessionalTypeFormBean formbean) {
		ProfessionalType model = new ProfessionalType();
		model.setId(formbean.getId());
		model.setDescription(formbean.getDescription());
		model.setRemarks(formbean.getRemarks());
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getDescription()==null || this.getDescription().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.description.req"));
			}
		} 

		return errors;
	}
		
	
}
