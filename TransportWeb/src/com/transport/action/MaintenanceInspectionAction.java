package com.transport.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.constant.ParamConstant;
import com.transport.form.MaintenanceInspectionFormBean;
import com.transport.model.InspectionDetails;
import com.transport.model.InspectionHeader;
import com.transport.model.User;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 21Mar2020
 * DateUpdated: 22Mar2020
 */
public class MaintenanceInspectionAction extends Action {

	private final static Logger logger = Logger.getLogger(MaintenanceInspectionAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MaintenanceInspectionFormBean formBean = (MaintenanceInspectionFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");
		
		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.MAINTENANCE_INSPECTION;
				
				if (command.equalsIgnoreCase(ParamConstant.ADD)) {
					
					//get fresh/updated list data from DB for click ADD and EDIT link
					formBean.populateDropdownList(request, false);
					formBean.populateInspectionList(request);

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_ADD;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_EDIT)) {
					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					InspectionHeader model = new InspectionHeader();
					model.setId(id);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        model =  (InspectionHeader) resultMap.get(MapConstant.CLASS_DATA);		        		
			        	formBean.populateFormBean(model);
			        	@SuppressWarnings("unchecked")
						List<InspectionDetails> detailsList = (List<InspectionDetails> )resultMap.get(MapConstant.CLASS_LIST);	
			        	formBean.populateDetailsFormBean(detailsList);
			        	formBean.populateCategoryList();
			        }
			        
			        //get fresh/updated list data from DB for click ADD and EDIT link
			        formBean.populateDropdownList(request, true);
			        
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_EDIT;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)) {
				
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
										
					InspectionHeader model = formBean.populateInspectionHeader();
					
					if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE)) {
						formBean.populateInspectionDetailsList(formBean.getInspectionId(),formBean.getInspectionStatusId(),formBean.getInspectionRemarks(), Boolean.FALSE);
					} else {
						formBean.populateInspectionDetailsList(formBean.getInspectionId(),formBean.getInspectionStatusId(),formBean.getInspectionRemarks(), Boolean.TRUE);
					}
										
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model); //Header
			        dataMap.put(MapConstant.CLASS_LIST, formBean.getModelDetailsList()); //Details
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        
			        if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE)) {
				        dataMap.put(MapConstant.ACTION, ActionConstant.SAVE); 
			        } else {
			        	dataMap.put(MapConstant.ACTION, ActionConstant.UPDATE);
			        }
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	
					    @SuppressWarnings("unchecked")
						List<InspectionDetails> detailsList = (List<InspectionDetails>)resultMap.get(MapConstant.CLASS_LIST);	
					    formBean.populateDetailsFormBean(detailsList);
			       
			        	//check resultmap action status
			        	boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);
	
			        	formBean.setTransactionStatus(tranctionStatus);
			        	
			        	//get the dropdown list from session
			        	boolean isEdit = (command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)? true: false);
			        	formBean.populateDropdownListFromSession(request, isEdit);  
			        	
			        	
			        	if (tranctionStatus) {
			        		//show success page and add confirmation message		        		
			        		if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE)) {
			        			formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_SAVED);
			        			TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_SAVED+" - "+module);
			        		}else {
			        			formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        			TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_UPDATED+" - "+module);;
			        		}
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_ERROR+" - "+module);
			        		forwardAction = ActionConstant.AJAX_FAILED;
			        	}
			        }
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_DELETE)) {
					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					InspectionHeader model = new InspectionHeader();
					model.setId(id);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.DELETE);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);
	
			        	formBean.setTransactionStatus(tranctionStatus);
			        	
//			        	formBean.populateCriteriaDropdownList(request);
			        	
			        	if (tranctionStatus) {
			        		//show success page
			        		//add confirmation message
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_DELETED);
	
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_DELETED);
			        		TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_DELETED+" - "+module);
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_ERROR+" - "+module);
			        		forwardAction = ActionConstant.AJAX_FAILED;
			        	}
			        }
	
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {
					//get all the records from DB
									
					 int page = 1;
				     if(request.getParameter("page") != null) {
				         page = Integer.parseInt(request.getParameter("page")); 
				     }
				     
				    int offset = (page-1) * MiscConstant.RECORDS_PER_PAGE; 
				    
					String category = null;
					 if(request.getParameter("category") != null) {
						 category=(String) request.getParameter("category");
						 formBean.setCategory(category);
						 if (category.equals("filter")) {
							 category = ActionConstant.SEARCHBY;
						 } else {
							 category = ActionConstant.SEARCHALL;
						 }
					} 
					  
					String searchValue = formBean.getSearchValue();
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					
					dataMap.put(MapConstant.SEARCH_VALUE, searchValue);
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, category);
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);
	
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<InspectionHeader> qryList =  (List<InspectionHeader>) resultMap.get(MapConstant.CLASS_LIST);		        		
	
			        	formBean.setModelList(qryList);
			        	
			        	int totalNoOfRecords = (int) resultMap.get(MapConstant.PAGINATION_TOTALRECORDS);
			            int noOfPages = (int) Math.ceil(totalNoOfRecords * 1.0 / MiscConstant.RECORDS_PER_PAGE);
						
			            formBean.setNoOfPages(noOfPages);
			            formBean.setCurrentPage(page);
			            
			        } else {
			        	formBean.setModelList(null);
			            formBean.setNoOfPages(0);
			            formBean.setCurrentPage(0);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_TABLE;
				} 
			} else {
				//show main screen
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	

	
	
	
}
