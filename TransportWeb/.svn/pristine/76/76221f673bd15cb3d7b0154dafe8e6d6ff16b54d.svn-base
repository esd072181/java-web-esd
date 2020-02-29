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
import com.transport.model.Corrections;
import com.transport.model.RootCause;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;


public class CorrectionsFormBean extends TransportFormBean {

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
	private List<Corrections> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private int rootCauseId;
	private List<RootCause> rootCauseList;
	
	public CorrectionsFormBean() {}

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

	public List<Corrections> getModelList() {
		return modelList;
	}

	public void setModelList(List<Corrections> modelList) {
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
	
	
	public int getRootCauseId() {
		return rootCauseId;
	}

	public void setRootCauseId(int rootCauseId) {
		this.rootCauseId = rootCauseId;
	}
	
	

	public List<RootCause> getRootCauseList() {
		return rootCauseList;
	}

	public void setRootCauseList(List<RootCause> rootCauseList) {
		this.rootCauseList = rootCauseList;
	}

	public void populateFormBean(Corrections model) {
		setId(model.getId());
		setDescription(model.getDescription());
		setRootCauseId(model.getRootCauseId());
	}
	
	public Corrections populateModel (CorrectionsFormBean formbean) {
		Corrections model = new Corrections();
		model.setId(formbean.getId());
		model.setDescription(formbean.getDescription());
		model.setRootCauseId(formbean.getRootCauseId());
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
			
			if (this.getDescription()==null || this.getDescription().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.description.req"));
				flag = true;
			}
			
			if (this.getRootCauseId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.rootcause.req"));
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
	public void populateDropdownList(HttpServletRequest request, CorrectionsFormBean formBean, boolean isEdit) throws Exception{
		//get the employee list
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.ROOT_CAUSE);
		
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<RootCause> qryList =  (List<RootCause>) resultMap.get(MapConstant.CLASS_LIST);		        		

			formBean.setRootCauseList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_ROOT_CAUSE_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_ROOT_CAUSE_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_ROOT_CAUSE_LIST, qryList);
        }
                
	}
	
	//Added for Revision 1 Dec2015
	public void populateDropdownListFromSession(HttpServletRequest request, CorrectionsFormBean formBean, boolean isEdit) throws Exception{
		@SuppressWarnings("unchecked")
		List<RootCause> qryList = (List<RootCause>) request.getSession().getAttribute(MiscConstant.MF_ROOT_CAUSE_LIST);
		if (qryList!=null) {
			formBean.setRootCauseList(qryList);
		} else {
			populateDropdownList(request, formBean, isEdit);
		}
		
	}
}
