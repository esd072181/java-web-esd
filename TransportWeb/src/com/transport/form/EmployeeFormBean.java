package com.transport.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.transport.constant.MiscConstant;
import com.transport.constant.ParamConstant;
import com.transport.model.Employee;
import com.transport.model.ListValue;

public class EmployeeFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String lastName;
	private String firstName;
	private String middleName;
	private int empCategoryId;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Employee> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<ListValue> empCategoryLOV;
	private String empCategory;//Non Persistent
	
	private String permitIssuer;
	
	public EmployeeFormBean() {}


	public String getEmpCategory() {
		return empCategory;
	}


	public void setEmpCategory(String empCategory) {
		this.empCategory = empCategory;
	}

	public int getEmpCategoryId() {
		return empCategoryId;
	}



	public void setEmpCategoryId(int empCategoryId) {
		this.empCategoryId = empCategoryId;
	}



	public List<ListValue> getEmpCategoryLOV() {
		return empCategoryLOV;
	}



	public void setEmpCategoryLOV(List<ListValue> empCategoryLOV) {
		this.empCategoryLOV = empCategoryLOV;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public List<Employee> getModelList() {
		return modelList;
	}

	public void setModelList(List<Employee> modelList) {
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
	
	public String getPermitIssuer() {
		return permitIssuer;
	}

	public void setPermitIssuer(String permitIssuer) {
		this.permitIssuer = permitIssuer;
	}

	public void populateFormBean(Employee model) {
		setId(model.getId());
		setLastName(model.getLastName());
		setFirstName(model.getFirstName());
		setMiddleName(model.getMiddleName());
		setEmpCategoryId(model.getEmpCategoryId());
		setPermitIssuer(model.isPermitIssuer()==true ? "on" : null);
	}
	
	public Employee populateModel (EmployeeFormBean formbean) {
		Employee model = new Employee();
		model.setId(formbean.getId());
		model.setLastName(formbean.getLastName());
		model.setFirstName(formbean.getFirstName());
		model.setMiddleName(formbean.getMiddleName());
		model.setEmpCategoryId(formbean.getEmpCategoryId());
		model.setPermitIssuer(formbean.getPermitIssuer()!=null && formbean.getPermitIssuer().equalsIgnoreCase("on") ? true : false);
		return model;
	}
	
	public void populateEmpCategoryDropdownList(HttpServletRequest request, EmployeeFormBean formBean) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_EMPLOYEE_CATEGORY_SESSION);
    	if (lovList!=null) {
    		formBean.setEmpCategoryLOV(lovList);
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
			if (this.getLastName()==null || this.getLastName().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.lastname.req"));
				flag = true;
			}
			if (this.getFirstName()==null || this.getFirstName().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.firstname.req"));
				flag = true;
			}
			if (this.getEmpCategoryId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.empcategory.req"));
				flag = true;
			}
			
			if (flag) {
				try {
					populateEmpCategoryDropdownList(request, this);			
				} catch(Exception e){}			
				
			}
		
		} 

		return errors;
	}	

}
