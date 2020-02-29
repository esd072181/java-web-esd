package com.transport.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.transport.config.SpringConfig;
import com.transport.constant.ActionConstant;
import com.transport.util.TransportUtils;

public class LogoutAction extends Action{
	
	private static final Logger logger = Logger.getLogger(LogoutAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//invalidate/end the session
		request.getSession().invalidate();
		TransportUtils.writeLogInfo(logger, "User Session invalidated......");
		//close the Spring IOC container
		SpringConfig.closeSpringConfig();			
		
		//logger.info("Log-out successful..");
		TransportUtils.writeLogInfo(logger, "Log-out successful......");
		
        return mapping.findForward(ActionConstant.SUCCESS);
	}
	
	

}
