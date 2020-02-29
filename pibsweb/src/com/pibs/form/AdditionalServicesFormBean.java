package com.pibs.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.AdditionalServices;
import com.pibs.model.AdditionalServicesCategory;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;

/**
 * 
 * @author dward
 * @since 07August2017
 */
public class AdditionalServicesFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private int additionalServicesCategoryId;
	private String description;
	private String remarks;
	private String fee;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<AdditionalServices> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<AdditionalServicesCategory> additionalServicesCategoryList;
	
	public AdditionalServicesFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public List<AdditionalServicesCategory> getAdditionalServicesCategoryList() {
		return additionalServicesCategoryList;
	}

	public void setAdditionalServicesCategoryList(
			List<AdditionalServicesCategory> additionalServicesCategoryList) {
		this.additionalServicesCategoryList = additionalServicesCategoryList;
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

	public List<AdditionalServices> getModelList() {
		return modelList;
	}

	public void setModelList(List<AdditionalServices> modelList) {
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
	
	public void populateFormBean(AdditionalServices model) {
		setId(model.getId());
		setAdditionalServicesCategoryId(model.getAdditionalServicesCategoryId());
		setDescription(model.getDescription());
		setRemarks(model.getRemarks());
		setFee(model.getFee()!=null ? model.getFee().toPlainString() : "0.00");
	}
	
	public AdditionalServices populateModel (AdditionalServicesFormBean formbean) {
		AdditionalServices model = new AdditionalServices();
		model.setId(formbean.getId());
		model.setAdditionalServicesCategoryId(formbean.getAdditionalServicesCategoryId());
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
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			boolean flag = false;

			if (this.getAdditionalServicesCategoryId() == 0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.category.req"));
				flag = true;
			}
			
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
					//get list from session
					populateDropdownListFromSession(request);		
							
				} catch(Exception e) {}				
			}
		} 

		return errors;
	}

	public int getAdditionalServicesCategoryId() {
		return additionalServicesCategoryId;
	}

	public void setAdditionalServicesCategoryId(int additionalServicesCategoryId) {
		this.additionalServicesCategoryId = additionalServicesCategoryId;
	}
	
	
	public void populateDropdownList(HttpServletRequest request) throws Exception{
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.ADDITIONAL_SERVICES_CATEGORY);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<AdditionalServicesCategory> qryList =  (List<AdditionalServicesCategory>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	setAdditionalServicesCategoryList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_ADDITIONAL_SERVICES_CATEGORY_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_ADDITIONAL_SERVICES_CATEGORY_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_ADDITIONAL_SERVICES_CATEGORY_LIST, qryList);
        }
	}
	
	public void populateDropdownListFromSession(HttpServletRequest request) throws Exception{
		@SuppressWarnings("unchecked")
		List<AdditionalServicesCategory> qryList = (List<AdditionalServicesCategory>) request.getSession().getAttribute(MiscConstant.MF_ADDITIONAL_SERVICES_CATEGORY_LIST);
		if (qryList!=null) {
			setAdditionalServicesCategoryList(qryList);
		} else {
			populateDropdownList(request);
		}		
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
		

	
}
