package com.transport.action;

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

import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.constant.ParamConstant;
import com.transport.form.RptWorkPermitFormBean;
import com.transport.model.WorkPermit;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.TransportUtils;

public class RptWorkPermitAction extends Action {
	
	private final static Logger logger = Logger.getLogger(RptWorkPermitAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		RptWorkPermitFormBean formBean = (RptWorkPermitFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");
		
		String localPath = TransportUtils.getReportPath(request);//updated by ESD 15Apr2018
		
		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.RPT_WORK_PERMIT;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {

					String transportId = formBean.getTransportId(); 
					String searchCriteria = formBean.getSearchCriteria();
					String searchValue = formBean.getSearchValue();
					String dateFromValue = formBean.getDateFrom();
					String dateToValue = formBean.getDateTo();
					request.getSession().setAttribute(MiscConstant.WORK_PERMIT_SEARCH_CRITERIA, searchCriteria);
					request.getSession().setAttribute(MiscConstant.TRANSPORT_PROGRAM_CRITERIA, transportId);

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					dataMap.put(MapConstant.TRANSPORT_PROGRAM, transportId);
					dataMap.put(MapConstant.SEARCH_CRITERIA, searchCriteria);
					dataMap.put(MapConstant.SEARCH_VALUE, searchValue);
					dataMap.put(MapConstant.DATE_FROM_VALUE, dateFromValue);
					dataMap.put(MapConstant.DATE_TO_VALUE, dateToValue);
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	@SuppressWarnings("unchecked")
						List<WorkPermit> qryList = (ArrayList<WorkPermit>)resultMap.get(MapConstant.CLASS_LIST);
			        	
			        	dataMap = null;
			        	service = null;
			        	resultMap = null;
			        	
			        	//parameters are optional here
			        	Map<String, Object> parameters = new HashMap<String, Object>();
			        		
						dataMap = new HashMap<String, Object>();
						dataMap.put(MapConstant.CLASS_LIST, qryList);
						dataMap.put(MapConstant.REPORT_PARAM_MAP, parameters);
						dataMap.put(MapConstant.REPORT_LOCALPATH, localPath);
				        dataMap.put(MapConstant.MODULE, module);
					    dataMap.put(MapConstant.ACTION, ActionConstant.GENERATE_REPORT);
					    dataMap.put(MapConstant.RPT_TITLE, MiscConstant.RPT_WORK_PERMIT_TITLE);
					    dataMap.put(MapConstant.RPT_JASPER, MiscConstant.RPT_WORK_PERMIT_REPORT);
					    dataMap.put(MapConstant.RPT_PDF, MiscConstant.PDF_WORK_PERMIT_REPORT);

				        service = new ServiceManagerImpl();
				        resultMap = service.executeRequest(dataMap);
			        	
				        boolean isReportGenerated = (boolean) resultMap.get(MapConstant.BOOLEAN_DATA);

			        	if (isReportGenerated) {
			        		formBean.setModelList(qryList);
			        		TransportUtils.writeLogInfo(logger, MiscConstant.RPT_MESSSAGE_GENERATED_SUCCESS + "-" + module);	
			        	} else {
			        		//need to add message here if report generation failed, make the message dynamic
			        		TransportUtils.writeLogInfo(logger, MiscConstant.RPT_MESSSAGE_GENERATED_FAILED + "-" + module);
			        	}	        	
			        } else {
			        	formBean.setModelList(null);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_SEARCH_STATUS;
				}	
			} else {
					//show main screen
					//load the LOV for Entity Master file
					formBean.populateCriteriaDropdownList(request, formBean);
					if (request.getSession().getAttribute(MiscConstant.RPT_SEARCH_CRITERIA)!=null) {
						request.getSession().setAttribute(MiscConstant.RPT_SEARCH_CRITERIA, null);
					}
					forwardAction = ActionConstant.SHOW_AJAX_MAIN;
		    }
			
		}
		
	
		return mapping.findForward(forwardAction);
	
	}

}

			
		
			
			
	