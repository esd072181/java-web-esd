package com.pibs.form;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.MapConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.Patient;
import com.pibs.util.DateUtils;
import com.pibs.util.PIBSUtils;
import com.pibs.util.ReportUtils;

public class MedicalAbstractFormBean extends PIBSFormBean {

	private final static Logger logger = Logger.getLogger(MedicalAbstractFormBean.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String patientId;
	private String fullName;//patient full name
	private String address;
	private String birthday;
	private String doctor;
	private String dateOfAdmission;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Patient> modelList;
	
	private Patient model;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public MedicalAbstractFormBean() {}

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

	public List<Patient> getModelList() {
		return modelList;
	}

	public void setModelList(List<Patient> modelList) {
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
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public Patient getModel() {
		return model;
	}

	public void setModel(Patient model) {
		this.model = model;
	}

	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void populateFormBean() throws Exception {
		setFullName(getModel().getFullName());	
		setPatientId(getModel().getPatientId());
		setAddress(getModel().getAddress());
		if (getModel().getBirthday()!=null) {
			setBirthday(DateUtils.sqlDateToStringSQL(getModel().getBirthday()));		
		}
	}
	
	public void generateReport(HttpServletRequest request) throws Exception {
		//get the birthday
		String age = null;
		if (getBirthday()!=null && getBirthday().trim().length()>0) {
			age = String.valueOf(PIBSUtils.getAge(LocalDate.parse(getBirthday())));
		}
		
		String localPath = PIBSUtils.getReportPath(request);

		//Get the Report header Details
		Map<String, Object> parameters = new HashMap<>();
		
		parameters.put("HospitalName", MapConstant.HOSPITAL_NAME);
		parameters.put("HospitalAddress", MapConstant.HOSPITAL_ADDRESS);
		parameters.put("HospitalTelNo", MapConstant.HOSPITAL_TEL_NO);
		parameters.put("PatientName", getFullName());
		parameters.put("Age", age);
		parameters.put("Address", getAddress());
		parameters.put("DateOfAdmission", getDateOfAdmission());
		StringBuilder sb = new StringBuilder();
		sb.append(getDoctor());
		sb.append(", M.D.");
		parameters.put("Doctor", sb.toString());
		
		boolean isReportGenerated = ReportUtils.generateMedicalAbstractReport(parameters, localPath, getPatientId());
		if (isReportGenerated) {
			setTransactionStatus(true);
			PIBSUtils.writeLogInfo(logger, "Medical Abstract successfully generated for " + getFullName());
		} else {
			PIBSUtils.writeLogInfo(logger, "Medical Abstract was NOT generated for " + getFullName());
		}
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && command.equalsIgnoreCase(ParamConstant.AJAX_GENERATE)) {

		} 
		return errors;
	}
	
}
