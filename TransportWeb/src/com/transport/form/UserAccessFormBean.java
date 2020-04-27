package com.transport.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.transport.comparator.ListValueComparator;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.constant.ParamConstant;
import com.transport.model.ListValue;
import com.transport.model.User;
import com.transport.model.UserAccess;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;

public class UserAccessFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId;
	private int accessId;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<UserAccess> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<HashMap<String, String>> userList;
	private List<ListValue> userAccessLOV;
	
	public UserAccessFormBean() {}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getAccessId() {
		return accessId;
	}


	public void setAccessId(int accessId) {
		this.accessId = accessId;
	}


	public List<HashMap<String, String>> getUserList() {
		return userList;
	}


	public void setUserList(List<HashMap<String, String>> userList) {
		this.userList = userList;
	}


	public List<ListValue> getUserAccessLOV() {
		return userAccessLOV;
	}


	public void setUserAccessLOV(List<ListValue> userAccessLOV) {
		this.userAccessLOV = userAccessLOV;
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

	public List<UserAccess> getModelList() {
		return modelList;
	}

	public void setModelList(List<UserAccess> modelList) {
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
	
	
	public void populateFormBean(UserAccess model) {
		setId(model.getId());
		setUserId(model.getUserId());
		setAccessId(model.getAccessId());
	}
	
	public UserAccess populateModel (UserAccessFormBean formbean) {
		UserAccess model = new UserAccess();
		model.setId(formbean.getId());
		model.setUserId(formbean.getUserId());
		model.setAccessId(formbean.getAccessId());
		return model;
	}
	
	public void populateDropdownList(HttpServletRequest request) throws Exception{
		//get the User list
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.USER);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<User> qryList =  (List<User>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	//customize here
			List<HashMap<String, String>> customList =  new ArrayList<HashMap<String, String>>();
			
			for (int i=0;i<=qryList.size()-1;i++) {
				User user = (User) qryList.get(i);
				HashMap<String, String> empMap = new HashMap<String, String>();
				empMap.put("id", String.valueOf(user.getId()));
				empMap.put("name", user.getName());
				customList.add(empMap);
			}
			
			setUserList(customList);
        	if (request.getSession().getAttribute(MiscConstant.MF_USER_CUSTOM_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_USER_CUSTOM_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_USER_CUSTOM_LIST, customList);
        }
        
        //get User Access from Session
        populateUserAccessDropdownList(request);
        
	}
	
	public void populateUserAccessDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_USER_ACCESS_SESSION);
        lovList.sort(new ListValueComparator());
    	if (lovList!=null) {
    		setUserAccessLOV(lovList);
    	}
	}
	
	
	public void populateDropdownListFromSession(HttpServletRequest request) throws Exception{
		@SuppressWarnings("unchecked")
		List<HashMap<String, String>> userCustomList = (ArrayList<HashMap<String, String>>) request.getSession().getAttribute(MiscConstant.MF_USER_CUSTOM_LIST);
    	if (userCustomList!=null) {
    		setUserList(userCustomList);
    		populateUserAccessDropdownList(request);//this is the fix for the issue of Failed to obtain Collection in JspException
    	} else {
    		populateDropdownList(request);
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
			if (this.getAccessId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.useraccess.req"));
				flag = true;
			}
			
			try {
				if (isAccessExistForThisUser(getUserId(),getAccessId())) {
					errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.useraccessexist.req"));
					flag = true;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (flag) {
				try {
					//get list from session
					populateDropdownListFromSession(request);		
							
				} catch(Exception e) {}				
			}

	
		} 
	
		return errors;
	}			

	private boolean isAccessExistForThisUser(int userId, int accessId) throws Exception {
		boolean ans = false;
		
		UserAccess model = new UserAccess();
		model.setUserId(userId);
		model.setAccessId(accessId);
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.USER_ACCESS);
        dataMap.put(MapConstant.CLASS_DATA, model);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
        
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
		
        if (resultMap!=null && !resultMap.isEmpty()) {
        	ans =  (Boolean) resultMap.get(MapConstant.BOOLEAN_DATA);		        		
        }
		
		return ans;
	}
	
}
