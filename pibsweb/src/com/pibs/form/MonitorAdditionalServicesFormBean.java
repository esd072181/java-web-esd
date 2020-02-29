package com.pibs.form;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.AdditionalServices;
import com.pibs.model.MonitorAdditionalServices;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.DateUtils;

public class MonitorAdditionalServicesFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private int patientCaseSystemId;
	private int additionalServicesId;
	private int qty;
	private String fee;
	private String amount;
	private String dateTaken;
	private String timeTaken;
	
	//surgery fields
	private String itemType;
	private String itemDescription;

	
	private List<AdditionalServices> modelList;
	private List<MonitorAdditionalServices> entityList;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public MonitorAdditionalServicesFormBean() {}




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
	

	public int getPatientCaseSystemId() {
		return patientCaseSystemId;
	}

	public void setPatientCaseSystemId(int patientCaseSystemId) {
		this.patientCaseSystemId = patientCaseSystemId;
	}








	public String getDateTaken() {
		return dateTaken;
	}




	public void setDateTaken(String dateTaken) {
		this.dateTaken = dateTaken;
	}






	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getQty() {
		return qty;
	}




	public void setQty(int qty) {
		this.qty = qty;
	}





	public String getAmount() {
		return amount;
	}




	public void setAmount(String amount) {
		this.amount = amount;
	}




	public String getTimeTaken() {
		return timeTaken;
	}




	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}








	public String getItemType() {
		return itemType;
	}




	public void setItemType(String itemType) {
		this.itemType = itemType;
	}




	public String getItemDescription() {
		return itemDescription;
	}




	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}





	public List<AdditionalServices> getModelList() {
		return modelList;
	}




	public void setModelList(List<AdditionalServices> modelList) {
		this.modelList = modelList;
	}




	public List<MonitorAdditionalServices> getEntityList() {
		return entityList;
	}




	public void setEntityList(List<MonitorAdditionalServices> entityList) {
		this.entityList = entityList;
	}
	
	






	public int getAdditionalServicesId() {
		return additionalServicesId;
	}




	public void setAdditionalServicesId(int additionalServicesId) {
		this.additionalServicesId = additionalServicesId;
	}




	public String getFee() {
		return fee;
	}




	public void setFee(String fee) {
		this.fee = fee;
	}




	public void populateFormBean(MonitorAdditionalServices model) throws Exception {
		setId(model.getId());
		setPatientCaseSystemId(model.getPatientCaseSystemId());
		setQty(model.getQty());
		setFee(model.getFee()!=null ? model.getFee().toPlainString() : "0.00");
		setAdditionalServicesId(model.getAdditionalServicesId());
		if (model.getDateTaken()!=null) {
			setDateTaken(DateUtils.sqlDateToString(model.getDateTaken()));
		}
		setTimeTaken(model.getTimeTaken());
		setItemType(model.getItemType());
		setItemDescription(model.getItemDescription());
	}
	
	public void populateEntityList(List<MonitorAdditionalServices> rsList) throws Exception {
		setEntityList(rsList);
	}
	
	public MonitorAdditionalServices populateModel (MonitorAdditionalServicesFormBean formbean) throws Exception {
		MonitorAdditionalServices model = new MonitorAdditionalServices();
		model.setId(formbean.getId());
		model.setPatientCaseSystemId(formbean.getPatientCaseSystemId());
		model.setAdditionalServicesId(formbean.getAdditionalServicesId());
		model.setQty(formbean.getQty());
		model.setFee(formbean.getFee()!=null && formbean.getFee().trim().length()>0  ? new BigDecimal(formbean.getFee()).setScale(2, BigDecimal.ROUND_HALF_UP) : new BigDecimal("0.00"));//2 decimal place
		double amount = model.getQty() * model.getFee().doubleValue();
		model.setAmount(BigDecimal.valueOf(amount));
		if (formbean.getDateTaken()!=null && formbean.getDateTaken().trim().length() > 0) {
			model.setDateTaken(DateUtils.strToSQLDate(formbean.getDateTaken()));	
		}
		model.setTimeTaken(formbean.getTimeTaken());
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			if (this.getQty() == 0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.qty.req"));
			}
		} 

		return errors;
	}


	public void getAdditionalServicesDetails(HttpServletRequest request) throws Exception {
		//fetch the surgery details
		int id = Integer.parseInt(request.getParameter("additionalServicesId"));
		
		AdditionalServices model = new AdditionalServices();
		model.setId(id);
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.ADDITIONAL_SERVICES);
        dataMap.put(MapConstant.CLASS_DATA, model);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
        
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
		
        if (resultMap!=null && !resultMap.isEmpty()) {
	        model = (AdditionalServices) resultMap.get(MapConstant.CLASS_DATA);
        	setAdditionalServicesId(model.getId());
        	setItemType(model.getAdditionalServicesCategory());
        	setItemDescription(model.getDescription());
        	setFee(model.getFee()!=null ? model.getFee().toPlainString() : "0.00");	
        }
	}	
	
}
