package com.pibs.form;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.pibs.dao.impl.AdmissionDaoImpl;
import com.pibs.model.Admission;
import com.pibs.model.Patient;
import com.pibs.model.Professional;
import com.pibs.model.Room;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.DateUtils;
import com.pibs.util.PIBSUtils;

public class AdmissionFormBean extends PIBSFormBean {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String caseNo;
	private String chiefComplaint;
	private int patientSystemId;
	private int roomId;
	private int professionalId;
	private int patientTypeId;
	private int patientCaseStatusId;
	private String ageAdmitted;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Patient> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<Room> roomList;
	private List<Professional> doctorList;
	
	private Patient patient;
	
	private String dateAdmitted;
	private String timeAdmitted;
	
	private String age;
	
	public AdmissionFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public int getPatientSystemId() {
		return patientSystemId;
	}

	public void setPatientSystemId(int patientSystemId) {
		this.patientSystemId = patientSystemId;
	}

	public int getPatientTypeId() {
		return patientTypeId;
	}

	public void setPatientTypeId(int patientTypeId) {
		this.patientTypeId = patientTypeId;
	}

	public int getPatientCaseStatusId() {
		return patientCaseStatusId;
	}

	public void setPatientCaseStatusId(int patientCaseStatusId) {
		this.patientCaseStatusId = patientCaseStatusId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public List<Professional> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Professional> doctorList) {
		this.doctorList = doctorList;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(int professionalId) {
		this.professionalId = professionalId;
	}

	public String getAgeAdmitted() {
		return ageAdmitted;
	}

	public void setAgeAdmitted(String ageAdmitted) {
		this.ageAdmitted = ageAdmitted;
	}

	public void populatePatientDetails(Patient model) throws Exception {
		patient = new Patient();
		patient.setId(model.getId());
		patient.setPatientId(model.getPatientId());
		patient.setLastName(model.getLastName());
		patient.setFirstName(model.getFirstName());
		patient.setMiddleName(model.getMiddleName());
		patient.setGender(model.getGender());
		patient.setContactNo(model.getContactNo());
		patient.setAddress(model.getAddress());
		patient.setContactPerson(model.getContactPerson());
		patient.setContactPersonNo(model.getContactPersonNo());
		patient.setPatientStatusId(model.getPatientStatusId());
		patient.setBirthday(model.getBirthday());
		patient.setFullName();
	}

	public void populateFormBean(Admission model)  throws Exception  {
		setId(model.getId());
		setCaseNo(model.getCaseNo());
		setChiefComplaint(model.getChiefComplaint());
		setPatientSystemId(model.getPatientSystemId());
		setPatientTypeId(model.getPatientTypeId());
		setPatientCaseStatusId(model.getPatientCaseStatusId());
		if (model.getDateOfCase()!=null) {
			setDateAdmitted(DateUtils.sqlTimestampToStringDate(model.getDateOfCase()));
			setTimeAdmitted(DateUtils.getStrTimeFromSQLTimestamp(model.getDateOfCase()));
		}
		if (model.getAgeAdmitted()>0) {
			setAgeAdmitted(String.valueOf(model.getAgeAdmitted()));
		}
		
	}
	
	public Admission populateModel (AdmissionFormBean formbean) throws Exception {
		Admission model = new Admission();
		model.setId(formbean.getId());
		model.setChiefComplaint(formbean.getChiefComplaint());
		model.setPatientSystemId(formbean.getPatientSystemId());
		model.setPatientTypeId(101);//In-Patient
		model.setPatientCaseStatusId(702);//Admitted
		model.setRoomId(formbean.getRoomId());
		model.setProfessionalId(formbean.getProfessionalId());
		if (formbean.getDateAdmitted()!=null && formbean.getDateAdmitted().trim().length() > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(formbean.getDateAdmitted());
			sb.append(" ");
			sb.append(formbean.getTimeAdmitted());
			model.setDateOfCase(DateUtils.strToSQLTimestamp(sb.toString()));//Date and Time
		}
		if (formbean.getAgeAdmitted()!=null) {
			model.setAgeAdmitted(Integer.parseInt(formbean.getAgeAdmitted()));
		}
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		boolean flag = false;
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE))) {
			if (this.getChiefComplaint()==null || this.getChiefComplaint().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.chiefcomplaint.req"));
				flag = true;
			}
			if (this.getRoomId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.room.req"));
				flag = true;
			}
			if (this.getProfessionalId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.doctor.req"));
				flag = true;
			}
			if (this.getDateAdmitted()==null || this.getDateAdmitted().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.dateadmitted.req"));
				flag = true;
			}
			if (this.getTimeAdmitted()==null || this.getTimeAdmitted().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.timeadmitted.req"));
				flag = true;
			}
			if (flag) {
				try {
					populateDropdownListFromSession(request, this, false);
					getPatientDetails(request);
					computeAge();
				} catch(Exception e) {}					
			}
		} 

		return errors;
	}
	
	public void populateDropdownListFromSession(HttpServletRequest request, AdmissionFormBean formBean, boolean isEdit) throws Exception{
		populateDropdownList(request, formBean);//this is the fix for the issue of Failed to obtain Collection in JspException
	}
	
	@SuppressWarnings("unchecked")
	public void populateDropdownList(HttpServletRequest request, AdmissionFormBean formBean) throws Exception{
		//get the room list
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.ROOM);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_AVAILABLE_ROOMS);

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			List<Room> qryList =  (List<Room>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	setRoomList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_ROOM_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_ROOM_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_ROOM_LIST, qryList);
        } else {
        	setRoomList(new ArrayList<Room>());
        }
        
        dataMap = null;
        resultMap = null;
        		
        //get the doctor list
        Professional modelCriteria = new Professional(); 
        modelCriteria.setProfessionalTypeId(1);//1 for Medical Doctor
        dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.PROFESSIONAL);
        dataMap.put(MapConstant.CLASS_DATA, modelCriteria);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA_BY_ID_TYPE);

        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			List<Professional> qryList =  (List<Professional>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	setDoctorList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_DOCTOR_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_DOCTOR_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_DOCTOR_LIST, qryList);
        } else {
        	setDoctorList(new ArrayList<Professional>());
        }
 
	}
	
	//Generation of Admission ID
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String generateAdmissionId() throws Exception {
		StringBuilder sb = new StringBuilder(15);
		try {
			Calendar now = Calendar.getInstance();
			int currentMonth = now.get(Calendar.MONTH) + 1;//0-11
			int currentDayOfMonth = now.get(Calendar.DAY_OF_MONTH);
			sb.append("A");
			sb.append(now.get(Calendar.YEAR));
			sb.append(String.format("%02d", currentMonth));
			sb.append(String.format("%02d", currentDayOfMonth));
			sb.append(String.format("%07d", AdmissionDaoImpl.getAdmissionCount()+1));//get the admission count
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}
	
	public void getPatientDetails(HttpServletRequest request) throws Exception {
		//fetch the patient details
		int id = Integer.parseInt(request.getParameter("patientSystemId"));
		
		Patient model = new Patient();
		model.setId(id);
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.PATIENT);
        dataMap.put(MapConstant.CLASS_DATA, model);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
        
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
		
        if (resultMap!=null && !resultMap.isEmpty()) {
	        model = (Patient) resultMap.get(MapConstant.CLASS_DATA);		        		
        	this.populatePatientDetails(model);
        }
	}
	
	public void computeAge() throws Exception {
		String age = null;
		if (this.getPatient().getBirthday()!=null) {
			age = String.valueOf(PIBSUtils.getAge(LocalDate.parse(DateUtils.sqlDateToStringSQL(this.getPatient().getBirthday()))));
		}
		this.setAgeAdmitted(age);
	}
	
	
}
