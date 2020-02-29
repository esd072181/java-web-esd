package com.pibs.action;

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
import com.pibs.form.RptPatientHistoryFormBean;
import com.pibs.model.Patient;
import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.PIBSUtils;

public class RptPatientHistoryAction extends Action {
	
	private final static Logger logger = Logger.getLogger(RptPatientHistoryAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		RptPatientHistoryFormBean formBean = (RptPatientHistoryFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.PATIENT_HISTORY_REPORT;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_GO_TO_SEARCH)) {
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					forwardAction = ActionConstant.SHOW_AJAX_GO_TO_SEARCH;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {
					//get all the records from DB
					
					 int page = 1;
				     if(request.getParameter("page") != null) {
				         page = Integer.parseInt(request.getParameter("page")); 
				     }
				     
				    int offset = (page-1) * MiscConstant.RECORDS_PER_PAGE; 

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, ActionConstant.SEARCHBY);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, formBean.getCriteria());
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<Patient> qryList =  (List<Patient>) resultMap.get(MapConstant.CLASS_LIST);		        		

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
			        
				}  else if (command.equalsIgnoreCase(ParamConstant.AJAX_GO_TO)) {
					

					//fetch the data
					
					int patientSystemId = Integer.parseInt(request.getParameter("patientSystemId"));
					
					Patient model = new Patient();
					model.setId(patientSystemId);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
						@SuppressWarnings("unchecked")
						List<Patient> qryList =  (List<Patient>) resultMap.get(MapConstant.CLASS_LIST);	
						
			        	dataMap.clear();
			        	resultMap.clear();
			        	
			        	//parameters are optional here
			        	Map<String, Object> parameters = new HashMap<String, Object>();
			    		parameters.put("PreparedBy", ((User)request.getSession().getAttribute(MiscConstant.USER_SESSION)).getName());
			        		
						dataMap.put(MapConstant.CLASS_LIST, qryList);
						dataMap.put(MapConstant.REPORT_PARAM_MAP, parameters);
						dataMap.put(MapConstant.REPORT_LOCALPATH, PIBSUtils.getReportPath(request));
				        dataMap.put(MapConstant.MODULE, ModuleConstant.REPORT);
					    dataMap.put(MapConstant.ACTION, ActionConstant.GENERATE_REPORT);
					   	dataMap.put(MapConstant.RPT_JASPER, MiscConstant.RPT_PATIENT_HISTORY_REPORT);
					    dataMap.put(MapConstant.RPT_PDF, MiscConstant.PDF_PATIENT_HISTORY_REPORT);

				        service = new ServiceManagerImpl();
				        resultMap = service.executeRequest(dataMap);
			        	
				        if (resultMap!=null && !resultMap.isEmpty()) {
					        boolean isReportGenerated = (boolean) resultMap.get(MapConstant.BOOLEAN_DATA);

				        	if (isReportGenerated) {
				        		formBean.setModelList(qryList);
				        		PIBSUtils.writeLogInfo(logger, MiscConstant.RPT_MESSSAGE_GENERATED_SUCCESS + "-" + module);	
				        	} else {
				        		//need to add message here if report generation failed, make the message dynamic
				        		PIBSUtils.writeLogInfo(logger, MiscConstant.RPT_MESSSAGE_GENERATED_FAILED + "-" + module);
				        	}	
				        } else {
				        	PIBSUtils.writeLogInfo(logger, MiscConstant.RPT_MESSSAGE_GENERATED_FAILED + "-" + module);
				        }
			        }
			       
			        formBean.populateFormBean();
			        
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_EDIT;
				
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_GO_TO;
				
				} 
			} else {
				//show main screen
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	
	


}
