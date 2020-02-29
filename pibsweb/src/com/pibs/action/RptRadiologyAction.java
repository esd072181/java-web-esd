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

import com.pibs.form.RptRadiologyFormBean;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.Radiology;
import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.PIBSUtils;

public class RptRadiologyAction extends Action {
	
	private final static Logger logger = Logger.getLogger(RptRadiologyAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		RptRadiologyFormBean formBean = (RptRadiologyFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");
		
		String localPath = PIBSUtils.getReportPath(request);
		
		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.RADIOLOGY_LIST_REPORT;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {

					String searchCriteria = formBean.getSearchCriteria();
					String searchValue = formBean.getSearchValue();
					request.getSession().setAttribute(MiscConstant.RPT_SEARCH_CRITERIA, searchCriteria);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					dataMap.put(MapConstant.SEARCH_CRITERIA, searchCriteria);
					dataMap.put(MapConstant.SEARCH_VALUE, searchValue);
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	@SuppressWarnings("unchecked")
						List<Radiology> qryList = (ArrayList<Radiology>)resultMap.get(MapConstant.CLASS_LIST);
			        	
			        	dataMap.clear();
			        	resultMap.clear();
			        	
			        	//parameters are optional here
			        	Map<String, Object> parameters = new HashMap<String, Object>();
			    		parameters.put("PreparedBy", ((User)request.getSession().getAttribute(MiscConstant.USER_SESSION)).getName());
			        		
						dataMap.put(MapConstant.CLASS_LIST, qryList);
						dataMap.put(MapConstant.REPORT_PARAM_MAP, parameters);
						dataMap.put(MapConstant.REPORT_LOCALPATH, localPath);
				        dataMap.put(MapConstant.MODULE, ModuleConstant.REPORT);
					    dataMap.put(MapConstant.ACTION, ActionConstant.GENERATE_REPORT);
					   	dataMap.put(MapConstant.RPT_JASPER, MiscConstant.RPT_RADIOLOGY_REPORT);
					    dataMap.put(MapConstant.RPT_PDF, MiscConstant.PDF_RADIOLOGY_SUPPLY_REPORT);

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
        	
			        } else {
			        	formBean.setModelList(null);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_SEARCH_STATUS;
				}	
			} else {
					//show main screen
					//load the LOV for Entity Master file
					formBean.populateCriteriaDropdownList(request);
					if (request.getSession().getAttribute(MiscConstant.RPT_SEARCH_CRITERIA)!=null) {
						request.getSession().setAttribute(MiscConstant.RPT_SEARCH_CRITERIA, null);
					}
					forwardAction = ActionConstant.SHOW_AJAX_MAIN;
		    }
			
		}
		
	
		return mapping.findForward(forwardAction);
	
	}

}

			
		
			
			
	