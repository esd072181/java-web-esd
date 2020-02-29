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
import com.transport.form.ArchiveFormBean;
import com.transport.model.Closure;
import com.transport.model.Corrections;
import com.transport.model.DriverIncident;
import com.transport.model.DriverTraining;
import com.transport.model.Employee;
import com.transport.model.Findings;
import com.transport.model.FollowUp;
import com.transport.model.Items;
import com.transport.model.Lorry;
import com.transport.model.Remarks;
import com.transport.model.RootCause;
import com.transport.model.Terminal;
import com.transport.model.User;
import com.transport.model.VerificationAndValidation;
import com.transport.model.WorkPermit;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.TransportUtils;

public class ArchiveAction extends Action {

	private final static Logger logger = Logger.getLogger(ArchiveAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		ArchiveFormBean formBean = (ArchiveFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");
		
		
		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.ARCHIVE;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_RESTORE)) {
					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					
					String entity = (String) request.getSession().getAttribute(MiscConstant.UTILS_ENTITY_TYPE_CRITERIA);//get from session
					
					if (entity!=null) {
					   	switch(Integer.parseInt(entity)) {
			        		case MiscConstant.LOV_ENTITY_TYPE_EMPLOYEE:
								Employee employeeModel = new Employee();
								employeeModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, employeeModel);
								module = ModuleConstant.EMPLOYEE;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_LORRY:
								Lorry lorryModel = new Lorry();
								lorryModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, lorryModel); 
								module = ModuleConstant.LORRY;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ITEMS:
								Items itemsModel = new Items();
								itemsModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, itemsModel); 
								module = ModuleConstant.ITEMS;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_CORRECTIONS:
								Corrections correctionsModel = new Corrections();
								correctionsModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, correctionsModel); 
								module = ModuleConstant.CORRECTIONS;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_FOLLOWUP:
								FollowUp followUpModel = new FollowUp();
								followUpModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, followUpModel); 
								module = ModuleConstant.FOLLOW_UP;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_REMARKS:
								Remarks remarksModel = new Remarks();
								remarksModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, remarksModel); 
								module = ModuleConstant.REMARKS;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_USER:
								User userModel = new User();
								userModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, userModel); 
								module = ModuleConstant.USER;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_VERIFICATION_AND_VALIDATION:
								VerificationAndValidation verificationModel = new VerificationAndValidation();
								verificationModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, verificationModel); 
								module = ModuleConstant.VERIFICATION_AND_VALIDATION;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_TERMINAL:
								Terminal terminalModel = new Terminal();
								terminalModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, terminalModel); 
								module = ModuleConstant.TERMINAL;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_FINDINGS:
								Findings findingsModel = new Findings();
								findingsModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, findingsModel); 
								module = ModuleConstant.FINDINGS;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ROOT_CAUSE:
								RootCause rootCauseModel = new RootCause();
								rootCauseModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, rootCauseModel); 
								module = ModuleConstant.ROOT_CAUSE;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_CLOSURE:
								Closure closureModel = new Closure();
								closureModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, closureModel); 
								module = ModuleConstant.CLOSURE;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_WORK_PERMIT:
								WorkPermit workPermitModel = new WorkPermit();
								workPermitModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, workPermitModel); 
								module = ModuleConstant.WORK_PERMIT;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_DRIVER_TRAINING:
								DriverTraining driverTrainingModel = new DriverTraining();
								driverTrainingModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, driverTrainingModel); 
								module = ModuleConstant.DRIVER_TRAINING;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_DRIVER_INCIDENT:
								DriverIncident driverIncidentModel = new DriverIncident();
								driverIncidentModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, driverIncidentModel); 
								module = ModuleConstant.DRIVER_INCIDENT;
			        			break;
			        		default:
			        			break;
			        	}				
					}

					dataMap.put(MapConstant.ENTITY, entity);
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.ACTION, ActionConstant.RESTORE);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);

			        	formBean.setTransactionStatus(tranctionStatus);
			        	formBean.populateEntityTypeDropdownList(request, formBean);
			        	
			        	if (tranctionStatus) {
			        		//show success page
			        		//add confirmation message
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESTORED);

			        		//logger.info(MiscConstant.TRANS_MESSSAGE_DELETED);
			        		TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_RESTORED+" - "+module);
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		TransportUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_RESTORED+" - "+module);
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

					String entity = formBean.getEntity();
					request.getSession().setAttribute(MiscConstant.UTILS_ENTITY_TYPE_CRITERIA, entity);
					
					switch(Integer.parseInt(entity)) {
		        		case MiscConstant.LOV_ENTITY_TYPE_EMPLOYEE:
		        			module = ModuleConstant.EMPLOYEE;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_LORRY:
		        			module = ModuleConstant.LORRY;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_ITEMS:
		        			module = ModuleConstant.ITEMS;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_CORRECTIONS:
		        			module = ModuleConstant.CORRECTIONS;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_FOLLOWUP:
		        			module = ModuleConstant.FOLLOW_UP;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_REMARKS:
		        			module = ModuleConstant.REMARKS;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_USER:
		        			module = ModuleConstant.USER;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_VERIFICATION_AND_VALIDATION:
		        			module = ModuleConstant.VERIFICATION_AND_VALIDATION;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_TERMINAL:
		        			module = ModuleConstant.TERMINAL;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_FINDINGS:
		        			module = ModuleConstant.FINDINGS;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_ROOT_CAUSE:
							module = ModuleConstant.ROOT_CAUSE;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_CLOSURE:
							module = ModuleConstant.CLOSURE;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_WORK_PERMIT:
							module = ModuleConstant.WORK_PERMIT;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_DRIVER_TRAINING:
							module = ModuleConstant.DRIVER_TRAINING;
		        			break;
		        		case MiscConstant.LOV_ENTITY_TYPE_DRIVER_INCIDENT:
							module = ModuleConstant.DRIVER_INCIDENT;
		        			break;
		        		default:
		        			break;
					}

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					dataMap.put(MapConstant.ENTITY, entity);
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, ActionConstant.GET_INACTIVE_DATA);
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
			        	switch(Integer.parseInt(entity)) {
			        		case MiscConstant.LOV_ENTITY_TYPE_EMPLOYEE:
								@SuppressWarnings("unchecked")
								List<Employee> employeeList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setEmployeeList(employeeList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_LORRY:
								@SuppressWarnings("unchecked")
								List<Lorry> qryList =  (List<Lorry>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setLorryList(qryList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ITEMS:
								@SuppressWarnings("unchecked")
								List<Items> itemsList =  (List<Items>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setItemsList(itemsList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_CORRECTIONS:
								@SuppressWarnings("unchecked")
								List<Corrections> correctionsList =  (List<Corrections>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setCorrectionsList(correctionsList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_FOLLOWUP:
								@SuppressWarnings("unchecked")
								List<FollowUp> followUpList =  (List<FollowUp>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setFollowUpList(followUpList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_REMARKS:
								@SuppressWarnings("unchecked")
								List<Remarks> remarksList =  (List<Remarks>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setRemarksList(remarksList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_USER:
								@SuppressWarnings("unchecked")
								List<User> userList =  (List<User>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setUserList(userList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_VERIFICATION_AND_VALIDATION:
								@SuppressWarnings("unchecked")
								List<VerificationAndValidation> verificationList =  (List<VerificationAndValidation>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setVerificationList(verificationList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_TERMINAL:
								@SuppressWarnings("unchecked")
								List<Terminal> terminalList =  (List<Terminal>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setTerminalList(terminalList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_FINDINGS:
								@SuppressWarnings("unchecked")
								List<Findings> findingsList =  (List<Findings>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setFindingsList(findingsList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ROOT_CAUSE:
								@SuppressWarnings("unchecked")
								List<RootCause> rootCauseList =  (List<RootCause>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setRootCauseList(rootCauseList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_CLOSURE:
								@SuppressWarnings("unchecked")
								List<Closure> closureList =  (List<Closure>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setClosureList(closureList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_WORK_PERMIT:
								@SuppressWarnings("unchecked")
								List<WorkPermit> workPermitList =  (List<WorkPermit>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setWorkPermitList(workPermitList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_DRIVER_TRAINING:
								@SuppressWarnings("unchecked")
								List<DriverTraining> driverTrainingList =  (List<DriverTraining>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setDriverTrainingList(driverTrainingList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_DRIVER_INCIDENT:
								@SuppressWarnings("unchecked")
								List<DriverIncident> driverIncidentList =  (List<DriverIncident>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setDriverIncidentList(driverIncidentList);
			        			break;
			        		default:
			        			break;
			        	}

			        	int totalNoOfRecords = (int) resultMap.get(MapConstant.PAGINATION_TOTALRECORDS);
			            int noOfPages = (int) Math.ceil(totalNoOfRecords * 1.0 / MiscConstant.RECORDS_PER_PAGE);
						
			            formBean.setNoOfPages(noOfPages);
			            formBean.setCurrentPage(page);
			            
			        } else {
			        	formBean.setLorryList(null);
			        	//formBean.setModelList(null);
			            formBean.setNoOfPages(0);
			            formBean.setCurrentPage(0);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_TABLE;
					
				}
			} else {
				//show main screen
				//load the LOV for Entity Master file
				formBean.populateEntityTypeDropdownList(request, formBean);
				if (request.getSession().getAttribute(MiscConstant.UTILS_ENTITY_TYPE_CRITERIA)!=null) {
					request.getSession().setAttribute(MiscConstant.UTILS_ENTITY_TYPE_CRITERIA, null);
				}
				forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	
	

}
