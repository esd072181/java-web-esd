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
import com.pibs.form.MonitorPhysicalExaminationFormBean;
import com.pibs.model.MonitorPhysicalExamination;
import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.PIBSUtils;

public class MonitorPhysicalExaminationAction extends Action {
	
	private final static Logger logger = Logger.getLogger(MonitorPhysicalExaminationAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		MonitorPhysicalExaminationFormBean formBean = (MonitorPhysicalExaminationFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.MONITOR_PHYSICAL_EXAMINATION;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_GO_TO_CHILD)) {		
					//fetch the data
					
					int patientCaseSystemId = Integer.parseInt(request.getParameter("patientCaseSystemId"));
					
					MonitorPhysicalExamination model = new MonitorPhysicalExamination();
					model.setPatientCaseSystemId(patientCaseSystemId);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.SEARCHBY);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {		        		
				        @SuppressWarnings("unchecked")
						List<MonitorPhysicalExamination> rsList =  (ArrayList<MonitorPhysicalExamination>) resultMap.get(MapConstant.CLASS_LIST);		        		
			        	formBean.populateEntityList(rsList);
			        }

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_GO_TO_CHILD;
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_ADD)) {
					
					int patientCaseSystemId = Integer.parseInt(request.getParameter("patientCaseSystemId"));
					formBean.setPatientCaseSystemId(patientCaseSystemId);

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_ADD;
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_EDIT)) {
				
					formBean.getPhysicalExaminationDetails(request);//fetch the details

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_EDIT;

				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)) {
					//populateModel
					MonitorPhysicalExamination model = (MonitorPhysicalExamination) formBean.populateModel(formBean);
					
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
			        		
			        		model = new MonitorPhysicalExamination();
							model.setPatientCaseSystemId(formBean.getPatientCaseSystemId());
							
							dataMap = new HashMap<String, Object>();
					        dataMap.put(MapConstant.MODULE, module);
					        dataMap.put(MapConstant.CLASS_DATA, model);
					        dataMap.put(MapConstant.ACTION, ActionConstant.SEARCHBY);
					        
					        service = new ServiceManagerImpl();
					        resultMap = service.executeRequest(dataMap);
							
					        if (resultMap!=null && !resultMap.isEmpty()) {
						        @SuppressWarnings("unchecked")
								List<MonitorPhysicalExamination> rsList =  (ArrayList<MonitorPhysicalExamination>) resultMap.get(MapConstant.CLASS_LIST);		        		
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
					
					MonitorPhysicalExamination model = new MonitorPhysicalExamination();
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
