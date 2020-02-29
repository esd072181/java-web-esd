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
import com.pibs.form.BillingDetailsFormBean;
import com.pibs.model.Billing;
import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.BillingUtils;


public class BillingDetailsAction extends Action {
	
	private final static Logger logger = Logger.getLogger(BillingDetailsAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		BillingDetailsFormBean formBean = (BillingDetailsFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");

		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
//				int module = ModuleConstant.BILLING_DETAILS;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_GO_TO_CHILD)) {		
					//fetch the data
					
					int patientCaseSystemId = Integer.parseInt(request.getParameter("patientCaseSystemId"));
					formBean.setPatientCaseSystemId(patientCaseSystemId);
					
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

					//set the list/details
					formBean.setLabExamList(bill.getLabExamList());
					formBean.setMedSupplyList(bill.getMedSupplyList());
					formBean.setRadiologyList(bill.getRadiologyList());
					formBean.setSurgeryList(bill.getSurgeryList());
					formBean.setAdditionalServicesList(bill.getAdditionalServicesList());
					formBean.setEquipmentList(bill.getEquipmentList());
					formBean.setOtherRoomList(bill.getOtherRoomList());
					formBean.setOtherDoctorList(bill.getOtherDoctorList());
					formBean.setDiscountList(bill.getDiscountList());
					
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
					
					//check first if record exists in Patient bill table
					Billing modelCheck = new Billing();
					modelCheck.setPatientCaseSystemid(patientCaseSystemId);
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
			        dataMap.put(MapConstant.MODULE, ModuleConstant.BILLING);
			        dataMap.put(MapConstant.CLASS_DATA, modelCheck);
			        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
				
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	Billing model = (Billing) resultMap.get(MapConstant.CLASS_DATA);
			        	User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
				        dataMap = null;
				        service = null;
				        resultMap = null;

		        		formBean.populateModelBilling(bill);//need to get the latest computation from BillingUtils
			        	if (model.getId()>0) {
			        		formBean.getModelBilling().setId(model.getId());//update the billing id for update
				        	//code here for update
							dataMap = new HashMap<String, Object>();
					        dataMap.put(MapConstant.MODULE, ModuleConstant.BILLING);
					        dataMap.put(MapConstant.CLASS_DATA, formBean.getModelBilling());
					        dataMap.put(MapConstant.USER_SESSION_DATA, user);
					        dataMap.put(MapConstant.ACTION, ActionConstant.UPDATE);
					        
					        service = new ServiceManagerImpl();
					        resultMap = service.executeRequest(dataMap);
					        
					        if (resultMap!=null && !resultMap.isEmpty()) {
					        	boolean transactionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);
					        	if (transactionStatus) {
						        	formBean.setTransactionStatus(transactionStatus);
						        	//need to update the formbean for Billing Id
						        	formBean.updateFormBeanForBillingId();
						        	logger.info("Patient Bill successfully updated (Patient case system ID): " + formBean.getPatientCaseSystemId());//Patient Case System Id
					        	}
					        }
			        	} else {
							//save totals to patient bill table
							dataMap = new HashMap<String, Object>();
					        dataMap.put(MapConstant.MODULE, ModuleConstant.BILLING);
					        dataMap.put(MapConstant.CLASS_DATA, formBean.getModelBilling());
					        dataMap.put(MapConstant.USER_SESSION_DATA, user);
					        dataMap.put(MapConstant.ACTION, ActionConstant.SAVE);
					        
					        service = new ServiceManagerImpl();
					        resultMap = service.executeRequest(dataMap);
					        
					        if (resultMap!=null && !resultMap.isEmpty()) {
					        	boolean transactionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);
					        	if (transactionStatus) {
						        	formBean.setTransactionStatus(transactionStatus);
						        	//need to update the formbean for Billing Id
						        	formBean.updateFormBeanForBillingId();
						        	logger.info("Patient Bill successfully saved (Patient case system ID): " + formBean.getPatientCaseSystemId());//Patient Case System Id
					        	}
					        }
				        
			        	}
			        	
			        	String caseNo = request.getParameter("caseNo");
			        	
			        	//generate pdf bill report
			        	bill.generateReport(request, caseNo);
			        	
			        } else {
			        	logger.info("Resultmap is empty...");
			        }
					

					forwardAction = ActionConstant.SHOW_AJAX_GO_TO_CHILD;
				} 

			} else {
				//show main screen
				 forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	
	


}
