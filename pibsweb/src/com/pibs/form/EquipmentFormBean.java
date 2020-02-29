package com.pibs.form;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.Equipment;

public class EquipmentFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private String entityName;
	private String description;
	private String fee;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Equipment> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public EquipmentFormBean() {}

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

	public List<Equipment> getModelList() {
		return modelList;
	}

	public void setModelList(List<Equipment> modelList) {
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
	
	public void populateFormBean(Equipment model) {
		setId(model.getId());
		setEntityName(model.getEntityName());
		setDescription(model.getDescription());
		setFee(model.getFee()!=null ? model.getFee().toPlainString() : "0.00");
	}
	
	public Equipment populateModel (EquipmentFormBean formbean) {
		Equipment model = new Equipment();
		model.setId(formbean.getId());
		model.setEntityName(formbean.getEntityName());
		model.setDescription(formbean.getDescription());
		model.setFee(formbean.getFee()!=null && formbean.getFee().trim().length()>0  ? new BigDecimal(formbean.getFee()).setScale(2, BigDecimal.ROUND_HALF_UP) : new BigDecimal("0.00"));//2 decimal place
		formbean.setFee(model.getFee().toPlainString());
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
			
			//check if price is numeric
			try {
				Double.parseDouble(this.getFee()!=null && this.getFee().trim().length()>0 ? this.getFee() : "0.00");
			} catch (NumberFormatException e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.fee.num"));
			}
		} 

		return errors;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
		
	
}
