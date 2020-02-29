package com.transport.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.transport.constant.ActionConstant;

public class NavigateAction extends Action {
	
	private final static Logger logger = Logger.getLogger(NavigateAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.info("Enter NavigateAction class....");
		logger.info("Show Main Form....");
		
		String forwardAction = ActionConstant.SHOW_AJAX_MAIN;
		
        return mapping.findForward(forwardAction);
	}
	
}
