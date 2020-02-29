package com.transport.action;

import java.io.PrintWriter;
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
import com.transport.form.VerificationAndValidationFormBean;
import com.transport.model.User;
import com.transport.model.VerificationAndValidation;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.TransportUtils;

public class VerificationAndValidationAction extends Action {

	private final static Logger logger = Logger.getLogger(VerificationAndValidationAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		VerificationAndValidationFormBean formBean = (VerificationAndValidationFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.VERIFICATION_AND_VALIDATION;
				
				if (command.equalsIgnoreCase(ParamConstant.ADD_REFRESH_DROPDOWN_LIST)) {
					//dropdown list fresh data from DB
					formBean.populateDropdownList(request, formBean);
					
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_ADD;
				} else if (command.equalsIgnoreCase(ParamConstant.ADD)) {
					//dropdown list from session
					formBean.populateDropdownListFromSession(request, formBean);
					
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_ADD;
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_EDIT)) {
					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					VerificationAndValidation model = new VerificationAndValidation();
					model.setId(id);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        model =  (VerificationAndValidation) resultMap.get(MapConstant.CLASS_DATA);		        		
			        	formBean.populateFormBean(model);
			        }
			        
			        //dropdown list fresh data from DB
			        formBean.populateDropdownList(request, formBean);
			        
			        //START Transport Revision 1 Dec2015
			        formBean.populateFindingsByItem(request, formBean);
			        formBean.populateCorrectionsByRootCause(request, formBean);
			        formBean.populateClosureByCorrections(request, formBean);
			        //formBean.isPositiveFindings(request, formBean);
			        //END Transport Revision 1 Dec2015

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_EDIT;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)) {
					//populateModel
					VerificationAndValidation model = (VerificationAndValidation) formBean.populateModel(formBean);
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        
			        if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE)) {
				        dataMap.put(MapConstant.ACTION, ActionConstant.SAVE);
			        } else {
			        	dataMap.put(MapConstant.ACTION, ActionConstant.UPDATE);
			        }
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);

			        	formBean.setTransactionStatus(tranctionStatus);
			        	
			        	//get the dropdownlist from session
						try {
							formBean.populateDropdownListFromSession(request, formBean);
						} catch(Exception e) {}		
			        	

			        	if (tranctionStatus) {
			        		//show success page
			        		//add confirmation message
			        				        		
			        		if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE)) {
			        			formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_SAVED);
			        			TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_SAVED+" - "+module);
			        			//logger.info(MiscConstant.TRANS_MESSSAGE_SAVED);
			        		}else {
			        			formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        			TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_UPDATED+" - "+module);
			        			//logger.info(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        		}
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_ERROR+" - "+module);
			        		forwardAction = ActionConstant.AJAX_FAILED;
			        	}
			        }
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_DELETE)) {
					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					VerificationAndValidation model = new VerificationAndValidation();
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
			        	
						//load the LOV for Entity Master file
						formBean.populateVerificationCriteriaDropdownList(request, formBean);
			        	
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
				    
					String actionCategory = null;
					 if(request.getParameter("category") != null) {
						 actionCategory=(String) request.getParameter("category");
						 formBean.setCategory(actionCategory);
						 if (actionCategory.equals("filter")) {
							 actionCategory = ActionConstant.SEARCHBY;
						 } else {
							 actionCategory = ActionConstant.SEARCHALL;
						 }
					} 
					

					String searchCriteria = formBean.getSearchCriteria();
					String searchValue = formBean.getSearchValue();
					String dateFromValue = formBean.getDateFrom();
					String dateToValue = formBean.getDateTo();
					request.getSession().setAttribute(MiscConstant.RPT_SEARCH_CRITERIA, searchCriteria);

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					dataMap.put(MapConstant.SEARCH_CRITERIA, searchCriteria);
					dataMap.put(MapConstant.SEARCH_VALUE, searchValue);
					dataMap.put(MapConstant.DATE_FROM_VALUE, dateFromValue);
					dataMap.put(MapConstant.DATE_TO_VALUE, dateToValue);
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, actionCategory);
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<VerificationAndValidation> qryList =  (List<VerificationAndValidation>) resultMap.get(MapConstant.CLASS_LIST);		        		

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
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_POPULATE_FINDINGS_BY_ITEM)) {
					//Transport Revision 1 Dec2015
					formBean.populateFindingsByItem(request, formBean);
					forwardAction = ActionConstant.SHOW_AJAX_POPULATE_FINDINGS_BY_ITEM;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_POPULATE_CLOSURE_BY_CORRECTIONS)) {
					//Transport Revision 1 Dec2015
					formBean.populateClosureByCorrections(request, formBean);
					forwardAction = ActionConstant.SHOW_AJAX_POPULATE_CLOSURE_BY_CORRECTIONS;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_POPULATE_CORRECTIONS_BY_ROOT_CAUSE)) {
					//Transport Revision 1 Dec2015
					formBean.populateCorrectionsByRootCause(request, formBean);
					forwardAction = ActionConstant.SHOW_AJAX_POPULATE_CORRECTIONS_BY_ROOT_CAUSE;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_IS_POSITIVE_FINDINGS)) {
					//Transport Revision 1 Dec2015				
					response.setContentType("text/plain");
			        response.setCharacterEncoding("UTF-8");
			        PrintWriter out = response.getWriter();
			        out.print(formBean.isPositiveFindings(request, formBean));
			        return null;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_POPULATE_REMINDERS)) {
					//Transport Revision 1 Dec2015
					
					 int page = 1;
				     if(request.getParameter("page") != null) {
				         page = Integer.parseInt(request.getParameter("page")); 
				     }
				     
				    int offset = (page-1) * MiscConstant.RECORDS_PER_PAGE; 
				    
					formBean.populateReminders(request, formBean, page, offset);
					forwardAction = ActionConstant.SHOW_AJAX_POPULATE_REMINDERS;
				}
			} else {
				//show main screen
				//load the LOV for Entity Master file
				formBean.populateVerificationCriteriaDropdownList(request, formBean);
				if (request.getSession().getAttribute(MiscConstant.RPT_SEARCH_CRITERIA)!=null) {
					request.getSession().setAttribute(MiscConstant.RPT_SEARCH_CRITERIA, null);
				}
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	

	
	
	
}
