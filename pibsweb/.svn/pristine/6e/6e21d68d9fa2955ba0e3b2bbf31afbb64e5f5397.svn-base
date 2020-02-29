package com.pibs.form;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.RoomCategory;

public class RoomCategoryFormBean extends PIBSFormBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private String remarks;
	private String rate;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<RoomCategory> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public RoomCategoryFormBean() {}
	
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
	public List<RoomCategory> getModelList() {
		return modelList;
	}
	public void setModelList(List<RoomCategory> modelList) {
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
	
	public void populateFormBean(RoomCategory model) {
		setId(model.getId());
		setDescription(model.getDescription());
		setRemarks(model.getRemarks());
		setRate(model.getRate()!=null ? model.getRate().toPlainString() : "0.00");
	}
	
	public RoomCategory populateModel (RoomCategoryFormBean formbean) {
		RoomCategory model = new RoomCategory();
		model.setId(formbean.getId());
		model.setDescription(formbean.getDescription());
		model.setRemarks(formbean.getRemarks());
		model.setRate(formbean.getRate()!=null && formbean.getRate().trim().length()>0  ? new BigDecimal(formbean.getRate()).setScale(2, BigDecimal.ROUND_HALF_UP) : new BigDecimal("0.00"));//2 decimal place
		formbean.setRate(model.getRate().toPlainString());
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

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
}
