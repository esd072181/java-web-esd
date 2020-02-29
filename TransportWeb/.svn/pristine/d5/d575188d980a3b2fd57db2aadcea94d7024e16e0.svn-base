package com.transport.form;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.constant.ParamConstant;
import com.transport.model.DriverTraining;
import com.transport.model.DriverTrainingInfo;
import com.transport.model.DriverTrainingProfile;
import com.transport.model.DriverTrainingProfileComment;
import com.transport.model.Employee;
import com.transport.model.ListValue;
import com.transport.model.Remarks;
import com.transport.model.Terminal;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.DateUtils;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 26Aug2019
 * UpdatedOn: 14Jan2020
 */
public class DriverTrainingFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String driverId;
	private String sss;
	private String pagibig;
	private String tin;
	private String terminalId;
	private String articulated;
	private String birthday;
	private String dateHired;
	private String licenseNo;
	private String licenseValidity;
	private String contactNo;
	private String religion;
	private String gender;
	private String civilStatus;
	private String spouse;
	private String philhealthNo;
	private String height;
	private String weight;
	private String mothersName;
	private String fathersName;
	private String address;
	private String elementary;
	private String elementaryDate;
	private String secondary;
	private String secondaryDate;
	private String tertiary;
	private String tertiaryDate;
	private String employmentDateFrom1;
	private String employmentDateTo1;
	private String employmentPosition1;
	private String employmentCompany1;
	private String employmentDateFrom2;
	private String employmentDateTo2;
	private String employmentPosition2;
	private String employmentCompany2;
	private String employmentDateFrom3;
	private String employmentDateTo3;
	private String employmentPosition3;
	private String employmentCompany3;
	private String ftw;
	private String nbi;
	
	private FormFile file;
	private String picStr;
	private String age;
	
	private String searchValue;
	private String category;

	private int noOfPages;
	private int currentPage;
	private List<DriverTraining> modelList;
	private List<DriverTrainingInfo> trainingList;
	private List<DriverTrainingProfile> profileList;
	private List<DriverTrainingProfileComment> commentList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<Terminal> terminalList;
	private List<Employee> driverList;
	private List<ListValue> trainingLOVList;
	private List<Remarks> statusList;
	
	//for driver training info
	private String driverTrainingId;
	private String driverName;
	private String trainingId;
	private String expiryDate;
	private String terminalName;
	
	//for driver training profile
	private String vnv;
	private String incab;
	private String spotcheck;
	private String incident;
	private String notes;
	private String statusId;
	private String profileDate;

	//for driver training profile comments
	private String driverTrainingProfileId;
	private String remarks;//remarks of vnv,incab,spotcheck or incident
	private String comment;
	
	//for driver training summary report
	private String driverNameForReport;
	
	public String getInnerModule() {
		return innerModule;
	}


	public void setInnerModule(String innerModule) {
		this.innerModule = innerModule;
	}


	private String innerModule;
	

	public DriverTrainingFormBean() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<DriverTraining> getModelList() {
		return modelList;
	}

	public void setModelList(List<DriverTraining> modelList) {
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
	
	public void populateFormBean(DriverTraining model) throws Exception {
		setId(model.getId());
		setDriverId(String.valueOf(model.getDriverId()));
		setSss(model.getSss());
		setPagibig(model.getPagibig());
		setTin(model.getTin());
		setPicStr(model.getPicStr());
		setTerminalId(String.valueOf(model.getTerminalId()));
		setArticulated(model.getArticulated());
		if (model.getBirthday()!=null) {
			setBirthday(DateUtils.sqlDateToString(model.getBirthday()));	
		}
		if (model.getAge()>0) {
			setAge(String.valueOf(model.getAge()));
		}
		setDriverName(model.getFullName());
		setTerminalName(getTerminalNameById(model.getTerminalId()));
		if (model.getDateHired()!=null) {
			setDateHired(DateUtils.sqlDateToString(model.getDateHired()));	
		}
		setLicenseNo(model.getLicenseNo());
		if (model.getLicenseValidity()!=null) {
			setLicenseValidity(DateUtils.sqlDateToString(model.getLicenseValidity()));	
		}
		setContactNo(model.getContactNo());
		setReligion(model.getReligion());
		setGender(model.getGender());
		setCivilStatus(model.getCivilStatus());
		setSpouse(model.getSpouse());
		setPhilhealthNo(model.getPhilhealthNo());
		setHeight(model.getHeight());
		setWeight(model.getWeight());
		setMothersName(model.getMothersName());
		setFathersName(model.getFathersName());
		setAddress(model.getAddress());
		setElementary(model.getElementary());
		setElementaryDate(model.getElementaryDate());
		setSecondary(model.getSecondary());
		setSecondaryDate(model.getSecondaryDate());
		setTertiary(model.getTertiary());
		setTertiaryDate(model.getTertiaryDate());
		setEmploymentDateFrom1(model.getEmploymentDateFrom1());
		setEmploymentDateTo1(model.getEmploymentDateTo1());
		setEmploymentPosition1(model.getEmploymentPosition1());
		setEmploymentCompany1(model.getEmploymentCompany1());
		setEmploymentDateFrom2(model.getEmploymentDateFrom2());
		setEmploymentDateTo2(model.getEmploymentDateTo2());
		setEmploymentPosition2(model.getEmploymentPosition2());
		setEmploymentCompany2(model.getEmploymentCompany2());
		setEmploymentDateFrom3(model.getEmploymentDateFrom3());
		setEmploymentDateTo3(model.getEmploymentDateTo3());
		setEmploymentPosition3(model.getEmploymentPosition3());
		setEmploymentCompany3(model.getEmploymentCompany3());
		if (model.getFtw()!=null) {
			setFtw(DateUtils.sqlDateToString(model.getFtw()));	
		}
		if (model.getNbi()!=null) {
			setNbi(DateUtils.sqlDateToString(model.getNbi()));	
		}
	}
	
	public DriverTraining populateModel () throws Exception {
		DriverTraining model = new DriverTraining();
		model.setId(getId());
		model.setDriverId(Integer.parseInt(getDriverId()));
		model.setSss(getSss());
		model.setPagibig(getPagibig());
		model.setTin(getTin());
		if (getFile()!=null && getFile().getFileSize() > 0) {
			
			String filePath = getServlet().getServletContext().getRealPath("/") +"upload";
			String fileName = file.getFileName();
			
			if(!("").equals(fileName)){  
		    	
		        File newFile = new File(filePath, fileName);
	              
		        if(!newFile.exists()){
		        	TransportUtils.uploadPic(newFile, file);
		        }  
		        
		        model.setPicName(getFile().getFileName());
		        model.setPic(newFile);
		    }
				
		}
		model.setTerminalId(Integer.parseInt(getTerminalId()));
		model.setArticulated(getArticulated());
		if (getBirthday()!=null && getBirthday().trim().length()>1) {
			model.setBirthday(DateUtils.strToSQLDate(getBirthday()));	
		}
		model.setTerminalName(getTerminalNameById(model.getTerminalId()));
		
		if (getDateHired()!=null && getDateHired().trim().length()>1) {
			model.setDateHired(DateUtils.strToSQLDate(getDateHired()));	
		}
		model.setLicenseNo(getLicenseNo());
		if (getLicenseValidity()!=null && getLicenseValidity().trim().length()>1) {
			model.setLicenseValidity(DateUtils.strToSQLDate(getLicenseValidity()));	
		}
		model.setContactNo(getContactNo());
		model.setReligion(getReligion());
		model.setGender(getGender());
		model.setCivilStatus(getCivilStatus());
		model.setSpouse(getSpouse());
		model.setPhilhealthNo(getPhilhealthNo());
		model.setHeight(getHeight());
		model.setWeight(getWeight());
		model.setMothersName(getMothersName());
		model.setFathersName(getFathersName());
		model.setAddress(getAddress());
		model.setElementary(getElementary());
		model.setElementaryDate(getElementaryDate());
		model.setSecondary(getSecondary());
		model.setSecondaryDate(getSecondaryDate());
		model.setTertiary(getTertiary());
		model.setTertiaryDate(getTertiaryDate());
		model.setEmploymentDateFrom1(getEmploymentDateFrom1());
		model.setEmploymentDateTo1(getEmploymentDateTo1());
		model.setEmploymentPosition1(getEmploymentPosition1());
		model.setEmploymentCompany1(getEmploymentCompany1());
		model.setEmploymentDateFrom2(getEmploymentDateFrom2());
		model.setEmploymentDateTo2(getEmploymentDateTo2());
		model.setEmploymentPosition2(getEmploymentPosition2());
		model.setEmploymentCompany2(getEmploymentCompany2());
		model.setEmploymentDateFrom3(getEmploymentDateFrom3());
		model.setEmploymentDateTo3(getEmploymentDateTo3());
		model.setEmploymentPosition3(getEmploymentPosition3());
		model.setEmploymentCompany3(getEmploymentCompany3());
		if (getFtw()!=null && getFtw().trim().length()>1) {
			model.setFtw(DateUtils.strToSQLDate(getFtw()));	
		}
		if (getNbi()!=null && getNbi().trim().length()>1) {
			model.setNbi(DateUtils.strToSQLDate(getNbi()));	
		}
		return model;
	}
	
	public void populateDropdownList(HttpServletRequest request, boolean isEdit) throws Exception{
        //get list from Session
		populateTerminalList(request);
		populateDriverList(request);
		populateTrainingDropdownList(request);
		populateStatusDropdownList(request);
	}
	
	public void populateDropdownListFromSession(HttpServletRequest request, boolean isEdit) throws Exception{
    	populateDropdownList(request, isEdit);
	}
	
	public void populateTerminalList(HttpServletRequest request) throws Exception{        
		//get the lorry list
        HashMap<String,Object> dataMap = new HashMap<>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.TERMINAL);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Terminal> qryList =  (ArrayList<Terminal>) resultMap.get(MapConstant.CLASS_LIST);		        		
			setTerminalList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_TERMINAL_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_TERMINAL_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_TERMINAL_LIST, qryList);
        }
        
	}
	
	public void populateDriverList(HttpServletRequest request) throws Exception{        
		//get the mechanic list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.EMPLOYEE);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Employee> qryList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	//customize here get the mechanic only
			List<Employee> customList =  new ArrayList<>();
			
			for (Employee item: qryList) {
				if (item.getEmpCategory().equalsIgnoreCase(MiscConstant.LOV_EMPCATEGORY_DRIVER)) {
					customList.add(item);
				}
			}
	
			setDriverList(customList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_DRIVER_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_DRIVER_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_DRIVER_LIST, customList);
        }
        
	}
	
	public void populateTrainingDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_DRIVER_TRAINING_SESSION);
    	if (lovList!=null) {
    		setTrainingLOVList(lovList);
    	}
	}	

	public void populateStatusDropdownList(HttpServletRequest request) throws Exception{
    	//get the remarks list
		HashMap<String,Object> dataMap = new HashMap<>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.REMARKS);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Remarks> qryList =  (ArrayList<Remarks>) resultMap.get(MapConstant.CLASS_LIST);		        		
			setStatusList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_REMARKS_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_REMARKS_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_REMARKS_LIST, qryList);
        }
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			boolean flag = false;
			boolean isEdit = (command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)? true: false);
			if (this.getDriverId()==null || this.getDriverId().trim().equals("0")) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.driver.req"));
				flag = true;
			}
			if (this.getTerminalId()==null || this.getTerminalId().trim().equals("0")) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.terminalname.req"));
				flag = true;
			}
			
			if (flag) {
				try {
					//get list from session
					populateDropdownListFromSession(request, isEdit);		
							
				} catch(Exception e) {}				
			}

	
		}  else if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE_INNER))) {
			//check the inner module
			boolean flag = false;
			boolean isEdit = (command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)? true: false);
			int innerModule = Integer.parseInt(request.getParameter("innerModule"));

			if (ModuleConstant.DRIVER_TRAINING_INFO == innerModule) {
				if (this.getTrainingId()==null || this.getTrainingId().trim().equals("0")) {
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.training.req"));
					flag = true;
				}
				if (this.getExpiryDate()==null || this.getExpiryDate().trim().equals("")) {
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.expirydate.req"));
					flag = true;
				}	
				
			} else if (ModuleConstant.DRIVER_TRAINING_PROFILE == innerModule) {
				if (this.getProfileDate()==null || this.getProfileDate().trim().equals("")) {
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.profiledate.req"));
					flag = true;
				}
				if (this.getStatusId()==null || this.getStatusId().trim().equals("0")) {
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.status.req"));
					flag = true;
				}
			} else if (ModuleConstant.DRIVER_TRAINING_PROFILE_COMMENTS_VNV == innerModule ||
					ModuleConstant.DRIVER_TRAINING_PROFILE_COMMENTS_INCAB == innerModule ||
					ModuleConstant.DRIVER_TRAINING_PROFILE_COMMENTS_SPOTCHECK == innerModule ||
					ModuleConstant.DRIVER_TRAINING_PROFILE_COMMENTS_INCIDENT == innerModule) {	
				if (this.getComment()==null || this.getComment().trim().equals("")) {
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.comment.req"));
					flag = true;
				}

			}
			
			if (flag) {
				try {
					//get list from session
					populateDropdownListFromSession(request, isEdit);		
							
				} catch(Exception e) {}				
			}
			
		}
	
		return errors;
	}


	public String getDriverId() {
		return driverId;
	}


	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}



	public String getTerminalId() {
		return terminalId;
	}


	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}


	public String getArticulated() {
		return articulated;
	}


	public void setArticulated(String articulated) {
		this.articulated = articulated;
	}




	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getSearchValue() {
		return searchValue;
	}


	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}


	public List<Terminal> getTerminalList() {
		return terminalList;
	}


	public void setTerminalList(List<Terminal> terminalList) {
		this.terminalList = terminalList;
	}


	public List<Employee> getDriverList() {
		return driverList;
	}


	public void setDriverList(List<Employee> driverList) {
		this.driverList = driverList;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public FormFile getFile() {
		return file;
	}


	public void setFile(FormFile file) {
		this.file = file;
	}


	public String getPicStr() {
		return picStr;
	}


	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getSss() {
		return sss;
	}


	public void setSss(String sss) {
		this.sss = sss;
	}


	public String getPagibig() {
		return pagibig;
	}


	public void setPagibig(String pagibig) {
		this.pagibig = pagibig;
	}


	public String getTin() {
		return tin;
	}


	public void setTin(String tin) {
		this.tin = tin;
	}



	public String getTrainingId() {
		return trainingId;
	}


	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public List<DriverTrainingInfo> getTrainingList() {
		return trainingList;
	}


	public void setTrainingList(List<DriverTrainingInfo> trainingList) {
		this.trainingList = trainingList;
	}


	public String getDriverTrainingId() {
		return driverTrainingId;
	}


	public void setDriverTrainingId(String driverTrainingId) {
		this.driverTrainingId = driverTrainingId;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public List<ListValue> getTrainingLOVList() {
		return trainingLOVList;
	}


	public void setTrainingLOVList(List<ListValue> trainingLOVList) {
		this.trainingLOVList = trainingLOVList;
	}

	
	public List<DriverTrainingProfile> getProfileList() {
		return profileList;
	}


	public void setProfileList(List<DriverTrainingProfile> profileList) {
		this.profileList = profileList;
	}

	


	public List<Remarks> getStatusList() {
		return statusList;
	}


	public void setStatusList(List<Remarks> statusList) {
		this.statusList = statusList;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getStatusId() {
		return statusId;
	}


	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}


	public String getProfileDate() {
		return profileDate;
	}


	public void setProfileDate(String profileDate) {
		this.profileDate = profileDate;
	}


	public String getVnv() {
		return vnv;
	}


	public void setVnv(String vnv) {
		this.vnv = vnv;
	}


	public String getIncab() {
		return incab;
	}


	public void setIncab(String incab) {
		this.incab = incab;
	}


	public String getSpotcheck() {
		return spotcheck;
	}


	public void setSpotcheck(String spotcheck) {
		this.spotcheck = spotcheck;
	}


	public String getIncident() {
		return incident;
	}


	public void setIncident(String incident) {
		this.incident = incident;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getDriverTrainingProfileId() {
		return driverTrainingProfileId;
	}


	public void setDriverTrainingProfileId(String driverTrainingProfileId) {
		this.driverTrainingProfileId = driverTrainingProfileId;
	}


	public List<DriverTrainingProfileComment> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<DriverTrainingProfileComment> commentList) {
		this.commentList = commentList;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	/**
	 * Driver Training Info Inner Module - 251
	 * @return
	 * @throws Exception
	 */
	public DriverTrainingInfo populateModelInfo () throws Exception {
		DriverTrainingInfo model = new DriverTrainingInfo();
		model.setId(getId());
		model.setDriverTrainingId(Integer.valueOf(getDriverTrainingId()));
		model.setTrainingId(Integer.valueOf(getTrainingId()));
		if (getExpiryDate()!=null && getExpiryDate().trim().length()>1) {
			model.setExpiryDate(DateUtils.strToSQLDate(getExpiryDate()));	
		}
		return model;
	}

	/**
	 * Driver Training Info Inner Module - 251
	 * @param model
	 * @throws Exception
	 */
	public void populateFormBeanInfo(DriverTrainingInfo model) throws Exception {
		setId(model.getId());
		setDriverTrainingId(String.valueOf(model.getDriverTrainingId()));
		setTrainingId(String.valueOf(model.getTrainingId()));
		if (model.getExpiryDate()!=null) {
			setExpiryDate(DateUtils.sqlDateToString(model.getExpiryDate()));	
		}
		
	}

	/**
	 * Driver Training Profile Inner Module - 252
	 * @return
	 * @throws Exception
	 */
	public DriverTrainingProfile populateModelProfile () throws Exception {
		DriverTrainingProfile model = new DriverTrainingProfile();
		model.setId(getId());
		model.setDriverTrainingId(Integer.valueOf(getDriverTrainingId()));
		model.setVnv(getVnv());
		model.setIncab(getIncab());
		model.setSpotcheck(getSpotcheck());
		model.setIncident(getIncident());
		model.setNotes(getNotes());
		if (getProfileDate()!=null && getProfileDate().trim().length()>1) {
			model.setProfileDate(DateUtils.strToSQLDate(getProfileDate()));	
		}
		model.setStatusId(Integer.valueOf(getStatusId()));
		return model;
	}
	
	/**
	 * Driver Training Profile Inner Module - 252
	 * @param model
	 * @throws Exception
	 */
	public void populateFormBeanProfile(DriverTrainingProfile model) throws Exception {
		setId(model.getId());
		setDriverTrainingId(String.valueOf(model.getDriverTrainingId()));
		setVnv(model.getVnv());
		setIncab(model.getIncab());
		setSpotcheck(model.getSpotcheck());
		setIncident(model.getIncident());
		setNotes(model.getNotes());
		if (model.getProfileDate()!=null) {
			setProfileDate(DateUtils.sqlDateToString(model.getProfileDate()));	
		}
		setStatusId(String.valueOf(model.getStatusId()));
	}
	
	/**
	 * Driver Training Profile Comments Inner Module - 253, 254, 255 and 256
	 * @return
	 * @throws Exception
	 */
	public DriverTrainingProfileComment populateModelProfileComment() throws Exception {
		DriverTrainingProfileComment model = new DriverTrainingProfileComment();
		model.setId(getId());
		model.setDriverTrainingProfileId(Integer.valueOf(getDriverTrainingProfileId().trim()));
		model.setRemarks(getComment());
		return model;
	}
	
	/**
	 * Driver Training Profile Comments Inner Module - 253, 254, 255 and 256
	 * @param model
	 * @throws Exception
	 */
	public void populateFormBeanProfileComment(DriverTrainingProfileComment model) throws Exception {
		setId(model.getId());
		setDriverTrainingProfileId(String.valueOf(model.getDriverTrainingProfileId()));
		setComment(model.getRemarks());
	}


	public String getTerminalName() {
		return terminalName;
	}


	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String getTerminalNameById (int id) {
		String name = "";
		if (getTerminalList()!=null && getTerminalList().size()>0) {
			for (Terminal item: getTerminalList()) {
				if (item.getId() == id) {
					name = item.getName();
					break;
				}
			}			
		}
		return name;
	}


	public String getDriverNameForReport() {; 
		return  driverNameForReport;
	}


	public void setDriverNameForReport(String driverNameForReport) {
		this.driverNameForReport = driverNameForReport;
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


	public String getLicenseValidity() {
		return licenseValidity;
	}


	public void setLicenseValidity(String licenseValidity) {
		this.licenseValidity = licenseValidity;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCivilStatus() {
		return civilStatus;
	}


	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}


	public String getSpouse() {
		return spouse;
	}


	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}


	public String getPhilhealthNo() {
		return philhealthNo;
	}


	public void setPhilhealthNo(String philhealthNo) {
		this.philhealthNo = philhealthNo;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getMothersName() {
		return mothersName;
	}


	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}


	public String getFathersName() {
		return fathersName;
	}


	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getElementary() {
		return elementary;
	}


	public void setElementary(String elementary) {
		this.elementary = elementary;
	}


	public String getElementaryDate() {
		return elementaryDate;
	}


	public void setElementaryDate(String elementaryDate) {
		this.elementaryDate = elementaryDate;
	}


	public String getSecondary() {
		return secondary;
	}


	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}


	public String getSecondaryDate() {
		return secondaryDate;
	}


	public void setSecondaryDate(String secondaryDate) {
		this.secondaryDate = secondaryDate;
	}


	public String getTertiary() {
		return tertiary;
	}


	public void setTertiary(String tertiary) {
		this.tertiary = tertiary;
	}


	public String getTertiaryDate() {
		return tertiaryDate;
	}


	public void setTertiaryDate(String tertiaryDate) {
		this.tertiaryDate = tertiaryDate;
	}


	public String getEmploymentDateFrom1() {
		return employmentDateFrom1;
	}


	public void setEmploymentDateFrom1(String employmentDateFrom1) {
		this.employmentDateFrom1 = employmentDateFrom1;
	}


	public String getEmploymentDateTo1() {
		return employmentDateTo1;
	}


	public void setEmploymentDateTo1(String employmentDateTo1) {
		this.employmentDateTo1 = employmentDateTo1;
	}


	public String getEmploymentPosition1() {
		return employmentPosition1;
	}


	public void setEmploymentPosition1(String employmentPosition1) {
		this.employmentPosition1 = employmentPosition1;
	}


	public String getEmploymentCompany1() {
		return employmentCompany1;
	}


	public void setEmploymentCompany1(String employmentCompany1) {
		this.employmentCompany1 = employmentCompany1;
	}


	public String getEmploymentDateFrom2() {
		return employmentDateFrom2;
	}


	public void setEmploymentDateFrom2(String employmentDateFrom2) {
		this.employmentDateFrom2 = employmentDateFrom2;
	}


	public String getEmploymentDateTo2() {
		return employmentDateTo2;
	}


	public void setEmploymentDateTo2(String employmentDateTo2) {
		this.employmentDateTo2 = employmentDateTo2;
	}


	public String getEmploymentPosition2() {
		return employmentPosition2;
	}


	public void setEmploymentPosition2(String employmentPosition2) {
		this.employmentPosition2 = employmentPosition2;
	}


	public String getEmploymentCompany2() {
		return employmentCompany2;
	}


	public void setEmploymentCompany2(String employmentCompany2) {
		this.employmentCompany2 = employmentCompany2;
	}


	public String getEmploymentDateFrom3() {
		return employmentDateFrom3;
	}


	public void setEmploymentDateFrom3(String employmentDateFrom3) {
		this.employmentDateFrom3 = employmentDateFrom3;
	}


	public String getEmploymentDateTo3() {
		return employmentDateTo3;
	}


	public void setEmploymentDateTo3(String employmentDateTo3) {
		this.employmentDateTo3 = employmentDateTo3;
	}


	public String getEmploymentPosition3() {
		return employmentPosition3;
	}


	public void setEmploymentPosition3(String employmentPosition3) {
		this.employmentPosition3 = employmentPosition3;
	}


	public String getEmploymentCompany3() {
		return employmentCompany3;
	}


	public void setEmploymentCompany3(String employmentCompany3) {
		this.employmentCompany3 = employmentCompany3;
	}


	public String getFtw() {
		return ftw;
	}


	public void setFtw(String ftw) {
		this.ftw = ftw;
	}


	public String getNbi() {
		return nbi;
	}


	public void setNbi(String nbi) {
		this.nbi = nbi;
	}
	
	
	
}
