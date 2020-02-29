package com.pibs.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.MiscConstant;
import com.pibs.model.Employee;
import com.pibs.model.ListValue;

/**
 * 
 * @author dward
 * @since 18May2018
 */
public class RptEmployeeFormBean extends PIBSFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchCriteria;
	private String searchValue;

	private List<ListValue> employeeCriteriaLOV;
	private List<Employee> modelList;


	public RptEmployeeFormBean(){}



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


	public List<ListValue> getEmployeeCriteriaLOV() {
		return employeeCriteriaLOV;
	}



	public void setEmployeeCriteriaLOV(List<ListValue> employeeCriteriaLOV) {
		this.employeeCriteriaLOV = employeeCriteriaLOV;
	}



	public List<Employee> getModelList() {
		return modelList;
	}



	public void setModelList(List<Employee> modelList) {
		this.modelList = modelList;
	}		
	


	@SuppressWarnings("unchecked")
	public void populateCriteriaDropdownList(HttpServletRequest request) throws Exception{
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_EMPLOYEE_REPORT_SEARCH_CRITERIA_SESSION);
    	if (lovList!=null) {
    		setEmployeeCriteriaLOV(lovList);
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
