package com.transport.form;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.transport.constant.ParamConstant;
import com.transport.model.TireBrand;

/**
 * 
 * @author dward
 * @since 20Aug2016
 */
public class TireBrandFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String description;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<TireBrand> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public TireBrandFormBean() {}
	
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

	public List<TireBrand> getModelList() {
		return modelList;
	}

	public void setModelList(List<TireBrand> modelList) {
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
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void populateFormBean(TireBrand model) {
		setId(model.getId());
		setName(model.getName());
		setDescription(model.getDescription());
	}
	
	public TireBrand populateModel (TireBrandFormBean formbean) {
		TireBrand model = new TireBrand();
		model.setId(formbean.getId());
		model.setName(formbean.getName());
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
			if (this.getName()==null || this.getName().trim().length() < 1) {				
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.brandname.req"));
			}
		} 

		return errors;
	}		

}
