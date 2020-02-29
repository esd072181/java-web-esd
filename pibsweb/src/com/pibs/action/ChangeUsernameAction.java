package com.pibs.action;

import java.util.HashMap;
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
import com.pibs.form.ChangeUsernameFormBean;
import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.PIBSUtils;

public class ChangeUsernameAction extends Action {

	private final static Logger logger = Logger.getLogger(ChangeUsernameAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		ChangeUsernameFormBean formBean = (ChangeUsernameFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");
	
		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.USER;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_GO_TO)) {
					forwardAction = ActionConstant.SHOW_AJAX_GO_TO;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {
					
					//get the id from session
					User user = (User )request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					User model = new User();
					model.setId(user.getId());
					model.setUserName(formBean.getUserName());
					model.setPassword(formBean.getPassword());
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_CRITERIA);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        model =  (User) resultMap.get(MapConstant.CLASS_DATA);		        		
				        if (model!=null) {
							formBean.setTransactionStatus(false);
							formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_VALID_USERNAME);
				        	forwardAction = ActionConstant.AJAX_SUCCESS;	
				        } else {
							formBean.setTransactionStatus(false);
							formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_INVALID_USERNAME);
				        	forwardAction = ActionConstant.AJAX_FAILED;
				        }
			        } else {
						formBean.setTransactionStatus(false);
						formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_INVALID_USERNAME);
			        	forwardAction = ActionConstant.AJAX_FAILED;
			        }
					
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_EDIT)) {
					//fetch the data
					
					//get the id from session
					User user = (User )request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					User model = new User();
					model.setId(user.getId());
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        model =  (User) resultMap.get(MapConstant.CLASS_DATA);		        		
			        	formBean.populateFormBean(model);
			        }

					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_EDIT;
				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)) {
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					//populateModel
					User model = (User) formBean.populateModel(formBean);					
					model.setId(user.getId());
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.CLASS_DATA, model);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        
			        dataMap.put(MapConstant.ACTION, ActionConstant.UPDATE_USERNAME_PASSWORD);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);

			        	formBean.setTransactionStatus(tranctionStatus);
			        			        	
			        	if (tranctionStatus) {
			        		//show success page
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_UPDATED+" - "+module);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_UPDATED);
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_ERROR+" - "+module);
			        		forwardAction = ActionConstant.AJAX_FAILED;
			        	}
			        }
				}
			}
		
		}
		
		return mapping.findForward(forwardAction);
	}	
	

}
