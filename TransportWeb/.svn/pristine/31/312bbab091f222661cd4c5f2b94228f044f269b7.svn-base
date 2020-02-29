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
import com.transport.model.Findings;
import com.transport.model.Items;
import com.transport.model.ListValue;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;

public class FindingsFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String description;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Findings> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private int typeId;
	private int itemId;
	
	private List<Items> itemList;
	private List<ListValue> findingsTypeLOV;
	
	public FindingsFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Findings> getModelList() {
		return modelList;
	}

	public void setModelList(List<Findings> modelList) {
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
	
	
	
	public List<ListValue> getFindingsTypeLOV() {
		return findingsTypeLOV;
	}

	public void setFindingsTypeLOV(List<ListValue> findingsTypeLOV) {
		this.findingsTypeLOV = findingsTypeLOV;
	}


	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public void populateFormBean(Findings model) {
		setId(model.getId());
		setDescription(model.getDescription());
		setItemId(model.getItemId());
		setTypeId(model.getTypeId());
	}
	
	public Findings populateModel (FindingsFormBean formbean) {
		Findings model = new Findings();
		model.setId(formbean.getId());
		model.setDescription(formbean.getDescription());
		model.setItemId(formbean.getItemId());
		model.setTypeId(formbean.getTypeId());
		return model;
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
			
			if (this.getItemId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.items.req"));
				flag = true;
			}
			
			if (this.getDescription()==null || this.getDescription().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.description.req"));
				flag = true;
			}
			
			if (this.getTypeId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.findingstype.req"));
				flag = true;
			}
			
			if (flag) {
				try {
					//get list from session
					populateDropdownListFromSession(request, this, isEdit);		
							
				} catch(Exception e) {}				
			}
		} 
	
		return errors;
	}		
	
	//Added for Revision 1 Dec2015
	public void populateFindingsTypeDropdownList(HttpServletRequest request, FindingsFormBean formBean) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_FINDINGS_TYPE_SESSION);
    	if (lovList!=null) {
    		formBean.setFindingsTypeLOV(lovList);
    	}
	}
	
	//Added for Revision 1 Dec2015
	public void populateDropdownList(HttpServletRequest request, FindingsFormBean formBean, boolean isEdit) throws Exception{
		//get the employee list
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.ITEMS);
		
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Items> qryList =  (List<Items>) resultMap.get(MapConstant.CLASS_LIST);		        		

			formBean.setItemList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_ITEMS_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_ITEMS_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_ITEMS_LIST, qryList);
        }
        
        //get Findings Type from Session
        populateFindingsTypeDropdownList(request, formBean);
        
	}
	
	//Added for Revision 1 Dec2015
	public void populateDropdownListFromSession(HttpServletRequest request, FindingsFormBean formBean, boolean isEdit) throws Exception{
		@SuppressWarnings("unchecked")
		List<Items> qryList = (List<Items>) request.getSession().getAttribute(MiscConstant.MF_ITEMS_LIST);
		if (qryList!=null) {
			formBean.setItemList(qryList);
			populateFindingsTypeDropdownList(request, formBean);
		} else {
			populateDropdownList(request, formBean, isEdit);
		}
		
	}
	
}
