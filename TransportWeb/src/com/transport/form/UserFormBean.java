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
import com.transport.model.Employee;
import com.transport.model.ListValue;
import com.transport.model.User;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;

public class UserFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int employeeId;
	private int roleId;
	private String name;
	private String userName;
	private String password;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<User> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<HashMap<String, String>> employeeList;
	private List<ListValue> userRoleLOV;
	
	public UserFormBean() {}

	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public List<ListValue> getUserRoleLOV() {
		return userRoleLOV;
	}



	public void setUserRoleLOV(List<ListValue> userRoleLOV) {
		this.userRoleLOV = userRoleLOV;
	}



	public List<HashMap<String, String>> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<HashMap<String, String>> employeeList) {
		this.employeeList = employeeList;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<User> getModelList() {
		return modelList;
	}

	public void setModelList(List<User> modelList) {
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
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void populateFormBean(User model) {
		setId(model.getId());
		setEmployeeId(model.getEmployeeId());
		setRoleId(model.getRoleId());
		setUserName(model.getUserName());
		setPassword(model.getPassword());
	}
	
	public User populateModel (UserFormBean formbean) {
		User model = new User();
		model.setId(formbean.getId());
		model.setEmployeeId(formbean.getEmployeeId());
		model.setRoleId(formbean.getRoleId());
		model.setUserName(formbean.getUserName());
		model.setPassword(formbean.getPassword());
		return model;
	}
	
	public void populateDropdownList(HttpServletRequest request, UserFormBean formBean, boolean isEdit) throws Exception{
		//get the employee list
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.EMPLOYEE);
		if (isEdit) {
			dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		} else {
			dataMap.put(MapConstant.ACTION, ActionConstant.GET_NO_USER_ACCOUNT_DATA);	
		}

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Employee> qryList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);		        		
        	//customize here
			List<HashMap<String, String>> customList =  new ArrayList<HashMap<String, String>>();
			
			for (int i=0;i<=qryList.size()-1;i++) {
				Employee emp = (Employee) qryList.get(i);
				HashMap<String, String> empMap = new HashMap<String, String>();
				empMap.put("empId", String.valueOf(emp.getId()));
				empMap.put("name", emp.getLastName()+", "+emp.getFirstName()+" "+emp.getMiddleName());
				customList.add(empMap);
			}
			
			formBean.setEmployeeList(customList);
        	if (request.getSession().getAttribute(MiscConstant.MF_EMPLOYEE_CUSTOM_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_EMPLOYEE_CUSTOM_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_EMPLOYEE_CUSTOM_LIST, customList);
        }
        
        //get User Role from Session
        populateUserRoleDropdownList(request, formBean);
        
	}
	
	public void populateUserRoleDropdownList(HttpServletRequest request, UserFormBean formBean) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_USER_ROLE_SESSION);
    	if (lovList!=null) {
    		formBean.setUserRoleLOV(lovList);
    	}
	}
	
	
	public void populateDropdownListFromSession(HttpServletRequest request, UserFormBean formBean, boolean isEdit) throws Exception{
		@SuppressWarnings("unchecked")
		List<HashMap<String, String>> empCustomList = (ArrayList<HashMap<String, String>>) request.getSession().getAttribute(MiscConstant.MF_EMPLOYEE_CUSTOM_LIST);
    	if (empCustomList!=null) {
    		formBean.setEmployeeList(empCustomList);
    		populateUserRoleDropdownList(request, formBean);//this is the fix for the issue of Failed to obtain Collection in JspException
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
			if (this.getEmployeeId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.empname.req"));
				flag = true;
			}
			if (this.getRoleId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.role.req"));
				flag = true;
			}
			if (this.getUserName()==null || this.getUserName().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.username.req"));
				flag = true;
			}
			if (this.getPassword()==null || this.getPassword().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.password.req"));
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
