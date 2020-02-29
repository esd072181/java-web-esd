package com.pibs.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.form.RoomInquiryFormBean;
import com.pibs.model.Room;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;

public class RoomInquiryAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		RoomInquiryFormBean formBean = (RoomInquiryFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.ROOM_INQUIRY;
				
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
				    
					String category = null;
					 if(request.getParameter("category") != null) {
						 category=(String) request.getParameter("category");
						 formBean.setCategory(category);
						 if (category.equals("filter")) {
							 category = ActionConstant.GET_ACTIVE_DATA;
						 } else if (category.equals("all")) {
							 category = ActionConstant.SEARCHALL;
						 } else if (category.equals("available")) {
							 category = ActionConstant.GET_AVAILABLE_ROOMS;
						 } else {
							 category = ActionConstant.GET_OCCUPIED_ROOMS;
						 }
					} 
					  
					String criteria = null;
					if(formBean.getCriteria()!=null && formBean.getCriteria().trim().length() > 0) {
						criteria = formBean.getCriteria();
					}
					  
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, category);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, criteria);
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<Room> qryList =  (List<Room>) resultMap.get(MapConstant.CLASS_LIST);		        		

			        	formBean.setModelList(qryList);
			        	
			        	if (resultMap.get(MapConstant.PAGINATION_TOTALRECORDS)!=null) {
				        	int totalNoOfRecords = (int) resultMap.get(MapConstant.PAGINATION_TOTALRECORDS);
				            int noOfPages = (int) Math.ceil(totalNoOfRecords * 1.0 / MiscConstant.RECORDS_PER_PAGE);
				            formBean.setNoOfPages(noOfPages);
				            formBean.setCurrentPage(page);	
			        	}
			            
			        } else {
			        	formBean.setModelList(null);
			            formBean.setNoOfPages(0);
			            formBean.setCurrentPage(0);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_TABLE;
				}  
			} else {
				//show main screen
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	
	


}
