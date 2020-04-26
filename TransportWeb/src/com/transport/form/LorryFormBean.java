package com.transport.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.transport.constant.MiscConstant;
import com.transport.constant.ParamConstant;
import com.transport.model.ListValue;
import com.transport.model.Lorry;

public class LorryFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String lorryNo;
	private String plateNo;
	private String trailerNo;
	private String capacity;
	private String lorryCategory;
	private String transportId;
	
	private List<ListValue> transportProgramLOV;
	private List<ListValue> categoryLOV;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Lorry> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public LorryFormBean() {}


	public String getTrailerNo() {
		return trailerNo;
	}


	public void setTrailerNo(String trailerNo) {
		this.trailerNo = trailerNo;
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

	public List<Lorry> getModelList() {
		return modelList;
	}

	public void setModelList(List<Lorry> modelList) {
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

	public void populateFormBean(Lorry model) {
		setId(model.getId());
		setLorryNo(model.getLorryNo());
		setPlateNo(model.getPlateNo());
		setTrailerNo(model.getTrailerNo());
		setCapacity(String.valueOf(model.getCapacity()));
		setLorryCategory(model.getCategory());
		setTransportId(String.valueOf(model.getTransportId()));
	}
	
	public Lorry populateModel (LorryFormBean formbean) {
		Lorry model = new Lorry();
		model.setId(formbean.getId());
		model.setLorryNo(formbean.getLorryNo());
		model.setPlateNo(formbean.getPlateNo()!=null && formbean.getPlateNo().trim().length() > 0 ? formbean.getPlateNo().trim().toUpperCase() : "");
		model.setTrailerNo(formbean.getTrailerNo()!=null && formbean.getTrailerNo().trim().length() > 0 ? formbean.getTrailerNo().trim().toUpperCase() : "");
		model.setCapacity(Integer.parseInt(formbean.getCapacity()));
		model.setCategory(formbean.getLorryCategory());
		model.setTransportId(Integer.parseInt(formbean.getTransportId()));
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getLorryNo()==null || this.getLorryNo().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.lorryno.req"));
			}
		} 
	
		return errors;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public List<ListValue> getTransportProgramLOV() {
		return transportProgramLOV;
	}


	public void setTransportProgramLOV(List<ListValue> transportProgramLOV) {
		this.transportProgramLOV = transportProgramLOV;
	}


	public List<ListValue> getCategoryLOV() {
		return categoryLOV;
	}


	public void setCategoryLOV(List<ListValue> categoryLOV) {
		this.categoryLOV = categoryLOV;
	}		

	public void populateDropdownList(HttpServletRequest request, boolean isEdit) throws Exception{
        //get Transport from Session
        populateTransportProgramDropdownList(request);
        populateCategoryDropdownList(request);  
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
	public void populateCategoryDropdownList(HttpServletRequest request) throws Exception{
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_LORRY_CATEGORY_SESSION);
    	if (lovList!=null) {
    		setCategoryLOV(lovList);
    	}
	}


	public String getLorryCategory() {
		return lorryCategory;
	}


	public void setLorryCategory(String lorryCategory) {
		this.lorryCategory = lorryCategory;
	}


	public String getTransportId() {
		return transportId;
	}


	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	
}
