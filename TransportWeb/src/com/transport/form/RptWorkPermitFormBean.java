package com.transport.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.transport.constant.MiscConstant;
import com.transport.model.ListValue;
import com.transport.model.WorkPermit;


public class RptWorkPermitFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String transportId;
	private String searchCriteria;
	private String searchValue;

	private List<ListValue> transportProgramLOV;
	private List<ListValue> workPermitCriteriaLOV;
	private List<WorkPermit> modelList;

	private String dateFrom;
	private String dateTo;

	
	public RptWorkPermitFormBean(){}
	
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

	public List<ListValue> getTransportProgramLOV() {
		return transportProgramLOV;
	}

	public void setTransportProgramLOV(List<ListValue> transportProgramLOV) {
		this.transportProgramLOV = transportProgramLOV;
	}

	public List<ListValue> getWorkPermitCriteriaLOV() {
		return workPermitCriteriaLOV;
	}

	public void setWorkPermitCriteriaLOV(List<ListValue> workPermitCriteriaLOV) {
		this.workPermitCriteriaLOV = workPermitCriteriaLOV;
	}

	public List<WorkPermit> getModelList() {
		return modelList;
	}

	public void setModelList(List<WorkPermit> modelList) {
		this.modelList = modelList;
	}
	
	

    public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	@SuppressWarnings("unchecked")
	public void populateCriteriaDropdownList(HttpServletRequest request, RptWorkPermitFormBean formBean) throws Exception{
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_WORK_PERMIT_CRITERIA_SESSION);
    	if (lovList!=null) {
    		formBean.setWorkPermitCriteriaLOV(lovList);
    	}
    	lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_TRANSPORT_PROGRAM_SESSION);
    	if (lovList!=null) {
    		formBean.setTransportProgramLOV(lovList);
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
