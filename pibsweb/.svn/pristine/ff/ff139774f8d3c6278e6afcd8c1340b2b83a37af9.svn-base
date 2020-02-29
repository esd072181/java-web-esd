package com.pibs.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.MiscConstant;
import com.pibs.model.ListValue;
import com.pibs.model.MonitorNursery;

/**
 * 
 * @author dward
 * @since 23May2018
 */
public class RptNurseryFormBean extends PIBSFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchCriteria;
	private String searchValue;

	private List<ListValue> nurseryCriteriaLOV;
	private List<MonitorNursery> modelList;

	private String dateFrom;
	private String dateTo;

	
	public RptNurseryFormBean(){}
	
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
	
	
	public List<ListValue> getNurseryCriteriaLOV() {
		return nurseryCriteriaLOV;
	}

	public void setNurseryCriteriaLOV(List<ListValue> nurseryCriteriaLOV) {
		this.nurseryCriteriaLOV = nurseryCriteriaLOV;
	}

	public List<MonitorNursery> getModelList() {
		return modelList;
	}

	public void setModelList(List<MonitorNursery> modelList) {
		this.modelList = modelList;
	}

	@SuppressWarnings("unchecked")
	public void populateCriteriaDropdownList(HttpServletRequest request) throws Exception{
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_NURSERY_REPORT_SEARCH_CRITERIA_SESSION);
    	if (lovList!=null) {
    		setNurseryCriteriaLOV(lovList);
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
