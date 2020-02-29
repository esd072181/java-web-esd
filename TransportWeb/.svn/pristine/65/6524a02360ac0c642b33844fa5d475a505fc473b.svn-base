package com.transport.form;

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
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;

public class ClosureFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int correctionsId;
	private String description;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Closure> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<Corrections> correctionsList;
	
	public ClosureFormBean() {}

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

	public List<Closure> getModelList() {
		return modelList;
	}

	public void setModelList(List<Closure> modelList) {
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
	
	public int getCorrectionsId() {
		return correctionsId;
	}

	public void setCorrectionsId(int correctionsId) {
		this.correctionsId = correctionsId;
	}

	
	public List<Corrections> getCorrectionsList() {
		return correctionsList;
	}

	public void setCorrectionsList(List<Corrections> correctionsList) {
		this.correctionsList = correctionsList;
	}

	public void populateFormBean(Closure model) {
		setId(model.getId());
		setCorrectionsId(model.getCorrectionsId());
		setDescription(model.getDescription());
	}
	
	public Closure populateModel (ClosureFormBean formbean) {
		Closure model = new Closure();
		model.setId(formbean.getId());
		model.setCorrectionsId(formbean.getCorrectionsId());
		model.setDescription(formbean.getDescription());
		return model;
	}

	public void populateDropdownList(HttpServletRequest request, ClosureFormBean formBean, boolean isEdit) throws Exception{
		//get the corrective actions list
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.CORRECTIONS);
		
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		
		if (!isEdit) {
			dataMap.put(MapConstant.SUB_ACTION, SubActionConstant.GET_NO_CLOSURE_DATA);//only for Adding of New Record
		}
		

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Corrections> qryList =  (List<Corrections>) resultMap.get(MapConstant.CLASS_LIST);		        		

			formBean.setCorrectionsList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_CORRECTIONS_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_CORRECTIONS_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_CORRECTIONS_LIST, qryList);
        }
        
	}
		
	public void populateDropdownListFromSession(HttpServletRequest request, ClosureFormBean formBean, boolean isEdit) throws Exception{
		@SuppressWarnings("unchecked")
		List<Corrections> correctionsList = (List<Corrections>) request.getSession().getAttribute(MiscConstant.MF_CORRECTIONS_LIST);
    	if (correctionsList!=null) {
    		formBean.setCorrectionsList(correctionsList);
    	} else {
    		populateDropdownList(request, formBean, isEdit);
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
			
			if (this.getCorrectionsId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.corrections.req"));
				flag = true;
			}
			
			if (this.getDescription()==null || this.getDescription().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.description.req"));
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
}
