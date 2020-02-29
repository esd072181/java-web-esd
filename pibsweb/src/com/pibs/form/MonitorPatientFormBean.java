package com.pibs.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.model.Admission;
import com.pibs.model.Diagnosis;
import com.pibs.model.MedicationStatement;
import com.pibs.model.Patient;
import com.pibs.model.Prognosis;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.DateUtils;

public class MonitorPatientFormBean extends PIBSFormBean {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id; //patientcasesystemid
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Patient> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private Admission admission;
	
	private String dateAdmitted;
	private String timeAdmitted;
	
	private Diagnosis diagnosis;
	private MedicationStatement statement;
	private Prognosis prognosis;

	public MonitorPatientFormBean() {}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	public String getDateAdmitted() {
		return dateAdmitted;
	}


	public void setDateAdmitted(String dateAdmitted) {
		this.dateAdmitted = dateAdmitted;
	}


	public String getTimeAdmitted() {
		return timeAdmitted;
	}


	public void setTimeAdmitted(String timeAdmitted) {
		this.timeAdmitted = timeAdmitted;
	}

	public void populatePatientAdmissionDetails(Admission model) throws Exception {
		admission = new Admission();
		admission.setId(model.getId());
		admission.setPatientId(model.getPatientId());
		admission.setLastName(model.getLastName());
		admission.setFirstName(model.getFirstName());
		admission.setMiddleName(model.getMiddleName());
		admission.setGender(model.getGender());
		admission.setPatientStatus(model.getPatientStatus());
		admission.setPatientType(model.getPatientType());
		admission.setCaseNo(model.getCaseNo());
		admission.setChiefComplaint(model.getChiefComplaint());
		admission.setRoomNo(model.getRoomNo());
		admission.setDoctor(model.getDoctor());
		admission.setDateOfCase(model.getDateOfCase());
		admission.setRoomNo(model.getRoomNo());
		admission.setDoctor(model.getDoctor());
		admission.setRoomNoTransfer(model.getRoomNoTransfer());
		admission.setAgeAdmitted(model.getAgeAdmitted());
		admission.setPatientFullName(model.getPatientFullName());
	}

	public Admission populateModel (MonitorPatientFormBean formbean) throws Exception {
		Admission model = new Admission();
		model.setId(formbean.getId());
		return model;
	}

	public Admission populateFormBean (Admission model) throws Exception {
		setId(model.getId());
		if (model.getDateOfCase()!=null) {
			setDateAdmitted(DateUtils.getStrDateFromSQLTimestamp(model.getDateOfCase()));
			setTimeAdmitted(DateUtils.getStrTimeFromSQLTimestamp(model.getDateOfCase()));
		}
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		return errors;
	}
		
	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}


	public MedicationStatement getStatement() {
		return statement;
	}


	public void setStatement(MedicationStatement statement) {
		this.statement = statement;
	}


	public Prognosis getPrognosis() {
		return prognosis;
	}


	public void setPrognosis(Prognosis prognosis) {
		this.prognosis = prognosis;
	}


	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void getPatientAdmissionDetails(int id) throws Exception {

		Admission model = new Admission();
		model.setId(id);
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.ADMISSION);
        dataMap.put(MapConstant.CLASS_DATA, model);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
        
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
		
        if (resultMap!=null && !resultMap.isEmpty()) {
	        model = (Admission) resultMap.get(MapConstant.CLASS_DATA);		        		
        	this.populatePatientAdmissionDetails(model);
        	this.populateFormBean(model);
        }
	}
	
	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void getSummaryInfo(int patientCaseSystemId) throws Exception {
		
		//Get Diagnosis
		Diagnosis model = new Diagnosis();
		model.setPatientCaseSystemId(patientCaseSystemId);
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.DIAGNOSIS);
        dataMap.put(MapConstant.CLASS_DATA, model);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
        
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
		
        if (resultMap!=null && !resultMap.isEmpty()) {	        		
        	setDiagnosis((Diagnosis)resultMap.get(MapConstant.CLASS_DATA));
        	resultMap.clear();
        }
        	
        dataMap.clear();
        
		//Get Medication Statement
		MedicationStatement statementModel = new MedicationStatement();
		statementModel.setPatientCaseSystemId(patientCaseSystemId);
		
        dataMap.put(MapConstant.MODULE, ModuleConstant.MEDICATION_STATEMENT);
        dataMap.put(MapConstant.CLASS_DATA, statementModel);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
        
        resultMap = service.executeRequest(dataMap);
		
        if (resultMap!=null && !resultMap.isEmpty()) {	        		
        	setStatement((MedicationStatement)resultMap.get(MapConstant.CLASS_DATA));
        	resultMap.clear();
        }  
        
        dataMap.clear();
        
		//Get Prognosis
		Prognosis prognosisModel = new Prognosis();
		prognosisModel.setPatientCaseSystemId(patientCaseSystemId);
		
        dataMap.put(MapConstant.MODULE, ModuleConstant.PROGNOSIS);
        dataMap.put(MapConstant.CLASS_DATA, prognosisModel);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
		
        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {	        		
        	setPrognosis((Prognosis)resultMap.get(MapConstant.CLASS_DATA));
            resultMap.clear();
        }
        
        dataMap.clear();
	}
	
}
