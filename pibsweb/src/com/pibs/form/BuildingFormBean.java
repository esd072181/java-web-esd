package com.pibs.form;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
//import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.Building;

public class BuildingFormBean extends PIBSFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String description;
	private String nooffloor;
	private String remarks;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Building> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public String getTransactionMessage() {
		return transactionMessage;
	}
	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
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

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public List<Building> getModelList() {
		return modelList;
	}
	public void setModelList(List<Building> modelList) {
		this.modelList = modelList;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getNooffloor() {
		return nooffloor;
	}
	public void setNooffloor(String nooffloor) {
		this.nooffloor = nooffloor;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

	public void populateFormBean(Building model) {
		setId(model.getId());
		setDescription(model.getDescription());
		setNooffloor(String.valueOf(model.getNoOfFloor()));
		setRemarks(model.getRemarks());
	}
	
	public Building populateModel (BuildingFormBean formbean) {
		Building model = new Building();
		model.setId(formbean.getId());
		model.setDescription(formbean.getDescription());
		model.setNoOfFloor(Integer.parseInt(formbean.getNooffloor()));
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
			if (this.getNooffloor()==null || this.getNooffloor().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.building.nooffloor.req"));
			}
			//for numeric no of floor
			if (this.getNooffloor()!=null && this.getNooffloor().trim().length() > 0 && !org.apache.commons.lang3.StringUtils.isNumeric(this.getNooffloor())) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.building.nooffloor.numeric"));
			}
		} 

		return errors;
	}
	
}
