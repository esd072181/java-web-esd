package com.pibs.form;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.MiscConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.ListValue;
import com.pibs.model.MonitorNursery;
import com.pibs.util.DateUtils;

public class MonitorNurseryFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private int patientCaseSystemId;
	private String lastName;
	private String firstName;
	private String dateOfBirth;
	private String timeOfBirth;
	private String gender;
	private String weight;
	private String remarks;
	
	private List<ListValue> genderLOV;
	private List<MonitorNursery> entityList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public MonitorNurseryFormBean() {}



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
	

	public int getPatientCaseSystemId() {
		return patientCaseSystemId;
	}

	public void setPatientCaseSystemId(int patientCaseSystemId) {
		this.patientCaseSystemId = patientCaseSystemId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getTimeOfBirth() {
		return timeOfBirth;
	}



	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}


	public String getWeight() {
		return weight;
	}



	public void setWeight(String weight) {
		this.weight = weight;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<MonitorNursery> getEntityList() {
		return entityList;
	}



	public void setEntityList(List<MonitorNursery> entityList) {
		this.entityList = entityList;
	}



	public List<ListValue> getGenderLOV() {
		return genderLOV;
	}



	public void setGenderLOV(List<ListValue> genderLOV) {
		this.genderLOV = genderLOV;
	}




	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public void populateFormBean(MonitorNursery model) throws Exception {
		setId(model.getId());
		setPatientCaseSystemId(model.getPatientCaseSystemId());
		setLastName(model.getLastName());
		setFirstName(model.getFirstName());
		if (model.getDateOfBirth()!=null) {
			setDateOfBirth(DateUtils.sqlDateToString(model.getDateOfBirth()));
		}
		setTimeOfBirth(model.getTimeOfBirth());
		setGender(model.getGender());
		setWeight(model.getWeight());
		setRemarks(model.getRemarks());
	}
	
	public void populateEntityList(List<MonitorNursery> rsList) throws Exception {
		setEntityList(rsList);
	}
	
	public MonitorNursery populateModel (MonitorNurseryFormBean formbean) throws Exception {
		MonitorNursery model = new MonitorNursery();
		model.setId(formbean.getId());
		model.setPatientCaseSystemId(formbean.getPatientCaseSystemId());
		model.setLastName(formbean.getLastName());
		model.setFirstName(formbean.getFirstName());
		if (formbean.getDateOfBirth()!=null && formbean.getDateOfBirth().trim().length() > 0) {
			model.setDateOfBirth(DateUtils.strToSQLDate(formbean.getDateOfBirth()));	
		}
		model.setTimeOfBirth(formbean.getTimeOfBirth());
		model.setGender(formbean.getGender());
		model.setWeight(formbean.getWeight());
		model.setRemarks(formbean.getRemarks());
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
			if (this.getLastName()==null || this.getLastName().trim().length() == 0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.lastname.req"));
				flag = true;
			}
			if (this.getFirstName()==null || this.getFirstName().trim().length() == 0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.firstname.req"));
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

	public void populateDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_GENDER_TYPE_SESSION);
    	if (lovList!=null) {
    		setGenderLOV(lovList);
    	}
	}
		
	public void populateDropdownListFromSession(HttpServletRequest request) throws Exception{
		populateDropdownList(request);//this is the fix for the issue of Failed to obtain Collection in JspException
	}
}
