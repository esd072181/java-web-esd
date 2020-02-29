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
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.MonitorDoctor;
import com.pibs.model.Professional;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.DateUtils;

public class MonitorDoctorFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private int patientCaseSystemId;
	private int professionalId;
	private int days;
	private String fee;
	private String amount;
	private String dateAttended;
	private String timeAttended;
	
	//name fields
	private String name;
	private String specialization;

	
	private List<Professional> modelList;
	private List<MonitorDoctor> entityList;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public MonitorDoctorFormBean() {}




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




	public String getAmount() {
		return amount;
	}




	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getFee() {
		return fee;
	}




	public void setFee(String fee) {
		this.fee = fee;
	}




	public String getDateAttended() {
		return dateAttended;
	}




	public void setDateAttended(String dateAttended) {
		this.dateAttended = dateAttended;
	}




	public String getTimeAttended() {
		return timeAttended;
	}




	public void setTimeAttended(String timeAttended) {
		this.timeAttended = timeAttended;
	}




	public int getProfessionalId() {
		return professionalId;
	}




	public void setProfessionalId(int professionalId) {
		this.professionalId = professionalId;
	}




	public int getDays() {
		return days;
	}




	public void setDays(int days) {
		this.days = days;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSpecialization() {
		return specialization;
	}




	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}




	public List<Professional> getModelList() {
		return modelList;
	}




	public void setModelList(List<Professional> modelList) {
		this.modelList = modelList;
	}




	public List<MonitorDoctor> getEntityList() {
		return entityList;
	}




	public void setEntityList(List<MonitorDoctor> entityList) {
		this.entityList = entityList;
	}




	public void populateFormBean(MonitorDoctor model) throws Exception {
		setId(model.getId());
		setPatientCaseSystemId(model.getPatientCaseSystemId());
		setDays(model.getDays());
		setFee(model.getFee()!=null ? model.getFee().toPlainString() : "0.00");
		setProfessionalId(model.getProfessionalId());
		if (model.getDateAttended()!=null) {
			setDateAttended(DateUtils.sqlDateToString(model.getDateAttended()));
		}
		setTimeAttended(model.getTimeAttended());
		setName(model.getName());
		setSpecialization(model.getSpecialization());
	}
	
	public void populateEntityList(List<MonitorDoctor> rsList) throws Exception {
		setEntityList(rsList);
	}
	
	public MonitorDoctor populateModel (MonitorDoctorFormBean formbean) throws Exception {
		MonitorDoctor model = new MonitorDoctor();
		model.setId(formbean.getId());
		model.setPatientCaseSystemId(formbean.getPatientCaseSystemId());
		model.setProfessionalId(formbean.getProfessionalId());
		model.setDays(formbean.getDays());
		model.setFee(formbean.getFee()!=null && formbean.getFee().trim().length()>0  ? new BigDecimal(formbean.getFee()).setScale(2, BigDecimal.ROUND_HALF_UP) : new BigDecimal("0.00"));//2 decimal place
		double amount = model.getDays() * model.getFee().doubleValue();
		model.setAmount(BigDecimal.valueOf(amount));
		if (formbean.getDateAttended()!=null && formbean.getDateAttended().trim().length() > 0) {
			model.setDateAttended(DateUtils.strToSQLDate(formbean.getDateAttended()));	
		}
		model.setTimeAttended(formbean.getTimeAttended());
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getDays() == 0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.days.req"));
			}
		} 

		return errors;
	}


	public void getDoctorDetails(HttpServletRequest request) throws Exception {
		//fetch the surgery details
		int id = Integer.parseInt(request.getParameter("doctorId"));
		
		Professional model = new Professional();
		model.setId(id);
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.PROFESSIONAL);
        dataMap.put(MapConstant.CLASS_DATA, model);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
        
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
		
        if (resultMap!=null && !resultMap.isEmpty()) {
	        model = (Professional) resultMap.get(MapConstant.CLASS_DATA);
        	setProfessionalId(model.getId());
        	setName(model.getFullName());
        	setSpecialization(model.getSpecialization());
        	setFee(model.getStandardAdmissionFee()!=null ? model.getStandardAdmissionFee().toPlainString() : "0.00");	
        }
	}	
	
}
