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
import com.pibs.model.Billing;
import com.pibs.model.Patient;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.DateUtils;

public class BillingFormBean extends PIBSFormBean {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id; //patientcasesystemid
	private int billingId; //id in Patient Bill table
	
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
	
	//total
	private String totalAmtLabExam;
	private String totalAmtMedSupply;
	private String totalAmtRadiology;
	private String totalAmtSurgery;
	private String totalAmtAddServices;
	private String totalAmtEquip;
	private String totalAmtOtherDoctor;
	private String totalAmtOtherRoom;
	private String totalAmtDiscount;
	private String totalAmtRoom;
	private String totalAmtDoctor;
	private String totalAmtFee;
	private String totalAmtDue;
	
	//room and doctor details
	private String daysAdmitted;
	private String roomRate;
	private String doctorFee;
	
	private Billing modelBilling;
	
	public BillingFormBean() {}

	
	
	public int getBillingId() {
		return billingId;
	}



	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}



	public Billing getModelBilling() {
		return modelBilling;
	}



	public void setModelBilling(Billing modelBilling) {
		this.modelBilling = modelBilling;
	}



	public String getTotalAmtFee() {
		return totalAmtFee;
	}

	public void setTotalAmtFee(String totalAmtFee) {
		this.totalAmtFee = totalAmtFee;
	}

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
	
	public Admission populateModel (BillingFormBean formbean) throws Exception {
		Admission model = new Admission();
		model.setId(formbean.getId());
		return model;
	}

	public Admission populateFormBean (Admission model) throws Exception {
		setId(model.getId());
		setDateAdmitted(DateUtils.getStrDateFromSQLTimestamp(model.getDateOfCase()));
		setTimeAdmitted(DateUtils.getStrTimeFromSQLTimestamp(model.getDateOfCase()));
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
	
	public void getPatientAdmissionDetails() throws Exception {
		//fetch the patient admission details		
		Admission model = new Admission();
		model.setId(getId());
		
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


	public String getTotalAmtLabExam() {
		return totalAmtLabExam;
	}


	public void setTotalAmtLabExam(String totalAmtLabExam) {
		this.totalAmtLabExam = totalAmtLabExam;
	}


	public String getTotalAmtMedSupply() {
		return totalAmtMedSupply;
	}


	public void setTotalAmtMedSupply(String totalAmtMedSupply) {
		this.totalAmtMedSupply = totalAmtMedSupply;
	}


	public String getTotalAmtRadiology() {
		return totalAmtRadiology;
	}


	public void setTotalAmtRadiology(String totalAmtRadiology) {
		this.totalAmtRadiology = totalAmtRadiology;
	}


	public String getTotalAmtSurgery() {
		return totalAmtSurgery;
	}


	public void setTotalAmtSurgery(String totalAmtSurgery) {
		this.totalAmtSurgery = totalAmtSurgery;
	}


	public String getTotalAmtAddServices() {
		return totalAmtAddServices;
	}


	public void setTotalAmtAddServices(String totalAmtAddServices) {
		this.totalAmtAddServices = totalAmtAddServices;
	}


	public String getTotalAmtEquip() {
		return totalAmtEquip;
	}


	public void setTotalAmtEquip(String totalAmtEquip) {
		this.totalAmtEquip = totalAmtEquip;
	}


	public String getTotalAmtDiscount() {
		return totalAmtDiscount;
	}


	public void setTotalAmtDiscount(String totalAmtDiscount) {
		this.totalAmtDiscount = totalAmtDiscount;
	}


	public String getTotalAmtRoom() {
		return totalAmtRoom;
	}


	public void setTotalAmtRoom(String totalAmtRoom) {
		this.totalAmtRoom = totalAmtRoom;
	}


	public String getTotalAmtDoctor() {
		return totalAmtDoctor;
	}


	public void setTotalAmtDoctor(String totalAmtDoctor) {
		this.totalAmtDoctor = totalAmtDoctor;
	}


	public String getDaysAdmitted() {
		return daysAdmitted;
	}


	public void setDaysAdmitted(String daysAdmitted) {
		this.daysAdmitted = daysAdmitted;
	}


	public String getRoomRate() {
		return roomRate;
	}


	public void setRoomRate(String roomRate) {
		this.roomRate = roomRate;
	}


	public String getDoctorFee() {
		return doctorFee;
	}


	public void setDoctorFee(String doctorFee) {
		this.doctorFee = doctorFee;
	}

	
	public String getTotalAmtDue() {
		return totalAmtDue;
	}


	public void setTotalAmtDue(String totalAmtDue) {
		this.totalAmtDue = totalAmtDue;
	}

	public String getTotalAmtOtherDoctor() {
		return totalAmtOtherDoctor;
	}

	public void setTotalAmtOtherDoctor(String totalAmtOtherDoctor) {
		this.totalAmtOtherDoctor = totalAmtOtherDoctor;
	}



	public String getTotalAmtOtherRoom() {
		return totalAmtOtherRoom;
	}



	public void setTotalAmtOtherRoom(String totalAmtOtherRoom) {
		this.totalAmtOtherRoom = totalAmtOtherRoom;
	}
	
		
}
