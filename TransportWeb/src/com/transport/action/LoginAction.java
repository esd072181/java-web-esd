package com.transport.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.transport.constant.ActionConstant;
import com.transport.util.TransportUtils;


public class LoginAction extends Action{
	
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//START any configuration before showing login page
		
		//END
		System.out.println(request.getSession().getServletContext().getServerInfo()); //Server plus version
		System.out.println(request.getSession().getServletContext().getServletContextName()); //Project name
		TransportUtils.writeLogInfo(logger, "Show log-in screen.......");
		//logger.info("Show log-in screen..");
        return mapping.findForward(ActionConstant.SUCCESS);
	}

	
	
}
