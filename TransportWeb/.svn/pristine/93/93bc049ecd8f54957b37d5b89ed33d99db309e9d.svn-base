package com.transport.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.transport.constant.MiscConstant;
import com.transport.model.ListValue;
import com.transport.model.VerificationAndValidation;


public class RptVerificationFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchCriteria;
	private String searchValue;

	private List<ListValue> verificationCriteriaLOV;
	private List<VerificationAndValidation> modelList;

	private String dateFrom;
	private String dateTo;

	
	public RptVerificationFormBean(){}
	
	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}



	public List<VerificationAndValidation> getModelList() {
		return modelList;
	}


	public void setModelList(List<VerificationAndValidation> modelList) {
		this.modelList = modelList;
	}

	public String getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<ListValue> getVerificationCriteriaLOV() {
		return verificationCriteriaLOV;
	}

	public void setVerificationCriteriaLOV(List<ListValue> verificationCriteriaLOV) {
		this.verificationCriteriaLOV = verificationCriteriaLOV;
	}
	
	
	public void populateVerificationCriteriaDropdownList(HttpServletRequest request, RptVerificationFormBean formBean) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_VERIFICATION_CRITERIA_SESSION);
    	if (lovList!=null) {
    		formBean.setVerificationCriteriaLOV(lovList);
    	}
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		return errors;
	}		
	

	
	
}
