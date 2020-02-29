package com.pibs.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.MiscConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.Employee;
import com.pibs.model.ListValue;

public class EmployeeFormBean extends PIBSFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String lastName;
	private String firstName;
	private String middleName;
	private int empCategoryId;
	private int empPositionId;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Employee> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<ListValue> empCategoryLOV;
	private String empCategory;//Non Persistent
	private List<ListValue> empPositionLOV;
	
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
	
	public int getEmpPositionId() {
		return empPositionId;
	}


	public void setEmpPositionId(int empPositionId) {
		this.empPositionId = empPositionId;
	}


	public List<ListValue> getEmpPositionLOV() {
		return empPositionLOV;
	}


	public void setEmpPositionLOV(List<ListValue> empPositionLOV) {
		this.empPositionLOV = empPositionLOV;
	}

	public void populateFormBean(Employee model) {
		setId(model.getId());
		setLastName(model.getLastName());
		setFirstName(model.getFirstName());
		setMiddleName(model.getMiddleName());
		setEmpCategoryId(model.getEmpCategoryId());
		setEmpPositionId(model.getEmpPositionId());
	}
	
	public Employee populateModel (EmployeeFormBean formbean) {
		Employee model = new Employee();
		model.setId(formbean.getId());
		model.setLastName(formbean.getLastName());
		model.setFirstName(formbean.getFirstName());
		model.setMiddleName(formbean.getMiddleName());
		model.setEmpCategoryId(formbean.getEmpCategoryId());
		model.setEmpPositionId(formbean.getEmpPositionId());
		return model;
	}
	
    @SuppressWarnings("unchecked")
	public void populateDropdownList(HttpServletRequest request, EmployeeFormBean formBean) throws Exception{
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_EMPLOYEE_CATEGORY_SESSION);
    	if (lovList!=null) {
    		formBean.setEmpCategoryLOV(lovList);
    	}
		List<ListValue> lovListEmpPosition = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_EMPLOYEE_POSITION_SESSION);
    	if (lovListEmpPosition!=null) {
    		formBean.setEmpPositionLOV(lovListEmpPosition);
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
			if (this.getEmpPositionId()==0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.empposition.req"));
				flag = true;
			}
			if (flag) {
				try {
					populateDropdownList(request, this);			
				} catch(Exception e){}			
				
			}
		
		} 

		return errors;
	}	

}
