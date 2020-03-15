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
import com.transport.form.LoginFormBean;
import com.transport.model.ListValue;
import com.transport.model.User;
import com.transport.model.UserAccess;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.TransportUtils;

public class LoginValidateAction extends Action{
	
	private final static Logger logger = Logger.getLogger(LoginValidateAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//logger.info("Enter Login validate class....");
		TransportUtils.writeLogInfo(logger, "Enter Login validate class......");
		
		LoginFormBean formBean = (LoginFormBean) form;
		Boolean isMobile = formBean.getIsMobile();
		
		//check if user is already logged in, to show the home screen or for refresh
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION)!=null) {
			if (isMobile!=null) {
				return mapping.findForward(ActionConstant.SUCCESS_2);
			} else {
				if (request.getSession().getAttribute(MiscConstant.IS_MOBILE)!=null && request.getSession().getAttribute(MiscConstant.IS_MOBILE).toString().equals("true")) {
					return mapping.findForward(ActionConstant.SUCCESS_2);
				} else {
					return mapping.findForward(ActionConstant.SUCCESS);
				}
					
			}
		}
		
		User user = new User();
		user.setUserName(formBean.getUserName());
		user.setPassword(formBean.getPassword());
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LOGIN);
        dataMap.put(MapConstant.ACTION, ActionConstant.VALIDATEUSER);
        dataMap.put(MapConstant.CLASS_DATA, user);
        
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        String forwardAction = ActionConstant.NONE;
        
        if (resultMap!=null && !resultMap.isEmpty()) {
        	boolean isUserValid = Boolean.parseBoolean((String)resultMap.get(MapConstant.BOOLEAN_DATA));
        	if (isUserValid) {
        		user = (User) resultMap.get(MapConstant.CLASS_DATA);
        		//START put the user details and LOV in session 
        		request.getSession().setAttribute(MiscConstant.USER_SESSION, user);
        		request.getSession().setAttribute(MiscConstant.USER_ROLE_SESSION, user.getRole());
        		request.getSession().setAttribute(MiscConstant.USER_EMP_ID_SESSION, user.getEmployeeId());
        		//Get User Access
        		List<Integer> accessList = getUserAccess(user.getId());
        		request.getSession().setAttribute(MiscConstant.USER_ACCESS_LIST, accessList);
        		//Store LOV to Session
        		storeLOVToSession(request);
        		//END
        		formBean.setUserAccountValidated("true");

        		if (isMobile!=null) {
        			request.getSession().setAttribute(MiscConstant.IS_MOBILE, "true");
        			forwardAction = ActionConstant.SUCCESS_2;
        		} else {
        			request.getSession().setAttribute(MiscConstant.IS_MOBILE, "false");
        			forwardAction = ActionConstant.SUCCESS;	
        		}
        		
        		//logger.info("User account confirmed valid...go to main screen..");
        		TransportUtils.writeLogInfo(logger, "User account confirmed valid...go to main screen......");
        	} else {
        		//logger.info("User account invalid!");
        		formBean.setUserAccountValidated("invalid");
        		TransportUtils.writeLogInfo(logger, "Invalid user account......");
        		
        		if (isMobile!=null) {
        			forwardAction = ActionConstant.FAILED_2;
        		} else {
        			forwardAction = ActionConstant.FAILED;	
        		}
        		
        	}
        }
        
        //logger.info("Exit Login validate class...");
        TransportUtils.writeLogInfo(logger, "Exit Login validate class.......");
        
        return mapping.findForward(forwardAction);
	}
	


	@SuppressWarnings("unchecked")
	private void storeLOVToSession(HttpServletRequest request) throws Exception{
		
		//Type of Entity
		ListValue lov = new ListValue();//instantiate only once
		lov.setListTypeId(MiscConstant.LOVTYPE_ENTITY_TYPE);
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();//instantiate only once
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
        ServiceManager service = new ServiceManagerImpl(); //instantiate only once
        Map<String, Object> resultMap = service.executeRequest(dataMap); //instantiate only once
        
		List<?> lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_ENTITY_TYPE_SESSION, lovList);
		
		//Category of Employee
//		resultMap = null;
		resultMap.clear();
		lovList = null;
		
//		lov = new ListValue();
		lov.setListTypeId(MiscConstant.LOVTYPE_EMPLOYEE_CATEGORY);
		
//		dataMap = new HashMap<String, Object>();
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
//        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_EMPLOYEE_CATEGORY_SESSION, lovList);
		
		//Role of User
//		resultMap = null;
		resultMap.clear();
		lovList = null;
		
//		lov = new ListValue();
		lov.setListTypeId(MiscConstant.LOVTYPE_USER_ROLE);
		
//		dataMap = new HashMap<String, Object>();
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
//        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_USER_ROLE_SESSION, lovList);
		
		//Verification Criteria for Reports
//		resultMap = null;
		resultMap.clear();
		lovList = null;
		
//		lov = new ListValue();
		lov.setListTypeId(MiscConstant.LOVTYPE_VERIFICATION_CRITERIA);
		
//		dataMap = new HashMap<String, Object>();
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
//        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_VERIFICATION_CRITERIA_SESSION, lovList);
		
		//Findings Type - Added for Revision 1 Dec2015
//		resultMap = null;
		resultMap.clear();
		lovList = null;
		
//		lov = new ListValue();
		lov.setListTypeId(MiscConstant.LOVTYPE_FINDINGS_TYPE);
		
//		dataMap = new HashMap<String, Object>();
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
//        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_FINDINGS_TYPE_SESSION, lovList);
		        		
		//Work Permit Criteria
//		resultMap = null;
		resultMap.clear();
		lovList = null;
		
//		lov = new ListValue();
		lov.setListTypeId(MiscConstant.LOVTYPE_WORK_PERMIT_CRITERIA);
		
//		dataMap = new HashMap<String, Object>();
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
//        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_WORK_PERMIT_CRITERIA_SESSION, lovList);

		//Boolean Y/N LOV
//		resultMap = null;
		resultMap.clear();
		lovList = null;
		
//		lov = new ListValue();
		lov.setListTypeId(MiscConstant.LOVTYPE_BOOLEAN_YN);
		
//		dataMap = new HashMap<String, Object>();
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
//        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_BOOLEAN_YN_SESSION, lovList);
		
		//Transport Program LOV
//		resultMap = null;
		resultMap.clear();
		lovList = null;
		
//		lov = new ListValue();
		lov.setListTypeId(MiscConstant.LOVTYPE_TRANPORT_PROGRAM);
		
//		dataMap = new HashMap<String, Object>();
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
//        service = new ServiceManagerImpl();
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_TRANSPORT_PROGRAM_SESSION, lovList);	

		//Maintenance Personnel LOV
		resultMap.clear();
		lovList = null;
		
		lov.setListTypeId(MiscConstant.LOVTYPE_MAINTENANCE_PERSONNEL);
		
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_MAINTENANCE_PERSONNEL_SESSION, lovList);	

		//GPS Personnel LOV
		resultMap.clear();
		lovList = null;
		
		lov.setListTypeId(MiscConstant.LOVTYPE_GPS_PERSONNEL);
		
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_GPS_PERSONNEL_SESSION, lovList);	

		//Lorry Category LOV
		resultMap.clear();
		lovList = null;
		
		lov.setListTypeId(MiscConstant.LOVTYPE_LORRY_CATEGORY);
		
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_LORRY_CATEGORY_SESSION, lovList);	

		//Driver Training LOV
		resultMap.clear();
		lovList = null;
		
		lov.setListTypeId(MiscConstant.LOVTYPE_DRIVER_TRAINING);
		
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_DRIVER_TRAINING_SESSION, lovList);	
		
		//Trip Issue Category LOV
		resultMap.clear();
		lovList = null;
		
		lov.setListTypeId(MiscConstant.LOVTYPE_TRIP_ISSUE_CATEGORY);
		
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_TRIP_ISSUE_CATEGORY_SESSION, lovList);	
		//Store it to LOV of Maintenance Monitoring Model
		TransportUtils.setGpsTripIssueCategoryLOV((List<ListValue>)lovList);

		//Maintenance Category LOV
		resultMap.clear();
		lovList = null;
		
		lov.setListTypeId(MiscConstant.LOVTYPE_MAINTENANCE_CATEGORY);
		
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_MAINTENANCE_CATEGORY_SESSION, lovList);	
		//Store it to LOV of Maintenance Monitoring Model
		TransportUtils.setMaintenanceCategoryLOV((List<ListValue>)lovList);

				
		//User Access LOV
		resultMap.clear();
		lovList = null;
		
		lov.setListTypeId(MiscConstant.LOVTYPE_USER_ACCESS);
		
		dataMap.clear();
        dataMap.put(MapConstant.MODULE, ModuleConstant.LIST_VALUE);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_LIST_TYPE);
        dataMap.put(MapConstant.CLASS_DATA, lov);
        
        resultMap = service.executeRequest(dataMap);
        
        lovList = (ArrayList<?>) resultMap.get(MapConstant.CLASS_DATA);
		request.getSession().setAttribute(MiscConstant.LOV_USER_ACCESS_SESSION, lovList);	
		
	}

	@SuppressWarnings("unchecked")
	private List<Integer> getUserAccess(int userId) throws Exception {
	     
		List<Integer> accessList = new ArrayList<>();
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.USER_ACCESS);
		dataMap.put(MapConstant.ACTION, ActionConstant.SEARCHBY);
		dataMap.put(MapConstant.SEARCH_CRITERIA, userId);
		
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
		
		if (resultMap!=null && !resultMap.isEmpty()) {
			List<UserAccess> qryList =  (ArrayList<UserAccess>) resultMap.get(MapConstant.CLASS_LIST);
			for (UserAccess item: qryList)  {
				accessList.add(item.getAccessId());
			}
		}
		
		return accessList;
	}
	
	
}
