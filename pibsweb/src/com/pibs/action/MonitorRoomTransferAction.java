package com.pibs.action;

import java.util.ArrayList;
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
import com.pibs.form.MonitorRoomTransferFormBean;
import com.pibs.model.Admission;
import com.pibs.model.MonitorRoomTransfer;
import com.pibs.model.Room;
import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.DateUtils;
import com.pibs.util.PIBSUtils;

public class MonitorRoomTransferAction extends Action {
	
	private final static Logger logger = Logger.getLogger(MonitorRoomTransferAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		MonitorRoomTransferFormBean formBean = (MonitorRoomTransferFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.MONITOR_ROOM_TRANSFER;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_GO_TO_CHILD)) {		
					//fetch the data
					
					int patientSystemCaseId = Integer.parseInt(request.getParameter("patientCaseSystemId"));
					
					MonitorRoomTransfer model = new MonitorRoomTransfer();
					model.setPatientCaseSystemId(patientSystemCaseId);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.SEARCHBY);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {		        		
				        @SuppressWarnings("unchecked")
						List<MonitorRoomTransfer> rsList =  (ArrayList<MonitorRoomTransfer>) resultMap.get(MapConstant.CLASS_LIST);		        		
			        	formBean.populateEntityList(rsList);
			        }

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_GO_TO_CHILD;
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_GO_TO_CHILD_SEARCH)) {
					
					formBean.setPatientCaseSystemId(Integer.parseInt(request.getParameter("patientCaseSystemId")));
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_GO_TO_CHILD_SEARCH;
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {
					//get all the records from DB
					
					 int page = 1;
				     if(request.getParameter("page") != null) {
				         page = Integer.parseInt(request.getParameter("page")); 
				     }
				     
				    int offset = (page-1) * MiscConstant.RECORDS_PER_PAGE; 
				    
					  
					String criteria = null;
					if(formBean.getCriteria()!=null && formBean.getCriteria().trim().length() > 0) {
						criteria = formBean.getCriteria();
					}
				     

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, ModuleConstant.ROOM);
				    dataMap.put(MapConstant.ACTION, ActionConstant.SEARCH_AVAILABLE_ROOMS);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, criteria);
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<Room> qryList =  (List<Room>) resultMap.get(MapConstant.CLASS_LIST);		        		

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
			    
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_ADD)) {

					formBean.getRoomDetails(request);//fetch the Room details

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_ADD;

				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE)) {
					//populateModel
					MonitorRoomTransfer model = (MonitorRoomTransfer) formBean.populateModel(formBean);
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					//check if already got existing room transfer, if yes then get the roomid transfer and datetransferred for roomid and date admitted fields
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_PATIENT_CASE_SYS_ID);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {	
			        	@SuppressWarnings("unchecked")
						List<MonitorRoomTransfer> rsList = (List<MonitorRoomTransfer>) resultMap.get(MapConstant.CLASS_LIST);
			        	MonitorRoomTransfer modelLatest = rsList.get(rsList.size()-1);
			        	model.setRoomId(modelLatest.getRoomIdTransfer());
			        	model.setDateAdmitted(modelLatest.getDateTransferred());
						resultMap.clear();
			        } else {
			        	
			        	dataMap.clear();
						dataMap = null;
						service = null;
						resultMap = null;
						
						//get the current roomid and date admitted using patientcasesystemid
						Admission modelAdmission = new Admission();
						modelAdmission.setId(formBean.getPatientCaseSystemId());
						
						dataMap = new HashMap<String, Object>();
				        dataMap.put(MapConstant.MODULE, ModuleConstant.ADMISSION);
				        dataMap.put(MapConstant.CLASS_DATA, modelAdmission);
				        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_PATIENT_CASE_SYS_ID);
				        
				        service = new ServiceManagerImpl();
				        resultMap = service.executeRequest(dataMap);
						
				        if (resultMap!=null && !resultMap.isEmpty()) {
				        	modelAdmission = (Admission) resultMap.get(MapConstant.CLASS_DATA);		        		
				        	model.setRoomId(modelAdmission.getRoomId());
				        	model.setDateAdmitted(DateUtils.getSQLDateFromSQLTimestamp(modelAdmission.getDateOfCase()));
							resultMap.clear();
				        }
			        }
					
			        dataMap.clear();
					dataMap = null;
					service = null;
					resultMap = null;

					
					//continue to save...
					dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        dataMap.put(MapConstant.ACTION, ActionConstant.SAVE);
			          
			        service = new ServiceManagerImpl();
			        resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean transactionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);

			        	formBean.setTransactionStatus(transactionStatus);
			        	
			        			
			        	if (transactionStatus) {
			        		//show success page
			        		//add confirmation message
			        				        		
			        		if (dataMap.get(MapConstant.ACTION).equals(ActionConstant.SAVE)) {
			        			formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_SAVED);
			        			PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_SAVED+" - "+module);
			        			//logger.info(MiscConstant.TRANS_MESSSAGE_SAVED);
			        		}else {
			        			formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        			PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_UPDATED+" - "+module);
			        			//logger.info(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        		}
			        		

			        		//update the list in the form
			        		service = null;
			        		resultMap = null;
			        		
			        		model = new MonitorRoomTransfer();
							model.setPatientCaseSystemId(formBean.getPatientCaseSystemId());
							
							dataMap = new HashMap<String, Object>();
					        dataMap.put(MapConstant.MODULE, module);
					        dataMap.put(MapConstant.CLASS_DATA, model);
					        dataMap.put(MapConstant.ACTION, ActionConstant.SEARCHBY);
					        
					        service = new ServiceManagerImpl();
					        resultMap = service.executeRequest(dataMap);
							
					        if (resultMap!=null && !resultMap.isEmpty()) {
						        @SuppressWarnings("unchecked")
								List<MonitorRoomTransfer> rsList =  (ArrayList<MonitorRoomTransfer>) resultMap.get(MapConstant.CLASS_LIST);		        		
					        	formBean.populateEntityList(rsList);
					        }
			        		
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_ERROR+" - "+module);
			        		forwardAction = ActionConstant.AJAX_FAILED;
			        	}
			        }
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_DELETE)) {

					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					MonitorRoomTransfer model = new MonitorRoomTransfer();
					model.setId(id);
					
					//get the current roomid and date admitted using id
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {	
						MonitorRoomTransfer rsModel = (MonitorRoomTransfer) resultMap.get(MapConstant.CLASS_DATA);
			        	model.setRoomId(rsModel.getRoomId());
			        	model.setRoomIdTransfer(rsModel.getRoomIdTransfer());
						resultMap.clear();
			        } 
					
					dataMap = null;
					service = null;
					resultMap = null;
					
					//continue to delete...
					dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.DELETE);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        
			        service = new ServiceManagerImpl();
			        resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean transactionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);

			        	formBean.setTransactionStatus(transactionStatus);
			        	
			        	if (transactionStatus) {
			        		//show success page
			        		//add confirmation message
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_DELETED);

			        		//logger.info(MiscConstant.TRANS_MESSSAGE_DELETED);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_DELETED+" - "+module);
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_ERROR+" - "+module);
			        		forwardAction = ActionConstant.AJAX_FAILED;
			        	}
			        }
				}
			} else {
				//show main screen
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	
	


}
