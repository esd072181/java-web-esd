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
import com.transport.form.TireManagementFormBean;
import com.transport.model.TireDetails;
import com.transport.model.User;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 10Apr2020
 * DateUpdated: 15Apr2020
 */
public class TireManagementAction extends Action {

	private final static Logger logger = Logger.getLogger(TireManagementAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		TireManagementFormBean formBean = (TireManagementFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.TIRE_MANAGEMENT;
				
				if (command.equalsIgnoreCase(ParamConstant.ADD) || command.equalsIgnoreCase(ParamConstant.ADD_INNER)) {
					//Go to tire assign
					formBean.populateDropdownList(request, false);
					
					String lorryNo = (String) request.getParameter("lorryNo");
					String wheelPosition = (String) request.getParameter("wheelPosition");
					formBean.setLorryNo(lorryNo);	
					formBean.setWheelPosition(wheelPosition);
					formBean.getPlateNoByLorryNo(lorryNo);
					
					if (command.equalsIgnoreCase(ParamConstant.ADD_INNER)) {
						String serialNo = (String) request.getParameter("serialNo");
						String recapNo = (String) request.getParameter("recapNo");
						formBean.setSerialNo(serialNo);
						formBean.setRecapNo(recapNo);
						formBean.setTractor(formBean.isLorryTractor(wheelPosition));						
					}
					
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);	
					
					if (command.equalsIgnoreCase(ParamConstant.ADD_INNER)) {
						forwardAction = ActionConstant.SHOW_AJAX_ADD_INNER;
					} else {
						forwardAction = ActionConstant.SHOW_AJAX_ADD;
					}
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_SAVE_INNER)) {
					//Save tire assign
					//populateModel
					TireDetails model = (TireDetails) formBean.populateModel(formBean, command);
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
				    dataMap.put(MapConstant.ACTION, ActionConstant.SAVE);
				    dataMap.put(MapConstant.SUB_ACTION, command);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);

			        	formBean.setTransactionStatus(tranctionStatus);
			        	
			        	//get the dropdown list from session
			        	formBean.populateDropdownListFromSession(request, false);
			        			        	
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
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_EDIT)) {
					//Go to tire remove
					formBean.populateDropdownList(request, false);
					
					String lorryNo = (String) request.getParameter("lorryNo");
					String wheelPosition = (String) request.getParameter("wheelPosition");
					String serialNo = (String) request.getParameter("serialNo");
					String recapNo = (String) request.getParameter("recapNo");
					formBean.setLorryNo(lorryNo);	
					formBean.setWheelPosition(wheelPosition);
					formBean.setSerialNo(serialNo);
					formBean.setRecapNo(recapNo);
					formBean.getPlateNoByLorryNo(lorryNo);
					formBean.setTractor(formBean.isLorryTractor(wheelPosition));
					
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);		
					
					forwardAction = ActionConstant.SHOW_AJAX_EDIT;
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_EDIT_INNER)) {
					//Go to tire edit
					
					String id = (String) request.getParameter("id");
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, id);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
						TireDetails resultModel =  (TireDetails) resultMap.get(MapConstant.CLASS_DATA);		        		
			        	formBean.populateFormBean(resultModel);
			        } 
					
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);		
					
					forwardAction = ActionConstant.SHOW_AJAX_EDIT_2;
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE_INNER)) {
					//populateModel
					TireDetails model = (TireDetails) formBean.populateModel(formBean, command);
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        if (command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE_INNER)) {
			        	 dataMap.put(MapConstant.ACTION, ActionConstant.UPDATE_2);	
			        } else {
			        	dataMap.put(MapConstant.ACTION, ActionConstant.UPDATE);
			        }
				    
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);

			        	formBean.setTransactionStatus(tranctionStatus);
			        	
			        	//get the dropdown list from session
			        	formBean.populateDropdownListFromSession(request, false);
			        			        	
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
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH_BY_CRITERIA)) {
					
					String lorryNo = (String) request.getParameter("lorryNo");

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.ACTION, ActionConstant.SEARCHALL);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, lorryNo);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<TireDetails> qryList =  (List<TireDetails>) resultMap.get(MapConstant.CLASS_LIST);		        		
			        	formBean.setTireDetailsList(qryList);
			        	formBean.setTireDetailsView(qryList);

			        } else {
			        	formBean.setTireDetailsList(null);
			          
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_TABLE;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {

					String serialNo = (String) request.getParameter("serialNo");

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.ACTION, ActionConstant.SEARCHBY);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, serialNo);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<TireDetails> qryList =  (List<TireDetails>) resultMap.get(MapConstant.CLASS_LIST);		        		
			        	formBean.setTireDetailsList(qryList);
			        	formBean.setTireDetailsLatestInfo(qryList);

			        } else {
			        	formBean.setTireDetailsList(null);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_VIEW;
			        
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH_INNER)) {

					String serialNo = (String) request.getParameter("serialNo");

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_CRITERIA);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, serialNo);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
						TireDetails tireModel =  (TireDetails) resultMap.get(MapConstant.CLASS_DATA);		        		
						formBean.setOdometer(String.valueOf(tireModel.getOdometerFitted()));
			        } else {
			        	formBean.setTireDetailsList(null);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_VIEW_2;
				
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_VIEW)) {
					//Lorry History
					String lorryNo = (String) request.getParameter("lorryNo");
					formBean.setLorryNo(lorryNo);

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, lorryNo);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
						@SuppressWarnings("unchecked")
						List<TireDetails> qryList =  (List<TireDetails>) resultMap.get(MapConstant.CLASS_LIST);	
						formBean.setTireDetailsList(qryList);
			        } else {
			        	formBean.setTireDetailsList(null);
			        }
				
					forwardAction = ActionConstant.SHOW_AJAX_VIEW_3;
				}	
			} else {
				//show main screen
				formBean.populateDropdownList(request, false);
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	
	

}
