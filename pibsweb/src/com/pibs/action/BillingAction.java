package com.pibs.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.form.BillingFormBean;
//import com.pibs.model.Billing;
import com.pibs.model.Patient;
//import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.BillingUtils;

public class BillingAction extends Action {
	
//	private final static Logger logger = Logger.getLogger(BillingAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		BillingFormBean formBean = (BillingFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
//				int module = ModuleConstant.BILLING;
				
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
							 category = ActionConstant.SEARCH_PATIENT_ADMITTED;
						 } else {
							 category = ActionConstant.SEARCH_ALL_PATIENT_ADMITTED;
						 }
					} 
					  
					String criteria = null;
					if(formBean.getCriteria()!=null && formBean.getCriteria().trim().length() > 0) {
						criteria = formBean.getCriteria();
					}

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, ModuleConstant.PATIENT);
				    dataMap.put(MapConstant.ACTION, category);
				    dataMap.put(MapConstant.SEARCH_CRITERIA, criteria);
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
						@SuppressWarnings("unchecked")
						List<Patient> qryList =  (List<Patient>) resultMap.get(MapConstant.CLASS_LIST);		        		

			        	formBean.setModelList(qryList);
			        	
			        	int totalNoOfRecords = (int) resultMap.get(MapConstant.PAGINATION_TOTALRECORDS);
			            int noOfPages = (int) Math.ceil(totalNoOfRecords * 1.0 / MiscConstant.RECORDS_PER_PAGE);
						
			            formBean.setNoOfPages(noOfPages);
			            formBean.setCurrentPage(page);
			            
			        } else {
			        	formBean.setModelList(null);
			            formBean.setNoOfPages(0);
			            formBean.setCurrentPage(0);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_TABLE;
			        
				}  else if (command.equalsIgnoreCase(ParamConstant.AJAX_GO_TO)) {
					
					int patientCaseSystemId = Integer.parseInt(request.getParameter("patientCaseSystemId"));				
					
					formBean.setId(patientCaseSystemId);
					formBean.getPatientAdmissionDetails();//fetch the patient and admission details
					
					//get the summary info
					BillingUtils bill = new BillingUtils();
					bill.setPatientCaseSystemId(patientCaseSystemId);
					//below should be in order for the billing report
					bill.getLaboratoryExaminationDetails();
					bill.getMedicalSupplyDetails();
					bill.getRadiologyDetails();
					bill.getSurgeryDetails();
					bill.getAdditionalServicesDetails();
					bill.getEquipmentDetails();
					bill.computeRoomFee();
					bill.getOtherRoomDetails();
					bill.computeDoctorFee();
					bill.getOtherDoctorDetails();
					bill.computeTotalAmtFee();
					bill.getDiscountDetails();
					bill.computeTotalAmtDue();
					
					//set totals
					formBean.setTotalAmtLabExam(bill.getTotalAmtLabExam());
					formBean.setTotalAmtMedSupply(bill.getTotalAmtMedSupply());
					formBean.setTotalAmtRadiology(bill.getTotalAmtRadiology());
					formBean.setTotalAmtSurgery(bill.getTotalAmtSurgery());
					formBean.setTotalAmtAddServices(bill.getTotalAmtAddServices());
					formBean.setTotalAmtEquip(bill.getTotalAmtEquip());
					formBean.setTotalAmtRoom(bill.getTotalAmtRoom());
					formBean.setTotalAmtOtherRoom(bill.getTotalAmtOtherRoom());
					formBean.setTotalAmtDoctor(bill.getTotalAmtDoctor());
					formBean.setTotalAmtOtherDoctor(bill.getTotalAmtOtherDoctor());
					formBean.setTotalAmtFee(bill.getTotalAmtFee());
					formBean.setTotalAmtDiscount(bill.getTotalAmtDiscount());
					formBean.setTotalAmtDue(bill.getTotalAmtDue());
					formBean.setDaysAdmitted(bill.getDaysAdmitted());
					formBean.setRoomRate(bill.getRoomRate());
					formBean.setDoctorFee(bill.getDoctorFee());
					
					formBean.setTransactionStatus(false);
					formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESET);
					
					forwardAction = ActionConstant.SHOW_AJAX_GO_TO;
				}		
			} else {
				//show main screen
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	
	


}
