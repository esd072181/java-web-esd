package com.pibs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.util.PIBSUtils;

public class LogoutAction extends Action{
	
	private static final Logger logger = Logger.getLogger(LogoutAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//START remove Session attributes here
		request.getSession().removeAttribute(MiscConstant.USER_SESSION);
		
		//invalidate/end the session
		request.getSession().invalidate();
		PIBSUtils.writeLogInfo(logger, "User Session invalidated......");
		
		//END
		//logger.info("Log-out successful..");
		PIBSUtils.writeLogInfo(logger, "Log-out successful......");
		
        return mapping.findForward(ActionConstant.SUCCESS);
	}
	
	

}
