package com.pibs.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.Specialization;

public class SpecializationFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private String entityName;
	private String description;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Specialization> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public SpecializationFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
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

	public List<Specialization> getModelList() {
		return modelList;
	}

	public void setModelList(List<Specialization> modelList) {
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
	
	public void populateFormBean(Specialization model) {
		setId(model.getId());
		setEntityName(model.getEntityName());
		setDescription(model.getDescription());
	}
	
	public Specialization populateModel (SpecializationFormBean formbean) {
		Specialization model = new Specialization();
		model.setId(formbean.getId());
		model.setEntityName(formbean.getEntityName());
		model.setDescription(formbean.getDescription());
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getEntityName()==null || this.getEntityName().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.entityname.req"));
			}
		} 

		return errors;
	}
		
	
}
