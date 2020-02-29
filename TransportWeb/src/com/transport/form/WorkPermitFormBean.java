package com.transport.form;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
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
import com.transport.model.Employee;
import com.transport.model.ListValue;
import com.transport.model.Lorry;
import com.transport.model.WorkPermit;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.DateUtils;

/**
 * 
 * @author dward
 * @since 05Mar2018
 */
public class WorkPermitFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String permitNo;
	private String plateNo;
	private String lorryNo;
	private String itemRepair;
	private String gasFree;
	private String hotWork;
	private String mechanic;
	private String permitIssuer;
	private String dateStarted;
	private String timeStarted;
	private String dateEnded;
	private String timeEnded;
	private String rescue;
	private String odometer;
	private String hub;
	private String transportId;
	private String itemReplace;
	
	private String searchCriteria;
	private String searchValue;
	private String dateFrom;
	private String dateTo;
	private String category;
	
	private int noOfPages;
	private int currentPage;
	private List<WorkPermit> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<Lorry> lorryList;
	private List<Employee> mechanicList;
	private List<Employee> permitIssuerList;
	private List<ListValue> workPermitCriteriaLOV;
	private List<ListValue> transportProgramLOV;
	private List<ListValue> booleanYNLOV;
	
	private String lorryAndPlateNo;//dropDown
	private String mechanicFullName;//dropDown
	private String permitIssuerFullName;//dropDown
	
	public WorkPermitFormBean() {}


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

	public List<WorkPermit> getModelList() {
		return modelList;
	}

	public void setModelList(List<WorkPermit> modelList) {
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
	
	public void populateFormBean(WorkPermit model) throws Exception {
		setId(model.getId());
		setPermitNo(model.getPermitNo());
		setPlateNo(model.getPlateNo());
		setLorryNo(model.getLorryNo());
		setItemRepair(model.getItemRepair());
		setGasFree(model.getGasFree());
		setHotWork(model.getHotWork());
		setMechanic(model.getMechanic());
		setPermitIssuer(model.getPermitIssuer());
		if (model.getDateStarted()!=null) {
			setDateStarted(DateUtils.sqlDateToString(model.getDateStarted()));	
		}
		setTimeStarted(model.getTimeStarted());
		if (model.getDateEnded()!=null) {
			setDateEnded(DateUtils.sqlDateToString(model.getDateEnded()));
		}
		setTimeEnded(model.getTimeEnded());
		setRescue(model.getRescue());
		setOdometer(model.getOdometer());
		setHub(model.getHub());
		setTransportId(String.valueOf(model.getTransportId()));
		setItemReplace(model.getItemReplace());
	}
	
	public WorkPermit populateModel () throws Exception {
		WorkPermit model = new WorkPermit();
		model.setId(getId());
		model.setPermitNo(getPermitNo());
		model.setPlateNo(getPlateNo());
		model.setLorryNo(getLorryNo());
		model.setItemRepair(getItemRepair());
		model.setGasFree(getGasFree());
		model.setHotWork(getHotWork());
		model.setMechanic(getMechanic());
		model.setPermitIssuer(getPermitIssuer());
		if (getDateStarted()!=null && getDateStarted().trim().length()>1) {
			model.setDateStarted(DateUtils.strToSQLDate(getDateStarted()));	
		}
		model.setTimeStarted(getTimeStarted());
		if (getDateEnded()!=null  && getDateEnded().trim().length()>1) {
			model.setDateEnded(DateUtils.strToSQLDate(getDateEnded()));
		}
		model.setTimeEnded(getTimeEnded());
		model.setRescue(getRescue());
		model.setOdometer(getOdometer());
		model.setHub(getHub());
		model.setTransportId(Integer.parseInt(getTransportId()));
		model.setItemReplace(getItemReplace());
		return model;
	}
	
	public void populateDropdownList(HttpServletRequest request, boolean isEdit) throws Exception{
        //get Transport from Session
		populateLorryList(request);
		populateMechanicList(request);
		populatePermitIssuerList(request);
        populateTransportProgramDropdownList(request);
        populateBooleanYNDropdownList(request);
//        populateCriteriaDropdownList(request);   
	}
	
	public void populateTransportProgramDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_TRANSPORT_PROGRAM_SESSION);
    	if (lovList!=null) {
    		setTransportProgramLOV(lovList);
    	}
	}
	
	public void populateDropdownListFromSession(HttpServletRequest request, boolean isEdit) throws Exception{
    	populateDropdownList(request, isEdit);
	}
	
    @SuppressWarnings("unchecked")
	public void populateCriteriaDropdownList(HttpServletRequest request) throws Exception{
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_WORK_PERMIT_CRITERIA_SESSION);
    	if (lovList!=null) {
    		setWorkPermitCriteriaLOV(lovList);
    	}
    	lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_TRANSPORT_PROGRAM_SESSION);
    	if (lovList!=null) {
    		setTransportProgramLOV(lovList);
    	}
	}
	
	public void populateBooleanYNDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_BOOLEAN_YN_SESSION);
    	if (lovList!=null) {
    		setBooleanYNLOV(lovList);
    	}
	}	

	public void populateLorryList(HttpServletRequest request) throws Exception{        
		//get the lorry list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.LORRY);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Lorry> qryList =  (ArrayList<Lorry>) resultMap.get(MapConstant.CLASS_LIST);		        		
			setLorryList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_LORRY_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_LORRY_LIST, qryList);
        }
		
        dataMap = null;
        service = null;
        resultMap = null;
        
	}
	
	public void populateMechanicList(HttpServletRequest request) throws Exception{        
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
				if (item.getEmpCategory().equalsIgnoreCase(MiscConstant.LOV_EMPCATEGORY_MECHANIC)) {
					customList.add(item);
				}
			}
	
			setMechanicList(customList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_MECHANIC_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_MECHANIC_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_MECHANIC_LIST, customList);
        }
        
        dataMap = null;
        service = null;
        resultMap = null;
        
	}

	public void populatePermitIssuerList(HttpServletRequest request) throws Exception{        
		//get the permit issuer list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.EMPLOYEE);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Employee> qryList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	//customize here get the permit issuer only
			List<Employee> customList =  new ArrayList<>();
			
			for (Employee item: qryList) {
				if (item.isPermitIssuer()) {
					customList.add(item);
				}
			}
	
			setPermitIssuerList(customList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_PERMIT_ISSUER_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_PERMIT_ISSUER_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_PERMIT_ISSUER_LIST, customList);
        }
        
        dataMap = null;
        service = null;
        resultMap = null;
        
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
			if (this.getPermitNo()==null || this.getPermitNo().trim().length()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.permitno.req"));
				flag = true;
			}
			if (this.getTransportId().trim().equals("0")) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.transport.req"));
				flag = true;
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




	public String getPermitNo() {
		return permitNo;
	}




	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}




	public String getPlateNo() {
		return plateNo;
	}




	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}




	public String getLorryNo() {
		return lorryNo;
	}




	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}




	public String getItemRepair() {
		return itemRepair;
	}




	public void setItemRepair(String itemRepair) {
		this.itemRepair = itemRepair;
	}




	public String getGasFree() {
		return gasFree;
	}




	public void setGasFree(String gasFree) {
		this.gasFree = gasFree;
	}




	public String getHotWork() {
		return hotWork;
	}




	public void setHotWork(String hotWork) {
		this.hotWork = hotWork;
	}




	public String getMechanic() {
		return mechanic;
	}




	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}




	public String getPermitIssuer() {
		return permitIssuer;
	}




	public void setPermitIssuer(String permitIssuer) {
		this.permitIssuer = permitIssuer;
	}




	public String getDateStarted() {
		return dateStarted;
	}




	public void setDateStarted(String dateStarted) {
		this.dateStarted = dateStarted;
	}




	public String getTimeStarted() {
		return timeStarted;
	}




	public void setTimeStarted(String timeStarted) {
		this.timeStarted = timeStarted;
	}




	public String getDateEnded() {
		return dateEnded;
	}




	public void setDateEnded(String dateEnded) {
		this.dateEnded = dateEnded;
	}




	public String getTimeEnded() {
		return timeEnded;
	}




	public void setTimeEnded(String timeEnded) {
		this.timeEnded = timeEnded;
	}




	public String getRescue() {
		return rescue;
	}




	public void setRescue(String rescue) {
		this.rescue = rescue;
	}




	public String getOdometer() {
		return odometer;
	}




	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}




	public String getHub() {
		return hub;
	}




	public void setHub(String hub) {
		this.hub = hub;
	}




	public List<ListValue> getTransportProgramLOV() {
		return transportProgramLOV;
	}




	public void setTransportProgramLOV(List<ListValue> transportProgramLOV) {
		this.transportProgramLOV = transportProgramLOV;
	}




	public String getTransportId() {
		return transportId;
	}




	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}


	public List<Lorry> getLorryList() {
		return lorryList;
	}


	public void setLorryList(List<Lorry> lorryList) {
		this.lorryList = lorryList;
	}


	public List<Employee> getMechanicList() {
		return mechanicList;
	}


	public void setMechanicList(List<Employee> mechanicList) {
		this.mechanicList = mechanicList;
	}


	public List<Employee> getPermitIssuerList() {
		return permitIssuerList;
	}


	public void setPermitIssuerList(List<Employee> permitIssuerList) {
		this.permitIssuerList = permitIssuerList;
	}


	public String getLorryAndPlateNo() {
		return lorryAndPlateNo;
	}


	public void setLorryAndPlateNo(String lorryAndPlateNo) {
		this.lorryAndPlateNo = lorryAndPlateNo;
	}


	public List<ListValue> getBooleanYNLOV() {
		return booleanYNLOV;
	}


	public void setBooleanYNLOV(List<ListValue> booleanYNLOV) {
		this.booleanYNLOV = booleanYNLOV;
	}


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


	public String getDateFrom() {
		return dateFrom;
	}


	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}


	public String getDateTo() {
		return dateTo;
	}


	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}


	public List<ListValue> getWorkPermitCriteriaLOV() {
		return workPermitCriteriaLOV;
	}


	public void setWorkPermitCriteriaLOV(List<ListValue> workPermitCriteriaLOV) {
		this.workPermitCriteriaLOV = workPermitCriteriaLOV;
	}			


	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getMechanicFullName() {
		return mechanicFullName;
	}


	public void setMechanicFullName(String mechanicFullName) {
		this.mechanicFullName = mechanicFullName;
	}


	public String getPermitIssuerFullName() {
		return permitIssuerFullName;
	}


	public void setPermitIssuerFullName(String permitIssuerFullName) {
		this.permitIssuerFullName = permitIssuerFullName;
	}


	public String getItemReplace() {
		return itemReplace;
	}


	public void setItemReplace(String itemReplace) {
		this.itemReplace = itemReplace;
	}

	

}
