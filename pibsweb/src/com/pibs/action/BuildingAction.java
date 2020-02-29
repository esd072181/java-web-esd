package com.pibs.action;

//import java.util.ArrayList;
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

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.form.BuildingFormBean;
import com.pibs.model.Building;
import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.PIBSUtils;

public class BuildingAction extends Action{
	
	private final static Logger logger = Logger.getLogger(BuildingAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		BuildingFormBean formBean = (BuildingFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.BUILDING;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_ADD)) {
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_ADD;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_EDIT)) {
					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					Building model = new Building();
					model.setId(id);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        model =  (Building) resultMap.get(MapConstant.CLASS_DATA);		        		
			        	formBean.populateFormBean(model);
			        }

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_EDIT;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)) {
					//populateModel
					Building model = (Building) formBean.populateModel(formBean);
					
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
			        	
			        	if (tranctionStatus) {
			        		//show success page
			        		//add confirmation message
			        				        		
			        		if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE)) {
			        			formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_SAVED);	
			        			//logger.info(MiscConstant.TRANS_MESSSAGE_SAVED);
			        			PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_SAVED+" - "+ModuleConstant.BUILDING);
			        		}else {
			        			formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        			//logger.info(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        			PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_UPDATED+" - "+ModuleConstant.BUILDING);
			        		}
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_ERROR+" - "+ModuleConstant.BUILDING);
			        		forwardAction = ActionConstant.AJAX_FAILED;
			        	}
			        }
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_DELETE)) {
					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					Building model = new Building();
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
			        	
			        	if (tranctionStatus) {
			        		//show success page
			        		//add confirmation message
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_DELETED);
			        		//request.getSession().setAttribute(MiscConstant.TRANS_MESSAGE_SESSION, MiscConstant.TRANS_MESSSAGE_DELETED);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_DELETED);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_DELETED+" - "+ModuleConstant.BUILDING);
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//request.getSession().setAttribute(MiscConstant.TRANS_MESSAGE_SESSION, MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_ERROR+" - "+ModuleConstant.BUILDING);
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
						 //request.getSession().setAttribute("category", category);//put in session
						 formBean.setCategory(category);//put in formBean
						 if (category.equals("filter")) {
							 category = ActionConstant.SEARCHBY;
						 } else {
							 category = ActionConstant.SEARCHALL;
						 }
					} 
					  
					String criteria = null;
					if(formBean.getCriteria()!=null && formBean.getCriteria().trim().length() > 0) {
						criteria = formBean.getCriteria();
					}
				     
				     
//					//check the TransactionMessage session variable if got value for Delete Transaction
//					if (request.getSession().getAttribute(MiscConstant.TRANS_MESSAGE_SESSION)!=null) {
//						formBean.setTransactionMessage((String) request.getSession().getAttribute(MiscConstant.TRANS_MESSAGE_SESSION));
//						request.getSession().setAttribute(MiscConstant.TRANS_MESSAGE_SESSION, null);
//					}
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, category);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, criteria);
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<Building> qryList =  (List<Building>) resultMap.get(MapConstant.CLASS_LIST);		        		

			        	formBean.setModelList(qryList);
			        	
			        	int totalNoOfRecords = (int) resultMap.get(MapConstant.PAGINATION_TOTALRECORDS);
			            int noOfPages = (int) Math.ceil(totalNoOfRecords * 1.0 / MiscConstant.RECORDS_PER_PAGE);
						
			           // request.getSession().setAttribute("results", formBean.getModelList());
			            //request.getSession().setAttribute("noOfPages", noOfPages);
						//request.getSession().setAttribute("currentPage", page);
			            formBean.setNoOfPages(noOfPages);
			            formBean.setCurrentPage(page);
			            
			        } else {
			        	formBean.setModelList(null);
			            //request.getSession().setAttribute("noOfPages", 0);
						//request.getSession().setAttribute("currentPage", 0);
			            formBean.setNoOfPages(0);
			            formBean.setCurrentPage(0);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_TABLE;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH_BY_CRITERIA)) {
					
				}
			} else {
				//show main screen
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}
	
	

}
