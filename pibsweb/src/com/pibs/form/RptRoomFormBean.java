package com.pibs.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.MiscConstant;
import com.pibs.model.ListValue;
import com.pibs.model.Room;

/**
 * 
 * @author dward
 * @since 18May2018
 */
public class RptRoomFormBean extends PIBSFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchCriteria;
	private String searchValue;

	private List<ListValue> roomCriteriaLOV;
	private List<Room> modelList;


	public RptRoomFormBean(){}



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

	




	public List<ListValue> getRoomCriteriaLOV() {
		return roomCriteriaLOV;
	}



	public void setRoomCriteriaLOV(List<ListValue> roomCriteriaLOV) {
		this.roomCriteriaLOV = roomCriteriaLOV;
	}



	public List<Room> getModelList() {
		return modelList;
	}



	public void setModelList(List<Room> modelList) {
		this.modelList = modelList;
	}



	@SuppressWarnings("unchecked")
	public void populateCriteriaDropdownList(HttpServletRequest request) throws Exception{
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_ROOM_REPORT_SEARCH_CRITERIA_SESSION);
    	if (lovList!=null) {
    		setRoomCriteriaLOV(lovList);
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
