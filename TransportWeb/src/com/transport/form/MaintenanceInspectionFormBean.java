package com.transport.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.transport.comparator.LorryComparator;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.constant.ParamConstant;
import com.transport.model.Inspection;
import com.transport.model.InspectionDetails;
import com.transport.model.InspectionHeader;
import com.transport.model.Lorry;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.DateUtils;

/**
 * 
 * @author edwarddavid
 * @since 21Mar2020
 *  DateUpdated: 25Mar2020
 */
public class MaintenanceInspectionFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Inspection Header
	private int id;
	private String lorryNo;
	private String plateNo;
	private String odometer;
	private String hubOdometer;
	private String inspectors;
	private String forAnnual;
	private String forPm;
	private String inspectionDate;
	private String remarks;
	
	//Inspection Details
	private Integer[] inspectionId;
	private Integer[] inspectionStatusId;
	private String[] inspectionRemarks;
	
	private String searchValue;
	private String category;
	
	private int noOfPages;
	private int currentPage;
	private List<Inspection> inspectionList;
	private List<InspectionHeader> modelList;
	private List<InspectionDetails> modelDetailsList;
	private List<String> mainCategoryList;
	private List<Inspection> categoryList;
	
	private List<Lorry> lorryList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public MaintenanceInspectionFormBean() {}
	
	public void populateFormBean(InspectionHeader model) throws Exception {
		setId(model.getId());
		setLorryNo(model.getLorryNo());
		setPlateNo(model.getPlateNo());
		setOdometer(model.getOdometer());
		setHubOdometer(model.getHubOdometer());
		setInspectors(model.getInspectors()!=null ? model.getInspectors().trim().toUpperCase() : null);
		setForAnnual(model.getForAnnual()!=null ? model.getForAnnual(): "NO");
		setForPm(model.getForPm()!=null ? model.getForPm(): "NO");
		if (model.getInspectionDate()!=null) {
			setInspectionDate(DateUtils.sqlDateToString(model.getInspectionDate()));	
		}
		setRemarks(model.getRemarks()!=null ? model.getRemarks().trim().toUpperCase() : null);
	}
	
	
	
	public void populateDetailsFormBean(List<InspectionDetails> detailsList) throws Exception {
		this.setModelDetailsList(detailsList);
	}

	public InspectionHeader populateInspectionHeader() throws Exception {
		InspectionHeader model = new InspectionHeader();
		model.setId(getId());
		model.setLorryNo(getLorryNo());
		model.setPlateNo(getPlateNo());
		model.setOdometer(getOdometer());
		model.setHubOdometer(getHubOdometer());
		model.setInspectors(getInspectors()!=null && getInspectors().trim().length()>0 ? getInspectors().trim().toUpperCase() : null);
		model.setForAnnual(getForAnnual()!=null ? getForAnnual(): "NO");
		model.setForPm(getForPm()!=null ? getForPm() : "NO");
		if (getInspectionDate()!=null && getInspectionDate().trim().length()>1) {
			model.setInspectionDate(DateUtils.strToSQLDate(getInspectionDate()));	
		}
		model.setRemarks(getRemarks()!=null ? getRemarks().trim().toUpperCase() : null);		
		return model;
	}
	
	public void populateInspectionDetailsList(Integer[] arrId, Integer[] arrStatusId, String[] arrRemarks, Boolean isUpdate) {
	
		List<InspectionDetails> dtolist = new ArrayList<>();
		
		for(int i=0;i<arrId.length;i++) {
			InspectionDetails dto = new InspectionDetails();
			if (isUpdate) {
				dto.setId(arrId[i]);
			} else {
				dto.setInspectionId(arrId[i]);
			}
			dto.setStatusId(getInspectionStatus(arrId[i],arrStatusId));
			dto.setRemarks(getInspectionRemarks(arrId[i],arrRemarks));
			dtolist.add(dto);
		}
				
		this.setModelDetailsList(dtolist);
	}
		
	private Integer getInspectionStatus(Integer itemId, Integer[] arrStatusId) {
		int statusId = 0;
		for (int i=0;i<arrStatusId.length;i++) {
			if (arrStatusId[i].intValue() == itemId && (i+1 < arrStatusId.length)  && arrStatusId[i+1].intValue() > 1600) {
				statusId = arrStatusId[i+1].intValue();
				break;
			}
		}
		return statusId;
	}
	
	private String getInspectionRemarks(Integer itemId, String[] arrRemarks) {
		String remarks = null;
		for (int i=0;i<arrRemarks.length;i++) {
			if (arrRemarks[i]!=null && !arrRemarks[i].equals("") && StringUtils.isNumeric(arrRemarks[i])) {
				if (Integer.parseInt(arrRemarks[i]) == itemId && (i+1 < arrRemarks.length)) {
					remarks = arrRemarks[i+1];
					break;
				}
			}
		}
		return remarks;
	}
	
	
	public void populateDropdownList(HttpServletRequest request, boolean isEdit) throws Exception{
		populateLorryList(request); 
	}

	@SuppressWarnings("unchecked")
	public void populateDropdownListFromSession(HttpServletRequest request, boolean isEdit) throws Exception{
		if (request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST)!=null) {
			setLorryList((List<Lorry>)request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST));
		}
		if (request.getSession().getAttribute(MiscConstant.TRANS_INSPECTION_LIST)!=null) {
			setInspectionList((List<Inspection>)request.getSession().getAttribute(MiscConstant.TRANS_INSPECTION_LIST));
		}
		 populateCategoryList();
	}
	
	private void populateLorryList(HttpServletRequest request) throws Exception{        
		//get the lorry list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.LORRY);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Lorry> qryList =  (ArrayList<Lorry>) resultMap.get(MapConstant.CLASS_LIST);		        		
			qryList.sort(new LorryComparator());//filter by lorryNo
			setLorryList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_LORRY_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_LORRY_LIST, qryList);
        }        
	}
	
	public void populateInspectionList(HttpServletRequest request) throws Exception {
		//get the inspection list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.INSPECTION);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Inspection> qryList =  (ArrayList<Inspection>) resultMap.get(MapConstant.CLASS_LIST);		        		
			setInspectionList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_INSPECTION_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_INSPECTION_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_INSPECTION_LIST, qryList);
        }        
        populateCategoryList();
        
	}
	
	public void populateCategoryList() {
        //get the main category and add to category list        
        String mainCategName = null;
        int categNo = 0;
        List<String> mainCategList = new ArrayList<>();
        List<Inspection> categList = new ArrayList<>();
        if (this.getInspectionList()!=null && this.getInspectionList().size()>0) {
            for (Inspection item: this.getInspectionList()) {
            	if (!item.getMainCategoryName().equalsIgnoreCase(mainCategName)) {
            		mainCategName = item.getMainCategoryName();
            		mainCategList.add(item.getMainCategoryName());
            	}
            	if (item.getCategoryNo() != categNo) {
            		categNo = item.getCategoryNo();
            		Inspection itemModel = new Inspection();
            		itemModel.setCategoryNo(item.getCategoryNo());
            		itemModel.setCategoryName(item.getCategoryName());
            		itemModel.setMainCategoryName(item.getMainCategoryName());
            		categList.add(itemModel);
            	}
            }        	
        } else if(this.getModelDetailsList()!=null && this.getModelDetailsList().size()>0) {
        	for (InspectionDetails item: this.getModelDetailsList()) {
            	if (!item.getMainCategoryName().equalsIgnoreCase(mainCategName)) {
            		mainCategName = item.getMainCategoryName();
            		mainCategList.add(item.getMainCategoryName());
            	}
            	if (item.getCategoryNo() != categNo) {
            		categNo = item.getCategoryNo();
            		Inspection itemModel = new Inspection();
            		itemModel.setCategoryNo(item.getCategoryNo());
            		itemModel.setCategoryName(item.getCategoryName());
            		itemModel.setMainCategoryName(item.getMainCategoryName());
            		categList.add(itemModel);
            	}
            }
        }

        this.setMainCategoryList(mainCategList);
        this.setCategoryList(categList);
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
			if (this.getLorryNo()==null || this.getLorryNo().trim().length()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.lorryno.req"));
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



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLorryNo() {
		return lorryNo;
	}



	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}



	public String getPlateNo() {
		return plateNo;
	}



	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}


	public String getOdometer() {
		return odometer;
	}

	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}

	public String getHubOdometer() {
		return hubOdometer;
	}

	public void setHubOdometer(String hubOdometer) {
		this.hubOdometer = hubOdometer;
	}

	public String getInspectors() {
		return inspectors;
	}



	public void setInspectors(String inspectors) {
		this.inspectors = inspectors;
	}

	public String getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public String getSearchValue() {
		return searchValue;
	}



	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
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



	public List<InspectionHeader> getModelList() {
		return modelList;
	}



	public void setModelList(List<InspectionHeader> modelList) {
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



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public Integer[] getInspectionId() {
		return inspectionId;
	}



	public void setInspectionId(Integer[] inspectionId) {
		this.inspectionId = inspectionId;
	}



	public Integer[] getInspectionStatusId() {
		return inspectionStatusId;
	}



	public void setInspectionStatusId(Integer[] inspectionStatusId) {
		this.inspectionStatusId = inspectionStatusId;
	}



	public String[] getInspectionRemarks() {
		return inspectionRemarks;
	}



	public void setInspectionRemarks(String[] inspectionRemarks) {
		this.inspectionRemarks = inspectionRemarks;
	}

	public List<Lorry> getLorryList() {
		return lorryList;
	}

	public void setLorryList(List<Lorry> lorryList) {
		this.lorryList = lorryList;
	}

	public List<Inspection> getInspectionList() {
		return inspectionList;
	}

	public void setInspectionList(List<Inspection> inspectionList) {
		this.inspectionList = inspectionList;
	}

	public List<InspectionDetails> getModelDetailsList() {
		return modelDetailsList;
	}

	public void setModelDetailsList(List<InspectionDetails> modelDetailsList) {
		this.modelDetailsList = modelDetailsList;
	}

	public List<String> getMainCategoryList() {
		return mainCategoryList;
	}

	public void setMainCategoryList(List<String> mainCategoryList) {
		this.mainCategoryList = mainCategoryList;
	}

	public List<Inspection> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Inspection> categoryList) {
		this.categoryList = categoryList;
	}

	public String getForAnnual() {
		return forAnnual;
	}

	public void setForAnnual(String forAnnual) {
		this.forAnnual = forAnnual;
	}

	public String getForPm() {
		return forPm;
	}

	public void setForPm(String forPm) {
		this.forPm = forPm;
	}





	
	
}
