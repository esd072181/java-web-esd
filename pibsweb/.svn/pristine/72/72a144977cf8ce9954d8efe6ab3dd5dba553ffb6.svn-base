package com.pibs.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.MiscConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.ListValue;
import com.pibs.model.Radiology;

public class RadiologyFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private int radiologyTypeId;
	private String description;
	private String remarks;
	private String fee;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Radiology> modelList;
	
	private List<ListValue> radiologyTypeLOV;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public RadiologyFormBean() {}

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

	public List<Radiology> getModelList() {
		return modelList;
	}

	public void setModelList(List<Radiology> modelList) {
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
	
	public void populateFormBean(Radiology model) {
		setId(model.getId());
		setRadiologyTypeId(model.getRadiologyTypeId());
		setDescription(model.getDescription());
		setRemarks(model.getRemarks());
		setFee(model.getFee()!=null ? model.getFee().toPlainString() : "0.00");
	}
	
	public Radiology populateModel (RadiologyFormBean formbean) {
		Radiology model = new Radiology();
		model.setId(formbean.getId());
		model.setRadiologyTypeId(formbean.getRadiologyTypeId());
		model.setDescription(formbean.getDescription());
		model.setRemarks(formbean.getRemarks());
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
		boolean flag = false;
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getDescription()==null || this.getDescription().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.description.req"));
				flag = true;
			}
			
			//check if price is numeric
			try {
				Double.parseDouble(this.getFee()!=null && this.getFee().trim().length()>0 ? this.getFee() : "0.00");
			} catch (NumberFormatException e) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.fee.num"));
				flag = true;
			}
			
			if (flag) {
				try {
					populateDropdownListFromSession(request, this, false);
				} catch(Exception e) {}					
			}
		} 

		return errors;
	}

	public List<ListValue> getRadiologyTypeLOV() {
		return radiologyTypeLOV;
	}

	public void setRadiologyTypeLOV(List<ListValue> radiologyTypeLOV) {
		this.radiologyTypeLOV = radiologyTypeLOV;
	}
		
	public void populateDropdownList(HttpServletRequest request, RadiologyFormBean formBean) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_RADIOLOGY_TYPE_SESSION);
    	if (lovList!=null) {
    		formBean.setRadiologyTypeLOV(lovList);
    	}
	}
	
	
	public void populateDropdownListFromSession(HttpServletRequest request, RadiologyFormBean formBean, boolean isEdit) throws Exception{
		populateDropdownList(request, formBean);//this is the fix for the issue of Failed to obtain Collection in JspException
	}

	public int getRadiologyTypeId() {
		return radiologyTypeId;
	}

	public void setRadiologyTypeId(int radiologyTypeId) {
		this.radiologyTypeId = radiologyTypeId;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	
}
