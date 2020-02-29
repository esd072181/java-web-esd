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
import com.transport.model.Tire;
import com.transport.model.TireBrand;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.DateUtils;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * 
 */
public class TireFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int brandId;
	private String serialNo;
	private String recapNo;
	private String sizeAndPly;
	private String datePurchased;
	private String retired;
	private String dateRetired;
	private String bodyNo;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	private List<Tire> modelList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<TireBrand> brandList;
	
	private String brandName;
	
	public TireFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getRecapNo() {
		return recapNo;
	}

	public void setRecapNo(String recapNo) {
		this.recapNo = recapNo;
	}

	public String getSizeAndPly() {
		return sizeAndPly;
	}

	public void setSizeAndPly(String sizeAndPly) {
		this.sizeAndPly = sizeAndPly;
	}

	public String getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(String datePurchased) {
		this.datePurchased = datePurchased;
	}

	public String getDateRetired() {
		return dateRetired;
	}

	public void setDateRetired(String dateRetired) {
		this.dateRetired = dateRetired;
	}

	public String getBodyNo() {
		return bodyNo;
	}

	public void setBodyNo(String bodyNo) {
		this.bodyNo = bodyNo;
	}


	public List<TireBrand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<TireBrand> brandList) {
		this.brandList = brandList;
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

	public List<Tire> getModelList() {
		return modelList;
	}

	public void setModelList(List<Tire> modelList) {
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
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getRetired() {
		return retired;
	}

	public void setRetired(String retired) {
		this.retired = retired;
	}

	public void populateFormBean(Tire model) throws Exception {
		setId(model.getId());
		setBrandId(model.getBrandId());
		setBrandName(model.getBrandName());
		setSerialNo(model.getSerialNo());
		setRecapNo(model.getRecapNo());
		setSizeAndPly(model.getSizeAndPly());
		if (model.getDatePurchased()!=null) {
			setDatePurchased(DateUtils.sqlDateToString(model.getDatePurchased()));
		}
		setRetired(model.getRetired());
		if (model.getDateRetired()!=null) {
			setDateRetired(DateUtils.sqlDateToString(model.getDateRetired()));
		}
	}
	
	public Tire populateModel (TireFormBean formbean) throws Exception {
		Tire model = new Tire();
		model.setId(formbean.getId());
		model.setBrandId(formbean.getBrandId());
		model.setSerialNo(formbean.getSerialNo());
		model.setRecapNo(formbean.getRecapNo());
		model.setSizeAndPly(formbean.getSizeAndPly());
		if (formbean.getDatePurchased()!=null && formbean.getDatePurchased().trim().length() > 0) {
			model.setDatePurchased(DateUtils.strToSQLDate(formbean.getDatePurchased()));
		}
		model.setRetired(formbean.getRetired());
		if (formbean.getDateRetired()!=null && formbean.getDateRetired().trim().length() > 0) {
			model.setDateRetired(DateUtils.strToSQLDate(formbean.getDateRetired()));
		}
		return model;
	}

	public void populateDropdownList(HttpServletRequest request, TireFormBean formBean, boolean isEdit) throws Exception{
		//get the tire brand list
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.TIRE_BRAND);
		
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
				

        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<TireBrand> qryList =  (List<TireBrand>) resultMap.get(MapConstant.CLASS_LIST);		        		

			formBean.setBrandList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.MF_TIRE_BRAND_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.MF_TIRE_BRAND_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.MF_TIRE_BRAND_LIST, qryList);
        }
        
	}
		
	public void populateDropdownListFromSession(HttpServletRequest request, TireFormBean formBean, boolean isEdit) throws Exception{
		@SuppressWarnings("unchecked")
		List<TireBrand> brandList = (List<TireBrand>) request.getSession().getAttribute(MiscConstant.MF_TIRE_BRAND_LIST);
    	if (brandList!=null) {
    		formBean.setBrandList(brandList);
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
			
			if (this.getBrandId() == 0) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.brandname.req"));
				flag = true;
			}
			
			if (this.getSerialNo().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.serialno.req"));
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
