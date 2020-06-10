package com.transport.action;

import java.util.HashMap;
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
import com.transport.form.RptTireStatusSummaryFormBean;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 24Apr2020
 */
public class RptTireStatusSummaryAction extends Action {
	
	private final static Logger logger = Logger.getLogger(RptTireStatusSummaryAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RptTireStatusSummaryFormBean formBean = (RptTireStatusSummaryFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");
		
		String localPath = TransportUtils.getReportPath(request);
		
		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.RPT_TIRE_STATUS_SUMMARY;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {

					String searchValue = formBean.getSearchValue();

					//parameters are optional here
		        	Map<String, Object> parameters = new HashMap<String, Object>();
		        	
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					dataMap.put(MapConstant.SEARCH_VALUE, searchValue);
					dataMap.put(MapConstant.REPORT_PARAM_MAP, parameters);
					dataMap.put(MapConstant.REPORT_LOCALPATH, localPath);
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, ActionConstant.GENERATE_REPORT);
				    dataMap.put(MapConstant.RPT_TITLE, MiscConstant.RPT_TIRE_STATUS_SUMMARY_TITLE);
				    dataMap.put(MapConstant.RPT_JASPER, MiscConstant.RPT_TIRE_STATUS_SUMMARY_REPORT);
				    dataMap.put(MapConstant.RPT_PDF, MiscConstant.PDF_TIRE_STATUS_SUMMARY_REPORT);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {

				        boolean isReportGenerated = (boolean) resultMap.get(MapConstant.BOOLEAN_DATA);

			        	if (isReportGenerated) {
			        		response.getWriter().println(MiscConstant.PDF_TIRE_STATUS_SUMMARY_REPORT);	
			        		TransportUtils.writeLogInfo(logger, MiscConstant.RPT_MESSSAGE_GENERATED_SUCCESS + "-" + module);	
			        	} else {
			        		//need to add message here if report generation failed, make the message dynamic
			        		TransportUtils.writeLogInfo(logger, MiscConstant.RPT_MESSSAGE_GENERATED_FAILED + "-" + module);
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

			
		
			
			
	