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
import com.transport.constant.SubActionConstant;
import com.transport.model.Closure;
import com.transport.model.Corrections;
import com.transport.model.Employee;
import com.transport.model.Findings;
import com.transport.model.FollowUp;
import com.transport.model.Items;
import com.transport.model.ListValue;
import com.transport.model.Lorry;
import com.transport.model.Remarks;
import com.transport.model.RootCause;
import com.transport.model.Terminal;
import com.transport.model.VerificationAndValidation;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.DateUtils;

/**
 * 
 * @author dward
 * note: isPositiveFindings() sets the remarks default Closed or Open (see javascript isPositiveFindings function)
 */
public class VerificationAndValidationFormBean extends TransportFormBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int itemId;
	private int findingsId;
	private int terminalId;
	private int driverId;
	private int lorryId;
	private String verificationDate;
	private int correctionsId;
	private int verificationCheckedById;
	private int followUpId;
	private int terminalIdValidation;
	private int driverIdValidation;
	private int lorryIdValidation;
	private String validationDate;
	private int validationCheckedById;
	private int remarksId;
	//private String rootCause;
	private int rootCauseId;
	private int closureId;
	
	private String searchCriteria;
	private String searchValue;
	private String dateFrom;
	private String dateTo;
	private List<ListValue> verificationCriteriaLOV;
	
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<VerificationAndValidation> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<Items> itemList;
	private List<HashMap<String, String>> driverList;
	private List<Lorry> lorryList;
	private List<Corrections> correctionsList;
	private List<HashMap<String, String>> checkedByList;
	private List<FollowUp> followUpList;
	private List<Remarks> remarksList;
	private List<Terminal> terminalList;
	private List<Findings> findingsList;
	private List<RootCause> rootCauseList;
	private List<Closure> closureList;
	
	public VerificationAndValidationFormBean() {}
	
	
	
	public int getClosureId() {
		return closureId;
	}



	public void setClosureId(int closureId) {
		this.closureId = closureId;
	}



	public List<Closure> getClosureList() {
		return closureList;
	}



	public void setClosureList(List<Closure> closureList) {
		this.closureList = closureList;
	}



	public List<RootCause> getRootCauseList() {
		return rootCauseList;
	}


	public void setRootCauseList(List<RootCause> rootCauseList) {
		this.rootCauseList = rootCauseList;
	}


//	public String getRootCause() {
//		return rootCause;
//	}
//
//	public void setRootCause(String rootCause) {
//		this.rootCause = rootCause;
//	}

	public int getRootCauseId() {
		return rootCauseId;
	}


	public void setRootCauseId(int rootCauseId) {
		this.rootCauseId = rootCauseId;
	}


	public int getFindingsId() {
		return findingsId;
	}

	public void setFindingsId(int findingsId) {
		this.findingsId = findingsId;
	}

	public int getTerminalIdValidation() {
		return terminalIdValidation;
	}

	public void setTerminalIdValidation(int terminalIdValidation) {
		this.terminalIdValidation = terminalIdValidation;
	}

	public int getDriverIdValidation() {
		return driverIdValidation;
	}


	public void setDriverIdValidation(int driverIdValidation) {
		this.driverIdValidation = driverIdValidation;
	}



	public int getLorryIdValidation() {
		return lorryIdValidation;
	}



	public void setLorryIdValidation(int lorryIdValidation) {
		this.lorryIdValidation = lorryIdValidation;
	}



	public List<Findings> getFindingsList() {
		return findingsList;
	}



	public void setFindingsList(List<Findings> findingsList) {
		this.findingsList = findingsList;
	}



	public List<ListValue> getVerificationCriteriaLOV() {
		return verificationCriteriaLOV;
	}



	public void setVerificationCriteriaLOV(List<ListValue> verificationCriteriaLOV) {
		this.verificationCriteriaLOV = verificationCriteriaLOV;
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



	public int getTerminalId() {
		return terminalId;
	}



	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}



	public List<Terminal> getTerminalList() {
		return terminalList;
	}



	public void setTerminalList(List<Terminal> terminalList) {
		this.terminalList = terminalList;
	}



	public String getVerificationDate() {
		return verificationDate;
	}


	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}


	public String getValidationDate() {
		return validationDate;
	}


	public void setValidationDate(String validationDate) {
		this.validationDate = validationDate;
	}


	public List<Remarks> getRemarksList() {
		return remarksList;
	}


	public void setRemarksList(List<Remarks> remarksList) {
		this.remarksList = remarksList;
	}


	public List<FollowUp> getFollowUpList() {
		return followUpList;
	}


	public void setFollowUpList(List<FollowUp> followUpList) {
		this.followUpList = followUpList;
	}


	public List<HashMap<String, String>> getCheckedByList() {
		return checkedByList;
	}


	public void setCheckedByList(List<HashMap<String, String>> checkedByList) {
		this.checkedByList = checkedByList;
	}


	public List<Corrections> getCorrectionsList() {
		return correctionsList;
	}


	public void setCorrectionsList(List<Corrections> correctionsList) {
		this.correctionsList = correctionsList;
	}


	public List<Lorry> getLorryList() {
		return lorryList;
	}


	public void setLorryList(List<Lorry> lorryList) {
		this.lorryList = lorryList;
	}


	public List<HashMap<String, String>> getDriverList() {
		return driverList;
	}

	public void setDriverList(List<HashMap<String, String>> driverList) {
		this.driverList = driverList;
	}

	public List<Items> getItemList() {
		return itemList;
	}


	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getLorryId() {
		return lorryId;
	}

	public void setLorryId(int lorryId) {
		this.lorryId = lorryId;
	}




	public int getCorrectionsId() {
		return correctionsId;
	}

	public void setCorrectionsId(int correctionsId) {
		this.correctionsId = correctionsId;
	}

	public int getVerificationCheckedById() {
		return verificationCheckedById;
	}

	public void setVerificationCheckedById(int verificationCheckedById) {
		this.verificationCheckedById = verificationCheckedById;
	}

	public int getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(int followUpId) {
		this.followUpId = followUpId;
	}


	public int getValidationCheckedById() {
		return validationCheckedById;
	}

	public void setValidationCheckedById(int validationCheckedById) {
		this.validationCheckedById = validationCheckedById;
	}

	public int getRemarksId() {
		return remarksId;
	}

	public void setRemarksId(int remarksId) {
		this.remarksId = remarksId;
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

	public List<VerificationAndValidation> getModelList() {
		return modelList;
	}

	public void setModelList(List<VerificationAndValidation> modelList) {
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
	
	
	public void populateFormBean(VerificationAndValidation model) throws Exception{
		setId(model.getId());
		setItemId(model.getItemId());
		setFindingsId(model.getFindingsId());
		setDriverId(model.getDriverId());
		setTerminalId(model.getTerminalId());
		setLorryId(model.getLorryId());
		if (model.getVerificationDate()!=null) {
			setVerificationDate(DateUtils.sqlDateToString(model.getVerificationDate()));
		}
		setCorrectionsId(model.getCorrectionsId());
		setVerificationCheckedById(model.getVerificationCheckedById());
		setFollowUpId(model.getFollowUpId());
		setDriverIdValidation(model.getDriverIdValidation());
		setTerminalIdValidation(model.getTerminalIdValidation());
		setLorryIdValidation(model.getLorryIdValidation());
		if (model.getValidationDate()!=null) {
			setValidationDate(DateUtils.sqlDateToString(model.getValidationDate()));
		}
		setValidationCheckedById(model.getValidationCheckedById());
		setRemarksId(model.getRemarksId());
		//setRootCause(model.getRootCause());
		setRootCauseId(model.getRootCauseId());
		setClosureId(model.getClosureId());
	}
	
	public VerificationAndValidation populateModel (VerificationAndValidationFormBean formbean) throws Exception {
		VerificationAndValidation model = new VerificationAndValidation();
		model.setId(formbean.getId());
		model.setItemId(formbean.getItemId());
		model.setFindingsId(formbean.getFindingsId());
		model.setDriverId(formbean.getDriverId());
		model.setTerminalId(formbean.getTerminalId());
		model.setLorryId(formbean.getLorryId());
		if (formbean.getVerificationDate()!=null && formbean.getVerificationDate().trim().length() > 0) {
			model.setVerificationDate(DateUtils.strToSQLDate(formbean.getVerificationDate()));	
		}
		model.setCorrectionsId(formbean.getCorrectionsId());
		model.setVerificationCheckedById(formbean.getVerificationCheckedById());
		model.setFollowUpId(formbean.getFollowUpId());
		model.setDriverIdValidation(formbean.getDriverIdValidation());
		model.setTerminalIdValidation(formbean.getTerminalIdValidation());
		model.setLorryIdValidation(formbean.getLorryIdValidation());
		if (formbean.getValidationDate()!=null && formbean.getValidationDate().trim().length() > 0) {
			model.setValidationDate(DateUtils.strToSQLDate(formbean.getValidationDate()));
		}
		model.setValidationCheckedById(formbean.getValidationCheckedById());
		model.setRemarksId(formbean.getRemarksId());
		//model.setRootCause(formbean.getRootCause());
		model.setRootCauseId(formbean.getRootCauseId());
		model.setClosureId(formbean.getClosureId());
		return model;
	}
	
	public void populateDropdownList(HttpServletRequest request, VerificationAndValidationFormBean formBean) throws Exception{
		//get the items list
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.ITEMS);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Items> qryList =  (ArrayList<Items>) resultMap.get(MapConstant.CLASS_LIST);		        		
			formBean.setItemList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_ITEM_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_ITEM_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_ITEM_LIST, qryList);
        }
		
        dataMap = null;
        service = null;
        resultMap = null;
        
		//get the driver list
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.EMPLOYEE);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Employee> qryList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	//customize here get the drivers only
			List<HashMap<String, String>> customList =  new ArrayList<HashMap<String, String>>();
			
			for (int i=0;i<=qryList.size()-1;i++) {
				Employee emp = (Employee) qryList.get(i);
				if (emp.getEmpCategory().equalsIgnoreCase(MiscConstant.LOV_EMPCATEGORY_DRIVER)) {
					HashMap<String, String> empMap = new HashMap<String, String>();
					empMap.put("empId", String.valueOf(emp.getId()));
					empMap.put("name", emp.getLastName()+", "+emp.getFirstName()+" "+emp.getMiddleName());
					customList.add(empMap);
				}
			}
			
			formBean.setDriverList(customList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_DRIVER_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_DRIVER_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_DRIVER_LIST, customList);
        }
        
        dataMap = null;
        service = null;
        resultMap = null;
        
		//get the lorry list
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.LORRY);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Lorry> qryList =  (ArrayList<Lorry>) resultMap.get(MapConstant.CLASS_LIST);		        		
			formBean.setLorryList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_LORRY_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_LORRY_LIST, qryList);
        }
		
        dataMap = null;
        service = null;
        resultMap = null;

		//get the corrective actions list
//		dataMap = new HashMap<String, Object>();
//		dataMap.put(MapConstant.MODULE, ModuleConstant.CORRECTIONS);
//		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
//        service = new ServiceManagerImpl();
//        resultMap = service.executeRequest(dataMap);
//        
//        if (resultMap!=null && !resultMap.isEmpty()) {
//			@SuppressWarnings("unchecked")
//			List<Corrections> qryList =  (ArrayList<Corrections>) resultMap.get(MapConstant.CLASS_LIST);		        		
//			formBean.setCorrectionsList(qryList);
//        	if (request.getSession().getAttribute(MiscConstant.TRANS_CORRECTIONS_LIST)!=null) {
//        		request.getSession().removeAttribute(MiscConstant.TRANS_CORRECTIONS_LIST);
//        	}
//        	//save to session
//        	request.getSession().setAttribute(MiscConstant.TRANS_CORRECTIONS_LIST, qryList);
//        }
//		
//        dataMap = null;
//        service = null;
//        resultMap = null; 
        
        //initial load empty list for Corrective Actions
        List<Corrections> emptyListCorrections = new ArrayList<Corrections>();//need to save emptyList not null
    	formBean.setCorrectionsList(emptyListCorrections);
        //save to session
        request.getSession().setAttribute(MiscConstant.TRANS_CORRECTIONS_LIST, emptyListCorrections);
        
        
		//get the checked by list
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.EMPLOYEE);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Employee> qryList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	//customize here 
			List<HashMap<String, String>> customList =  new ArrayList<HashMap<String, String>>();
			
			for (int i=0;i<=qryList.size()-1;i++) {
				Employee emp = (Employee) qryList.get(i);
				if (!emp.getEmpCategory().equalsIgnoreCase(MiscConstant.LOV_EMPCATEGORY_DRIVER)) {
					HashMap<String, String> empMap = new HashMap<String, String>();
					empMap.put("empId", String.valueOf(emp.getId()));
					empMap.put("name", emp.getLastName()+", "+emp.getFirstName()+" "+emp.getMiddleName());
					customList.add(empMap);
				}
			}
			
			formBean.setCheckedByList(customList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_CHECKEDBY_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_CHECKEDBY_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_CHECKEDBY_LIST, customList);
        }
        
        dataMap = null;
        service = null;
        resultMap = null;
        
    	//get the followup list
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.FOLLOW_UP);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<FollowUp> qryList =  (ArrayList<FollowUp>) resultMap.get(MapConstant.CLASS_LIST);		        		
			formBean.setFollowUpList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_FOLLOWUP_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_FOLLOWUP_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_FOLLOWUP_LIST, qryList);
        }
		
        dataMap = null;
        service = null;
        resultMap = null;
        
    	//get the remarks list
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.REMARKS);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Remarks> qryList =  (ArrayList<Remarks>) resultMap.get(MapConstant.CLASS_LIST);		        		
			formBean.setRemarksList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_REMARKS_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_REMARKS_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_REMARKS_LIST, qryList);
        }
		
        dataMap = null;
        service = null;
        resultMap = null;       
   
    	//get the terminal list
		dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.TERMINAL);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Terminal> qryList =  (ArrayList<Terminal>) resultMap.get(MapConstant.CLASS_LIST);		        		
			formBean.setTerminalList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_TERMINAL_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_TERMINAL_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_TERMINAL_LIST, qryList);
        }
		
        dataMap = null;
        service = null;
        resultMap = null;
        
       	//get the findings list
//    	dataMap = new HashMap<String, Object>();
//    	dataMap.put(MapConstant.MODULE, ModuleConstant.FINDINGS);
//    	dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
//        service = new ServiceManagerImpl();
//        resultMap = service.executeRequest(dataMap);
//            
//        if (resultMap!=null && !resultMap.isEmpty()) {
//        	@SuppressWarnings("unchecked")
//    		List<Findings> qryList =  (ArrayList<Findings>) resultMap.get(MapConstant.CLASS_LIST);		        		
//    		formBean.setFindingsList(qryList);
//            if (request.getSession().getAttribute(MiscConstant.TRANS_FINDINGS_LIST)!=null) {
//            	request.getSession().removeAttribute(MiscConstant.TRANS_FINDINGS_LIST);
//            }
//            //save to session
//            request.getSession().setAttribute(MiscConstant.TRANS_FINDINGS_LIST, qryList);
//        }
//    		
//        dataMap = null;
//        service = null;
//        resultMap = null;
        
        //initial load no list for Findings
    	List<Findings> emptyListFindings = new ArrayList<Findings>();//need to save emptyList not null
    	formBean.setFindingsList(emptyListFindings);
        //save to session
        request.getSession().setAttribute(MiscConstant.TRANS_FINDINGS_LIST, emptyListFindings);
 
       	//get the root cause list
    	dataMap = new HashMap<String, Object>();
    	dataMap.put(MapConstant.MODULE, ModuleConstant.ROOT_CAUSE);
    	dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
            
        if (resultMap!=null && !resultMap.isEmpty()) {
        	@SuppressWarnings("unchecked")
    		List<RootCause> qryList =  (ArrayList<RootCause>) resultMap.get(MapConstant.CLASS_LIST);		        		
    		formBean.setRootCauseList(qryList);
            if (request.getSession().getAttribute(MiscConstant.TRANS_ROOT_CAUSE_LIST)!=null) {
            	request.getSession().removeAttribute(MiscConstant.TRANS_ROOT_CAUSE_LIST);
            }
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_ROOT_CAUSE_LIST, qryList);
        }
    		
        dataMap = null;
        service = null;
        resultMap = null;
        
       	//get the closure list        
//    	dataMap = new HashMap<String, Object>();
//    	dataMap.put(MapConstant.MODULE, ModuleConstant.CLOSURE);
//    	dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
//        service = new ServiceManagerImpl();
//        resultMap = service.executeRequest(dataMap);
//            
//        if (resultMap!=null && !resultMap.isEmpty()) {
//        	@SuppressWarnings("unchecked")
//    		List<Closure> qryList =  (ArrayList<Closure>) resultMap.get(MapConstant.CLASS_LIST);		        		
//    		formBean.setClosureList(qryList);
//            if (request.getSession().getAttribute(MiscConstant.TRANS_CLOSURE_LIST)!=null) {
//            	request.getSession().removeAttribute(MiscConstant.TRANS_CLOSURE_LIST);
//            }
//            //save to session
//            request.getSession().setAttribute(MiscConstant.TRANS_CLOSURE_LIST, qryList);
//        }
//    		
//        dataMap = null;
//        service = null;
//        resultMap = null;
        
        // initial load no list for closure
    	List<Closure> emptyListClosure = new ArrayList<Closure>();//need to save emptyList not null
    	formBean.setClosureList(emptyListClosure);
        //save to session
        request.getSession().setAttribute(MiscConstant.TRANS_CLOSURE_LIST, emptyListClosure);
        
        
	}
	
	@SuppressWarnings("unchecked")
	public void populateDropdownListFromSession(HttpServletRequest request, VerificationAndValidationFormBean formBean) throws Exception{
		//Items and Findings
		List<Items> itemList = (ArrayList<Items>)request.getSession().getAttribute(MiscConstant.TRANS_ITEM_LIST);
    	if (itemList!=null) {
    		formBean.setItemList(itemList);
    	} 
    	//Driver List
    	List<HashMap<String, String>> driverList = (ArrayList<HashMap<String, String>>)request.getSession().getAttribute(MiscConstant.TRANS_DRIVER_LIST);
    	if (driverList!=null) {
    		formBean.setDriverList(driverList);
    	} 
		//Lorry
		List<Lorry> lorryList = (ArrayList<Lorry>)request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST);
    	if (lorryList!=null) {
    		formBean.setLorryList(lorryList);
    	} 
    	
		//Corrective Actions
		List<Corrections> correctionsList = (ArrayList<Corrections>)request.getSession().getAttribute(MiscConstant.TRANS_CORRECTIONS_LIST);
    	if (correctionsList!=null) {
    		formBean.setCorrectionsList(correctionsList);
    	} 
    	//CheckedBy List
    	List<HashMap<String, String>> checedByList = (ArrayList<HashMap<String, String>>)request.getSession().getAttribute(MiscConstant.TRANS_CHECKEDBY_LIST);
    	if (checedByList!=null) {
    		formBean.setCheckedByList(checedByList);
    	} 
		//Follow Up
		List<FollowUp> followUpList = (ArrayList<FollowUp>)request.getSession().getAttribute(MiscConstant.TRANS_FOLLOWUP_LIST);
    	if (followUpList!=null) {
    		formBean.setFollowUpList(followUpList);
    	} 
		//Remarks
		List<Remarks> remarksList = (ArrayList<Remarks>)request.getSession().getAttribute(MiscConstant.TRANS_REMARKS_LIST);
    	if (remarksList!=null) {
    		formBean.setRemarksList(remarksList);
    	} 
		//Terminal
		List<Terminal> terminalList = (ArrayList<Terminal>)request.getSession().getAttribute(MiscConstant.TRANS_TERMINAL_LIST);
    	if (terminalList!=null) {
    		formBean.setTerminalList(terminalList);
    	} 
		//Findings
		List<Findings> findingsList = (ArrayList<Findings>)request.getSession().getAttribute(MiscConstant.TRANS_FINDINGS_LIST);
    	if (findingsList!=null) {
    		formBean.setFindingsList(findingsList);
    	}
    	//RootCause
		List<RootCause> rootCauseList = (ArrayList<RootCause>)request.getSession().getAttribute(MiscConstant.TRANS_ROOT_CAUSE_LIST);
    	if (rootCauseList!=null) {
    		formBean.setRootCauseList(rootCauseList);
    	}
    	//Closure
		List<Closure> closureList = (ArrayList<Closure>)request.getSession().getAttribute(MiscConstant.TRANS_CLOSURE_LIST);
    	if (closureList!=null) {
    		formBean.setClosureList(closureList);
    	}
	}
	
	public void populateVerificationCriteriaDropdownList(HttpServletRequest request, VerificationAndValidationFormBean formBean) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_VERIFICATION_CRITERIA_SESSION);
    	if (lovList!=null) {
    		formBean.setVerificationCriteriaLOV(lovList);
    	}
	}
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		boolean flag = false;
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getItemId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.item.req"));
				flag = true;
			}
			if (this.getFindingsId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.findings.req"));
				flag = true;
			}
			if (this.getDriverId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.driver.req"));
				flag = true;
			}
			if (this.getTerminalId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.terminal.req"));
				flag = true;
			}
			if (this.getLorryId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.lorryno.req"));
				flag = true;
			}
			if (flag) {
				try {
					populateDropdownListFromSession(request, this);
				} catch(Exception e) {}					
			}
	
		} 
		

	
		return errors;
	}		
	
	//Transport Revision 1 Dec2015
	public void populateFindingsByItem(HttpServletRequest request, VerificationAndValidationFormBean formBean) throws Exception{
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put(MapConstant.MODULE, ModuleConstant.FINDINGS);
    	dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
    	dataMap.put(MapConstant.SUB_ACTION, SubActionConstant.GET_FINDINGS_BY_ITEM);
    	String itemIdStr = request.getParameter("itemId");
    	if (itemIdStr != null) {
    		dataMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, Integer.parseInt(itemIdStr));	
    	} else {
    		//if Edit, get from formBean
    		dataMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, formBean.getItemId());	
    	}
    	ServiceManagerImpl service = new ServiceManagerImpl();
    	Map<String, Object> resultMap = service.executeRequest(dataMap);
            
        if (resultMap!=null && !resultMap.isEmpty()) {
        	@SuppressWarnings("unchecked")
    		List<Findings> qryList =  (ArrayList<Findings>) resultMap.get(MapConstant.CLASS_LIST);		        		
    		
        	//need to filter per type and add label
        	//customize here
			List<Findings> qryListWithLabels =  new ArrayList<Findings>();
			List<Findings> qryListPositive =  new ArrayList<Findings>();
			List<Findings> qryListNegative =  new ArrayList<Findings>();
			
            if (request.getSession().getAttribute(MiscConstant.TRANS_FINDINGS_POSITIVE_LIST)!=null) {
            	request.getSession().removeAttribute(MiscConstant.TRANS_FINDINGS_POSITIVE_LIST);
            }
            if (request.getSession().getAttribute(MiscConstant.TRANS_FINDINGS_NEGATIVE_LIST)!=null) {
            	request.getSession().removeAttribute(MiscConstant.TRANS_FINDINGS_NEGATIVE_LIST);
            }
			
			//add label for Positive Findings
			Findings positiveLabel = new Findings();
			positiveLabel.setId(0);
			positiveLabel.setDescription("---Positive Findings---");
			qryListWithLabels.add(positiveLabel);
			
			for (int i=0;i<=qryList.size()-1;i++) {
				Findings dto = (Findings) qryList.get(i);
				if (dto.getTypeId() == MiscConstant.LOV_FINDINGS_TYPE_POSITIVE) {
					qryListWithLabels.add(dto);
					qryListPositive.add(dto);
				}
			}
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_FINDINGS_POSITIVE_LIST, qryListPositive);
			
			//add label for Negative Findings
			Findings negativeLabel = new Findings();
			negativeLabel.setId(0);
			negativeLabel.setDescription("---Negative Findings---");
			qryListWithLabels.add(negativeLabel);
			
			for (int i=0;i<=qryList.size()-1;i++) {
				Findings dto = (Findings) qryList.get(i);
				if (dto.getTypeId() == MiscConstant.LOV_FINDINGS_TYPE_NEGATIVE) {
					qryListWithLabels.add(dto);		
					qryListNegative.add(dto);
				}
			}
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_FINDINGS_NEGATIVE_LIST, qryListNegative);
	
        	formBean.setFindingsList(qryListWithLabels);
    		    		
            if (request.getSession().getAttribute(MiscConstant.TRANS_FINDINGS_LIST)!=null) {
            	request.getSession().removeAttribute(MiscConstant.TRANS_FINDINGS_LIST);
            }
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_FINDINGS_LIST, qryList);
        } else {
        	List<Findings> emptyList = new ArrayList<Findings>();//need to save emptyList not null
        	formBean.setFindingsList(emptyList);
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_FINDINGS_LIST, emptyList);
        }
    		
        dataMap = null;
        service = null;
        resultMap = null;

	}

	//Transport Revision 1 Dec2015
	public void populateClosureByCorrections(HttpServletRequest request, VerificationAndValidationFormBean formBean) throws Exception{
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put(MapConstant.MODULE, ModuleConstant.CLOSURE);
    	dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
    	dataMap.put(MapConstant.SUB_ACTION, SubActionConstant.GET_CLOSURE_BY_CORRECTIONS);
    	String itemIdStr = request.getParameter("correctionsId");
    	if (itemIdStr != null) {
    		dataMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, Integer.parseInt(itemIdStr));	
    	} else {
    		//if Edit, get from formBean
    		dataMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, formBean.getCorrectionsId());	
    	}
    	ServiceManagerImpl service = new ServiceManagerImpl();
    	Map<String, Object> resultMap = service.executeRequest(dataMap);
            
        if (resultMap!=null && !resultMap.isEmpty()) {
        	@SuppressWarnings("unchecked")
    		List<Closure> qryList =  (ArrayList<Closure>) resultMap.get(MapConstant.CLASS_LIST);		        		
    		
        	formBean.setClosureList(qryList);
    		    		
            if (request.getSession().getAttribute(MiscConstant.TRANS_CLOSURE_LIST)!=null) {
            	request.getSession().removeAttribute(MiscConstant.TRANS_CLOSURE_LIST);
            }
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_CLOSURE_LIST, qryList);
        } else {
        	List<Closure> emptyList = new ArrayList<Closure>();//need to save emptyList not null
        	formBean.setClosureList(emptyList);
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_CLOSURE_LIST, emptyList);
        }
    		
        dataMap = null;
        service = null;
        resultMap = null;

	}
	//Transport Revision 1 Dec2015
	public void populateCorrectionsByRootCause(HttpServletRequest request, VerificationAndValidationFormBean formBean) throws Exception{
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put(MapConstant.MODULE, ModuleConstant.CORRECTIONS);
    	dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
    	dataMap.put(MapConstant.SUB_ACTION, SubActionConstant.GET_CORRECTIONS_BY_ROOT_CAUSE);
    	String itemIdStr = request.getParameter("rootCauseId");
    	if (itemIdStr != null) {
    		dataMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, Integer.parseInt(itemIdStr));	
    	} else {
    		//if Edit, get from formBean
    		dataMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, formBean.getRootCauseId());	
    	}
    	ServiceManagerImpl service = new ServiceManagerImpl();
    	Map<String, Object> resultMap = service.executeRequest(dataMap);
            
        if (resultMap!=null && !resultMap.isEmpty()) {
        	@SuppressWarnings("unchecked")
    		List<Corrections> qryList =  (ArrayList<Corrections>) resultMap.get(MapConstant.CLASS_LIST);		        		
    		
        	formBean.setCorrectionsList(qryList);
    		    		
            if (request.getSession().getAttribute(MiscConstant.TRANS_CORRECTIONS_LIST)!=null) {
            	request.getSession().removeAttribute(MiscConstant.TRANS_CORRECTIONS_LIST);
            }
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_CORRECTIONS_LIST, qryList);
        } else {
        	List<Corrections> emptyList = new ArrayList<Corrections>();//need to save emptyList not null
        	formBean.setCorrectionsList(emptyList);
            //save to session
            request.getSession().setAttribute(MiscConstant.TRANS_CORRECTIONS_LIST, emptyList);
        }
    		
        dataMap = null;
        service = null;
        resultMap = null;

	}	
	
	public boolean isPositiveFindings(HttpServletRequest request, VerificationAndValidationFormBean formBean) throws Exception{

		boolean isPositive = false;
		//get the list from sessions
		@SuppressWarnings("unchecked")
		List<Findings> positiveList = (ArrayList<Findings>) request.getSession().getAttribute(MiscConstant.TRANS_FINDINGS_POSITIVE_LIST);
		
		String entityIdStr = request.getParameter("findingsId");
		int entityId = 0;
		
    	if (entityIdStr != null) {
    		entityId = Integer.parseInt(entityIdStr);
    	} else {
    		//if Edit, get from formBean
    		entityId = formBean.getFindingsId();
    	}
    	
		for (int i=0;i<=positiveList.size()-1;i++) {
			Findings dto = (Findings) positiveList.get(i);
			if (dto.getId() == entityId) {
				isPositive = true;
			}
		}
		
		return isPositive;
	}
	
	//Transport Revision 1 Dec2015
	public void populateReminders(HttpServletRequest request, VerificationAndValidationFormBean formBean, int page, int offset) throws Exception{
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
	    dataMap.put(MapConstant.MODULE, ModuleConstant.VERIFICATION_AND_VALIDATION);
	    dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
	    dataMap.put(MapConstant.SUB_ACTION, SubActionConstant.GET_REMINDERS);
	    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
	    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);
	    	
	    ServiceManagerImpl service = new ServiceManagerImpl();
	    Map<String, Object> resultMap = service.executeRequest(dataMap);
	            
	    if (resultMap!=null && !resultMap.isEmpty()) {
	       @SuppressWarnings("unchecked")
	       List<VerificationAndValidation> qryList =  (ArrayList<VerificationAndValidation>) resultMap.get(MapConstant.CLASS_LIST);		        		
	       formBean.setModelList(qryList);
	       
	       int totalNoOfRecords = (int) resultMap.get(MapConstant.PAGINATION_TOTALRECORDS);
	       int noOfPages = (int) Math.ceil(totalNoOfRecords * 1.0 / MiscConstant.RECORDS_PER_PAGE);
			
	       formBean.setNoOfPages(noOfPages);
	       formBean.setCurrentPage(page);
        
	    } else {
	    	formBean.setModelList(null);
	        formBean.setNoOfPages(0);
	        formBean.setCurrentPage(0);
	    }
	    		
	    dataMap = null;
	    service = null;
	    resultMap = null;
	}	
	
}
