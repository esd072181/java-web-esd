package com.pibs.form;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.Discount;
import com.pibs.util.DateUtils;

public class DiscountFormBean extends PIBSFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String description;
	private String remarks;
	private String dateApproved;
	private String standardAmount;
	private String standardPercentage;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Discount> modelList;
	
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


	public List<Discount> getModelList() {
		return modelList;
	}
	public void setModelList(List<Discount> modelList) {
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

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

	public void populateFormBean(Discount model)  throws Exception {
		setId(model.getId());
		setDescription(model.getDescription());
		setRemarks(model.getRemarks());
		if (model.getDateApproved()!=null) {
			setDateApproved(DateUtils.sqlDateToString(model.getDateApproved()));
		}
		setStandardAmount(model.getStandardAmount()!=null ? model.getStandardAmount().toPlainString() : "0.00");
		setStandardPercentage(model.getStandardPercentage()!=null ? model.getStandardPercentage().toPlainString() : "0.00");
	}
	
	public Discount populateModel (DiscountFormBean formbean) throws Exception {
		Discount model = new Discount();
		model.setId(formbean.getId());
		model.setDescription(formbean.getDescription());
		model.setRemarks(formbean.getRemarks());
		if (formbean.getDateApproved()!=null && formbean.getDateApproved().trim().length() > 0) {
			model.setDateApproved(DateUtils.strToSQLDate(formbean.getDateApproved()));	
		}
		model.setStandardAmount(formbean.getStandardAmount()!=null && formbean.getStandardAmount().trim().length()>0  ? new BigDecimal(formbean.getStandardAmount()).setScale(2, BigDecimal.ROUND_HALF_UP) : new BigDecimal("0.00"));//2 decimal place
		formbean.setStandardAmount(model.getStandardAmount().toPlainString());
		model.setStandardPercentage(formbean.getStandardPercentage()!=null && formbean.getStandardPercentage().trim().length()>0  ? new BigDecimal(formbean.getStandardPercentage()).setScale(2, BigDecimal.ROUND_HALF_UP) : new BigDecimal("0.00"));//2 decimal place
		formbean.setStandardPercentage(model.getStandardPercentage().toPlainString());

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
	public String getDateApproved() {
		return dateApproved;
	}
	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}
	public String getStandardAmount() {
		return standardAmount;
	}
	public void setStandardAmount(String standardAmount) {
		this.standardAmount = standardAmount;
	}
	public String getStandardPercentage() {
		return standardPercentage;
	}
	public void setStandardPercentage(String standardPercentage) {
		this.standardPercentage = standardPercentage;
	}
	
	
	
}
