package com.transport.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.constant.ParamConstant;
import com.transport.model.DriverIncident;
import com.transport.model.Employee;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.DateUtils;

/**
 * 
 * @author dward
 * @since 10Dec2019
 */
public class DriverIncidentFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String acknowStat;
	private String acknowRemarks;
	private String reportStat;
	private String reportRemarks;
	private String companyStat;
	private String companyRemarks;
	private String incabStat;
	private String incabRemarks;	
	private String dwhStat;
	private String dwhRemarks;
	private String gpsStat;
	private String gpsRemarks;	
	private String ebStat;
	private String ebRemarks;	
	private String alcoholStat;
	private String alcoholRemarks;
	private String driversStat;
	private String driversRemarks;	
	private String policeStat;
	private String policeRemarks;		
	private String photoStat;
	private String photoRemarks;	
	private String picDamageStat;
	private String picDamageRemarks;	
	private String picPlateStat;
	private String picPlateRemarks;	
	private String startStat;
	private String startRemarks;								
	private String withInvestStat;
	private String withInvestRemarks;					
	private String priorStat;
	private String priorRemarks;
	private String nameOne;
	private String positionOne;
	private String nameTwo;
	private String positionTwo;
	private String incidentDate;	
	
	private String searchValue;
	private String category;

	private int noOfPages;
	private int currentPage;
	private List<DriverIncident> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<Employee> driverList;
	private List<Employee> staffList;
	
	public List<Employee> getDriverList() {
		return driverList;
	}


	public void setDriverList(List<Employee> driverList) {
		this.driverList = driverList;
	}


	public DriverIncidentFormBean() {}


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

	public List<DriverIncident> getModelList() {
		return modelList;
	}

	public void setModelList(List<DriverIncident> modelList) {
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
	
	public void populateFormBean(DriverIncident model) throws Exception {
		setId(model.getId());
		setAcknowStat(model.getAcknowStat());
		setAcknowRemarks(model.getAcknowRemarks());
		setReportStat(model.getReportStat());
		setReportRemarks(model.getReportRemarks());
		setCompanyStat(model.getCompanyStat());
		setCompanyRemarks(model.getCompanyRemarks());
		setIncabStat(model.getIncabStat());
		setIncabRemarks(model.getIncabRemarks());
		setDwhStat(model.getDwhStat());
		setDwhRemarks(model.getDwhRemarks());
		setGpsStat(model.getGpsStat());
		setGpsRemarks(model.getGpsRemarks());
		setEbStat(model.getEbStat());
		setEbRemarks(model.getEbRemarks());
		setAlcoholStat(model.getAlcoholStat());
		setAlcoholRemarks(model.getAlcoholRemarks());
		setDriversStat(model.getDriversStat());
		setDriversRemarks(model.getDriversRemarks());
		setPoliceStat(model.getPoliceStat());
		setPoliceRemarks(model.getPoliceRemarks());
		setPhotoStat(model.getPhotoStat());
		setPhotoRemarks(model.getPhotoRemarks());
		setPicDamageStat(model.getPicDamageStat());
		setPicDamageRemarks(model.getPicDamageRemarks());
		setPicPlateStat(model.getPicPlateStat());
		setPicPlateRemarks(model.getPicPlateRemarks());
		setStartStat(model.getStartStat());
		setStartRemarks(model.getStartRemarks());
		setWithInvestStat(model.getWithInvestStat());
		setWithInvestRemarks(model.getWithInvestRemarks());
		setPriorStat(model.getPriorStat());
		setPriorRemarks(model.getPriorRemarks());
		setNameOne(model.getNameOne());
		setPositionOne(model.getPositionOne());
		setNameTwo(model.getNameTwo());
		setPositionTwo(model.getPositionTwo());
		if (model.getIncidentDate()!=null) {
			setIncidentDate(DateUtils.sqlDateToString(model.getIncidentDate()));	
		}
	}
	
	public DriverIncident populateModel () throws Exception {
		DriverIncident model = new DriverIncident();
		model.setId(getId());
		model.setAcknowStat(getAcknowStat());
		model.setAcknowRemarks(getAcknowRemarks());
		model.setReportStat(getReportStat());
		model.setReportRemarks(getReportRemarks());
		model.setCompanyStat(getCompanyStat());
		model.setCompanyRemarks(getCompanyRemarks());
		model.setIncabStat(getIncabStat());
		model.setIncabRemarks(getIncabRemarks());
		model.setDwhStat(getDwhStat());
		model.setDwhRemarks(getDwhRemarks());
		model.setGpsStat(getGpsStat());
		model.setGpsRemarks(getGpsRemarks());
		model.setEbStat(getEbStat());
		model.setEbRemarks(getEbRemarks());
		model.setAlcoholStat(getAlcoholStat());
		model.setAlcoholRemarks(getAlcoholRemarks());
		model.setDriversStat(getDriversStat());
		model.setDriversRemarks(getDriversRemarks());
		model.setPoliceStat(getPoliceStat());
		model.setPoliceRemarks(getPoliceRemarks());
		model.setPhotoStat(getPhotoStat());
		model.setPhotoRemarks(getPhotoRemarks());
		model.setPicDamageStat(getPicDamageStat());
		model.setPicDamageRemarks(getPicDamageRemarks());
		model.setPicPlateStat(getPicPlateStat());
		model.setPicPlateRemarks(getPicPlateRemarks());
		model.setStartStat(getStartStat());
		model.setStartRemarks(getStartRemarks());
		model.setWithInvestStat(getWithInvestStat());
		model.setWithInvestRemarks(getWithInvestRemarks());
		model.setPriorStat(getPriorStat());
		model.setPriorRemarks(getPriorRemarks());
		model.setNameOne(getNameOne());
		model.setPositionOne(getPositionOne());
		model.setNameTwo(getNameTwo());
		model.setPositionTwo(getPositionTwo());
		model.setIncidentDate(DateUtils.strToSQLDate(getIncidentDate()));
		return model;
	}


	public String getSearchValue() {
		return searchValue;
	}


	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getAcknowStat() {
		return acknowStat;
	}


	public void setAcknowStat(String acknowStat) {
		this.acknowStat = acknowStat;
	}


	public String getAcknowRemarks() {
		return acknowRemarks;
	}


	public void setAcknowRemarks(String acknowRemarks) {
		this.acknowRemarks = acknowRemarks;
	}


	public String getReportStat() {
		return reportStat;
	}


	public void setReportStat(String reportStat) {
		this.reportStat = reportStat;
	}


	public String getReportRemarks() {
		return reportRemarks;
	}


	public void setReportRemarks(String reportRemarks) {
		this.reportRemarks = reportRemarks;
	}


	public String getCompanyStat() {
		return companyStat;
	}


	public void setCompanyStat(String companyStat) {
		this.companyStat = companyStat;
	}


	public String getCompanyRemarks() {
		return companyRemarks;
	}


	public void setCompanyRemarks(String companyRemarks) {
		this.companyRemarks = companyRemarks;
	}

	public String getIncabStat() {
		return incabStat;
	}


	public void setIncabStat(String incabStat) {
		this.incabStat = incabStat;
	}


	public String getIncabRemarks() {
		return incabRemarks;
	}


	public void setIncabRemarks(String incabRemarks) {
		this.incabRemarks = incabRemarks;
	}


	public String getDwhStat() {
		return dwhStat;
	}


	public void setDwhStat(String dwhStat) {
		this.dwhStat = dwhStat;
	}


	public String getDwhRemarks() {
		return dwhRemarks;
	}


	public void setDwhRemarks(String dwhRemarks) {
		this.dwhRemarks = dwhRemarks;
	}


	public String getGpsStat() {
		return gpsStat;
	}


	public void setGpsStat(String gpsStat) {
		this.gpsStat = gpsStat;
	}


	public String getGpsRemarks() {
		return gpsRemarks;
	}


	public void setGpsRemarks(String gpsRemarks) {
		this.gpsRemarks = gpsRemarks;
	}


	public String getEbStat() {
		return ebStat;
	}


	public void setEbStat(String ebStat) {
		this.ebStat = ebStat;
	}


	public String getEbRemarks() {
		return ebRemarks;
	}


	public void setEbRemarks(String ebRemarks) {
		this.ebRemarks = ebRemarks;
	}


	public String getAlcoholStat() {
		return alcoholStat;
	}


	public void setAlcoholStat(String alcoholStat) {
		this.alcoholStat = alcoholStat;
	}


	public String getAlcoholRemarks() {
		return alcoholRemarks;
	}


	public void setAlcoholRemarks(String alcoholRemarks) {
		this.alcoholRemarks = alcoholRemarks;
	}


	public String getDriversStat() {
		return driversStat;
	}


	public void setDriversStat(String driversStat) {
		this.driversStat = driversStat;
	}


	public String getDriversRemarks() {
		return driversRemarks;
	}


	public void setDriversRemarks(String driversRemarks) {
		this.driversRemarks = driversRemarks;
	}

	public String getPoliceStat() {
		return policeStat;
	}


	public void setPoliceStat(String policeStat) {
		this.policeStat = policeStat;
	}


	public String getPoliceRemarks() {
		return policeRemarks;
	}


	public void setPoliceRemarks(String policeRemarks) {
		this.policeRemarks = policeRemarks;
	}


	public String getPhotoStat() {
		return photoStat;
	}


	public void setPhotoStat(String photoStat) {
		this.photoStat = photoStat;
	}


	public String getPhotoRemarks() {
		return photoRemarks;
	}


	public void setPhotoRemarks(String photoRemarks) {
		this.photoRemarks = photoRemarks;
	}


	public String getPicDamageStat() {
		return picDamageStat;
	}


	public void setPicDamageStat(String picDamageStat) {
		this.picDamageStat = picDamageStat;
	}


	public String getPicDamageRemarks() {
		return picDamageRemarks;
	}


	public void setPicDamageRemarks(String picDamageRemarks) {
		this.picDamageRemarks = picDamageRemarks;
	}


	public String getPicPlateStat() {
		return picPlateStat;
	}


	public void setPicPlateStat(String picPlateStat) {
		this.picPlateStat = picPlateStat;
	}


	public String getPicPlateRemarks() {
		return picPlateRemarks;
	}


	public void setPicPlateRemarks(String picPlateRemarks) {
		this.picPlateRemarks = picPlateRemarks;
	}

	public String getStartStat() {
		return startStat;
	}


	public void setStartStat(String startStat) {
		this.startStat = startStat;
	}


	public String getStartRemarks() {
		return startRemarks;
	}


	public void setStartRemarks(String startRemarks) {
		this.startRemarks = startRemarks;
	}

	public String getWithInvestStat() {
		return withInvestStat;
	}


	public void setWithInvestStat(String withInvestStat) {
		this.withInvestStat = withInvestStat;
	}


	public String getWithInvestRemarks() {
		return withInvestRemarks;
	}


	public void setWithInvestRemarks(String withInvestRemarks) {
		this.withInvestRemarks = withInvestRemarks;
	}

	public String getPriorStat() {
		return priorStat;
	}


	public void setPriorStat(String priorStat) {
		this.priorStat = priorStat;
	}


	public String getPriorRemarks() {
		return priorRemarks;
	}


	public void setPriorRemarks(String priorRemarks) {
		this.priorRemarks = priorRemarks;
	}


	public String getNameOne() {
		return nameOne;
	}


	public void setNameOne(String nameOne) {
		this.nameOne = nameOne;
	}


	public String getPositionOne() {
		return positionOne;
	}


	public void setPositionOne(String positionOne) {
		this.positionOne = positionOne;
	}


	public String getNameTwo() {
		return nameTwo;
	}


	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}


	public String getPositionTwo() {
		return positionTwo;
	}


	public void setPositionTwo(String positionTwo) {
		this.positionTwo = positionTwo;
	}


	public String getIncidentDate() {
		return incidentDate;
	}


	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}

	
	public List<Employee> getStaffList() {
		return staffList;
	}


	public void setStaffList(List<Employee> staffList) {
		this.staffList = staffList;
	}


	public void populateDriverList(HttpServletRequest request) throws Exception{        
		//get the driver list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.EMPLOYEE);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Employee> qryList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	//customize here get the driver only
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
	
	public void populateStaffList(HttpServletRequest request) throws Exception{        
		//get the driver list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.EMPLOYEE);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Employee> qryList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	//customize here
			List<Employee> customList =  new ArrayList<>();
			
			for (Employee item: qryList) {
				if (item.getEmpCategory().equalsIgnoreCase(MiscConstant.LOV_EMPCATEGORY_MANAGEMENT)) {
					customList.add(item);
				}
			}
	
			setStaffList(customList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_STAFF_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_STAFF_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_STAFF_LIST, customList);
        }
        
	}

	public void populateDropdownList(HttpServletRequest request) throws Exception{
        //get list from Session
		populateDriverList(request);
		populateStaffList(request);
	}
	
	@SuppressWarnings("unchecked")
	public void populateDropdownListFromSession(HttpServletRequest request) throws Exception{
    	if (request.getSession().getAttribute(MiscConstant.TRANS_DRIVER_LIST)!=null) {
    		setDriverList((List<Employee>) request.getSession().getAttribute(MiscConstant.TRANS_DRIVER_LIST));
    	} else {
    		populateDriverList(request);
    	}
    	if (request.getSession().getAttribute(MiscConstant.TRANS_STAFF_LIST)!=null) {
    		setStaffList((List<Employee>) request.getSession().getAttribute(MiscConstant.TRANS_STAFF_LIST));
    	} else {
    		populateStaffList(request);
    	}
	}	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		boolean flag = false;
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getIncidentDate()==null || this.getIncidentDate().trim().equals("")) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.incidentdate.req"));
				flag = true;
			}
		} 
		
		if (flag) {
			try {
				//get list from session
				populateDropdownListFromSession(request);		
						
			} catch(Exception e) {}				
		}
	
		return errors;
	}
}
