package com.pibs.form;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.pibs.model.ListValue;
import com.pibs.model.Professional;
import com.pibs.model.ProfessionalType;
import com.pibs.model.Specialization;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.DateUtils;

public class ProfessionalFormBean extends PIBSFormBean{

	private static final long serialVersionUID = 1L;
	private int id;
	private int professionalTypeId;
	private int specializationId;
	private String designation;
	private String lastName;
	private String firstName;
	private String middleName;
	private String gender;
	private String birthday;
	private String dateHired;
	private String licenseNo;
	private int professionalStatusId;
	private String standardConsultationFee;
	private String standardAdmissionFee;
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Professional> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<ProfessionalType> professionalTypeList;
	private List<Specialization> specializationList;
	
	private List<ListValue> professionalDesignationLOV;
	private List<ListValue> professionalStatusLOV;
	private List<ListValue> genderLOV;
	
	public List<ListValue> getGenderLOV() {
		return genderLOV;
	}

	public void setGenderLOV(List<ListValue> genderLOV) {
		this.genderLOV = genderLOV;
	}

	public ProfessionalFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	


	public int getProfessionalTypeId() {
		return professionalTypeId;
	}

	public void setProfessionalTypeId(int professionalTypeId) {
		this.professionalTypeId = professionalTypeId;
	}

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public int getProfessionalStatusId() {
		return professionalStatusId;
	}

	public void setProfessionalStatusId(int professionalStatusId) {
		this.professionalStatusId = professionalStatusId;
	}

	public List<ProfessionalType> getProfessionalTypeList() {
		return professionalTypeList;
	}

	public void setProfessionalTypeList(List<ProfessionalType> professionalTypeList) {
		this.professionalTypeList = professionalTypeList;
	}

	public List<Specialization> getSpecializationList() {
		return specializationList;
	}

	public void setSpecializationList(List<Specialization> specializationList) {
		this.specializationList = specializationList;
	}

	public List<ListValue> getProfessionalStatusLOV() {
		return professionalStatusLOV;
	}

	public void setProfessionalStatusLOV(List<ListValue> professionalStatusLOV) {
		this.professionalStatusLOV = professionalStatusLOV;
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
	
	public void populateFormBean(Professional model) throws Exception {
		setId(model.getId());
		setProfessionalTypeId(model.getProfessionalTypeId());
		setSpecializationId(model.getSpecializationId());
		setDesignation(model.getDesignation());
		setLastName(model.getLastName());
		setFirstName(model.getFirstName());
		setMiddleName(model.getMiddleName());
		setGender(model.getGender());
		if (model.getBirthday()!=null) {
			setBirthday(DateUtils.sqlDateToString(model.getBirthday()));
		}
		if (model.getDateHired()!=null) {
			setDateHired(DateUtils.sqlDateToString(model.getDateHired()));
		}
		setLicenseNo(model.getLicenseNo());
		setProfessionalStatusId(model.getProfessionalStatusId());
		setStandardConsultationFee(model.getStandardConsultationFee()!=null ? model.getStandardConsultationFee().toPlainString() : "0.00");
		setStandardAdmissionFee(model.getStandardAdmissionFee()!=null ? model.getStandardAdmissionFee().toPlainString() : "0.00");
	}
	
	public Professional populateModel (ProfessionalFormBean formbean) throws Exception{
		Professional model = new Professional();
		model.setId(formbean.getId());
		model.setProfessionalTypeId(formbean.getProfessionalTypeId());
		model.setSpecializationId(formbean.getSpecializationId());
		model.setDesignation(formbean.getDesignation());
		model.setLastName(formbean.getLastName());
		model.setFirstName(formbean.getFirstName());
		model.setMiddleName(formbean.getMiddleName());
		model.setGender(formbean.getGender());
		if (formbean.getBirthday()!=null && formbean.getBirthday().trim().length() > 0) {
			model.setBirthday(DateUtils.strToSQLDate(formbean.getBirthday()));	
		}
		if (formbean.getDateHired()!=null && formbean.getDateHired().trim().length() > 0) {
			model.setDateHired(DateUtils.strToSQLDate(formbean.getDateHired()));	
		}
		model.setLicenseNo(formbean.getLicenseNo());
		model.setProfessionalStatusId(formbean.getProfessionalStatusId());
		model.setStandardConsultationFee(formbean.getStandardConsultationFee()!=null && formbean.getStandardConsultationFee().trim().length()>0  ? new BigDecimal(formbean.getStandardConsultationFee()).setScale(2, BigDecimal.ROUND_HALF_UP) : new BigDecimal("0.00"));//2 decimal place
		formbean.setStandardConsultationFee(model.getStandardConsultationFee().toPlainString());
		model.setStandardAdmissionFee(formbean.getStandardAdmissionFee()!=null && formbean.getStandardAdmissionFee().trim().length()>0  ? new BigDecimal(formbean.getStandardAdmissionFee()).setScale(2, BigDecimal.ROUND_HALF_UP) : new BigDecimal("0.00"));//2 decimal place
		formbean.setStandardAdmissionFee(model.getStandardAdmissionFee().toPlainString());
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
			
			if(this.getProfessionalTypeId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.type.req"));
				flag = true;
			}

			if (this.getLastName()==null || this.getLastName().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.lastname.req"));
				flag = true;
			}
			
			if (this.getFirstName()==null || this.getFirstName().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.firstname.req"));
				flag = true;
			}
			
			if(this.getSpecializationId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.specialization.req"));
				flag = true;
			}
			
			if(this.getProfessionalStatusId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.status.req"));
				flag = true;
			}
			
			//check if fee is numeric
			try {
				Double.parseDouble(this.getStandardConsultationFee()!=null && this.getStandardConsultationFee().trim().length()>0 ? this.getStandardConsultationFee() : "0.00");
				Double.parseDouble(this.getStandardAdmissionFee()!=null && this.getStandardAdmissionFee().trim().length()>0 ? this.getStandardAdmissionFee() : "0.00");
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
	
    @SuppressWarnings("unchecked")
	public void populateDropdownList(HttpServletRequest request) throws Exception{
		//Professional Type
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.PROFESSIONAL_TYPE);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			List<ProfessionalType> qryList =  (List<ProfessionalType>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	setProfessionalTypeList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_PROFESSIONAL_TYPE_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_PROFESSIONAL_TYPE_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_PROFESSIONAL_TYPE_LIST, qryList);
        }
        
        dataMap = null;
        service = null;
        resultMap = null;

        //Specialization
    	dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.SPECIALIZATION);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);

		
        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			List<Specialization> qryList =  (List<Specialization>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	setSpecializationList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_SPECIALIZATION_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_SPECIALIZATION_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_SPECIALIZATION_LIST, qryList);
        }
        
		List<ListValue> lovListDesignation = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_PROFESSIONAL_DESIGNATION_TYPE_SESSION);
    	if (lovListDesignation!=null) {
    		setProfessionalDesignationLOV(lovListDesignation);
    	}
    	

		List<ListValue> lovListProfessionalStatus = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_PROFESSIONAL_STATUS_TYPE_SESSION);
    	if (lovListProfessionalStatus!=null) {
    		setProfessionalStatusLOV(lovListProfessionalStatus);
    	}
    	
		List<ListValue> lovListGender = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_GENDER_TYPE_SESSION);
    	if (lovListGender!=null) {
    		setGenderLOV(lovListGender);
    	}
        
	}


	@SuppressWarnings("unchecked")
	public void populateDropdownListFromSession(HttpServletRequest request) throws Exception{		
		List<ProfessionalType> qryList = (List<ProfessionalType>) request.getSession().getAttribute(MiscConstant.MF_PROFESSIONAL_TYPE_LIST);
		if (qryList!=null) {
			setProfessionalTypeList(qryList);
			setSpecializationList((List<Specialization>) request.getSession().getAttribute(MiscConstant.MF_SPECIALIZATION_LIST));
			setProfessionalDesignationLOV((ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_PROFESSIONAL_DESIGNATION_TYPE_SESSION));
			setProfessionalStatusLOV((ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_PROFESSIONAL_STATUS_TYPE_SESSION));
			setGenderLOV((ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_GENDER_TYPE_SESSION));
		} else {
			populateDropdownList(request);
		}		
	}

	public List<Professional> getModelList() {
		return modelList;
	}

	public void setModelList(List<Professional> modelList) {
		this.modelList = modelList;
	}

	public List<ListValue> getProfessionalDesignationLOV() {
		return professionalDesignationLOV;
	}

	public void setProfessionalDesignationLOV(
			List<ListValue> professionalDesignationLOV) {
		this.professionalDesignationLOV = professionalDesignationLOV;
	}

	public String getStandardConsultationFee() {
		return standardConsultationFee;
	}

	public void setStandardConsultationFee(String standardConsultationFee) {
		this.standardConsultationFee = standardConsultationFee;
	}

	public String getStandardAdmissionFee() {
		return standardAdmissionFee;
	}

	public void setStandardAdmissionFee(String standardAdmissionFee) {
		this.standardAdmissionFee = standardAdmissionFee;
	}
		

	
}
