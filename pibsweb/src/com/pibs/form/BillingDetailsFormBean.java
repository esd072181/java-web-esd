package com.pibs.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.model.Billing;
import com.pibs.model.BillingDiscount;
import com.pibs.model.BillingReport;
import com.pibs.model.MonitorAdditionalServices;
import com.pibs.model.MonitorDoctor;
import com.pibs.model.MonitorEquipment;
import com.pibs.model.MonitorLaboratoryExamination;
import com.pibs.model.MonitorMedicalSupply;
import com.pibs.model.MonitorRadiology;
import com.pibs.model.MonitorRoom;
import com.pibs.model.MonitorSurgery;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.BillingUtils;
import com.pibs.util.PIBSUtils;

public class BillingDetailsFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	
	private int patientCaseSystemId;
	private String caseNo;
	private int billingId; //id in Patient Bill table
	//model list
	private List<MonitorLaboratoryExamination> labExamList;
	private List<MonitorMedicalSupply> medSupplyList;
	private List<MonitorRadiology> radiologyList;
	private List<MonitorSurgery> surgeryList;
	private List<MonitorAdditionalServices> additionalServicesList;
	private List<MonitorEquipment> equipmentList;
	private List<MonitorDoctor> otherDoctorList;
	private List<MonitorRoom> otherRoomList;
	private List<BillingDiscount> discountList;
	
	//total
	private String totalAmtLabExam;
	private String totalAmtMedSupply;
	private String totalAmtRadiology;
	private String totalAmtSurgery;
	private String totalAmtAddServices;
	private String totalAmtEquip;
	private String totalAmtOtherDoctor;
	private String totalAmtOtherRoom;
	private String totalAmtDiscount;
	private String totalAmtRoom;
	private String totalAmtDoctor;
	private String totalAmtFee;
	private String totalAmtDue;
	
	//room and doctor details
	private String daysAdmitted;
	private String roomRate;
	private String doctorFee;
	
	private List<Double> totalList = new ArrayList<>();
	private List<Double> deductList = new ArrayList<>();
	
	private Billing modelBilling;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	//report
	List<BillingReport> billingReportList = new ArrayList<>();
	
	public BillingDetailsFormBean() {}

	
	
	
	public boolean isTransactionStatus() {
		return transactionStatus;
	}




	public void setTransactionStatus(boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}




	public String getTransactionMessage() {
		return transactionMessage;
	}




	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}




	public int getBillingId() {
		return billingId;
	}




	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}




	public Billing getModelBilling() {
		return modelBilling;
	}




	public void setModelBilling(Billing modelBilling) {
		this.modelBilling = modelBilling;
	}




	public String getTotalAmtFee() {
		return totalAmtFee;
	}




	public void setTotalAmtFee(String totalAmtFee) {
		this.totalAmtFee = totalAmtFee;
	}




	public String getTotalAmtDue() {
		return totalAmtDue;
	}




	public void setTotalAmtDue(String totalAmtDue) {
		this.totalAmtDue = totalAmtDue;
	}




	public List<Double> getTotalList() {
		return totalList;
	}




	public void setTotalList(List<Double> totalList) {
		this.totalList = totalList;
	}




	public List<Double> getDeductList() {
		return deductList;
	}




	public void setDeductList(List<Double> deductList) {
		this.deductList = deductList;
	}




	public String getDaysAdmitted() {
		return daysAdmitted;
	}




	public void setDaysAdmitted(String daysAdmitted) {
		this.daysAdmitted = daysAdmitted;
	}




	public String getRoomRate() {
		return roomRate;
	}




	public void setRoomRate(String roomRate) {
		this.roomRate = roomRate;
	}




	public String getDoctorFee() {
		return doctorFee;
	}




	public void setDoctorFee(String doctorFee) {
		this.doctorFee = doctorFee;
	}




	public String getTotalAmtLabExam() {
		return totalAmtLabExam;
	}




	public String getTotalAmtRoom() {
		return totalAmtRoom;
	}


	public void setTotalAmtRoom(String totalAmtRoom) {
		this.totalAmtRoom = totalAmtRoom;
	}


	public String getTotalAmtDoctor() {
		return totalAmtDoctor;
	}


	public void setTotalAmtDoctor(String totalAmtDoctor) {
		this.totalAmtDoctor = totalAmtDoctor;
	}


	public void setTotalAmtLabExam(String totalAmtLabExam) {
		this.totalAmtLabExam = totalAmtLabExam;
	}




	public List<BillingDiscount> getDiscountList() {
		return discountList;
	}




	public void setDiscountList(List<BillingDiscount> discountList) {
		this.discountList = discountList;
	}




	public String getTotalAmtDiscount() {
		return totalAmtDiscount;
	}




	public void setTotalAmtDiscount(String totalAmtDiscount) {
		this.totalAmtDiscount = totalAmtDiscount;
	}

	
	public int getPatientCaseSystemId() {
		return patientCaseSystemId;
	}




	public void setPatientCaseSystemId(int patientCaseSystemId) {
		this.patientCaseSystemId = patientCaseSystemId;
	}




	public List<MonitorLaboratoryExamination> getLabExamList() {
		return labExamList;
	}




	public void setLabExamList(List<MonitorLaboratoryExamination> labExamList) {
		this.labExamList = labExamList;
	}




	public List<MonitorMedicalSupply> getMedSupplyList() {
		return medSupplyList;
	}




	public void setMedSupplyList(List<MonitorMedicalSupply> medSupplyList) {
		this.medSupplyList = medSupplyList;
	}




	public List<MonitorRadiology> getRadiologyList() {
		return radiologyList;
	}




	public void setRadiologyList(List<MonitorRadiology> radiologyList) {
		this.radiologyList = radiologyList;
	}




	public List<MonitorSurgery> getSurgeryList() {
		return surgeryList;
	}




	public void setSurgeryList(List<MonitorSurgery> surgeryList) {
		this.surgeryList = surgeryList;
	}




	public List<MonitorAdditionalServices> getAdditionalServicesList() {
		return additionalServicesList;
	}




	public void setAdditionalServicesList(
			List<MonitorAdditionalServices> additionalServicesList) {
		this.additionalServicesList = additionalServicesList;
	}




	public List<MonitorEquipment> getEquipmentList() {
		return equipmentList;
	}




	public void setEquipmentList(List<MonitorEquipment> equipmentList) {
		this.equipmentList = equipmentList;
	}	
	

	
	public String getTotalAmtMedSupply() {
		return totalAmtMedSupply;
	}




	public void setTotalAmtMedSupply(String totalAmtMedSupply) {
		this.totalAmtMedSupply = totalAmtMedSupply;
	}




	public String getTotalAmtRadiology() {
		return totalAmtRadiology;
	}




	public void setTotalAmtRadiology(String totalAmtRadiology) {
		this.totalAmtRadiology = totalAmtRadiology;
	}




	public String getTotalAmtSurgery() {
		return totalAmtSurgery;
	}




	public void setTotalAmtSurgery(String totalAmtSurgery) {
		this.totalAmtSurgery = totalAmtSurgery;
	}




	public String getTotalAmtAddServices() {
		return totalAmtAddServices;
	}




	public void setTotalAmtAddServices(String totalAmtAddServices) {
		this.totalAmtAddServices = totalAmtAddServices;
	}




	public String getTotalAmtEquip() {
		return totalAmtEquip;
	}




	public void setTotalAmtEquip(String totalAmtEquip) {
		this.totalAmtEquip = totalAmtEquip;
	}



	public String getCaseNo() {
		return caseNo;
	}




	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}


	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();

		return errors;
	}

	public void populateModelBilling (BillingUtils bill) throws Exception {
		Billing model = new Billing();
		model.setPatientCaseSystemid(bill.getPatientCaseSystemId());
		if (bill.getTotalAmtLabExam()!=null) {
			model.setTotalLaboratoryExamFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtLabExam())));		
		}
		if (bill.getTotalAmtMedSupply()!=null) {
			model.setTotalMedsupplyFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtMedSupply())));
		}
		if (bill.getTotalAmtRadiology()!=null) {
			model.setTotalRadiologyFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtRadiology())));
		}
		if (bill.getTotalAmtSurgery()!=null) {
			model.setTotalSurgeryFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtSurgery())));
		}
		if (bill.getTotalAmtAddServices()!=null) {
			model.setTotalAdditionalServicesFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtAddServices())));
		}
		if (bill.getTotalAmtEquip()!=null) {
			model.setTotalEquipmentFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtEquip())));
		}
		if (bill.getTotalAmtRoom()!=null) {
			model.setTotalRoomFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtRoom())));		
		}
		if (bill.getTotalAmtDoctor()!=null) {
			model.setTotalDoctorFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtDoctor())));
		}
		if (bill.getTotalAmtFee()!=null) {
			model.setTotalFee(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtFee())));
		}
		if (bill.getTotalAmtDiscount()!=null) {
			model.setTotalDiscountAmt(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtDiscount().replace(")", ""))));
		}
		//pending total tax amount
		if (bill.getTotalAmtDue()!=null) {
			model.setTotalBill(BigDecimal.valueOf(PIBSUtils.convertStrToDouble(bill.getTotalAmtDue())));
		}
		setModelBilling(model);
	}
	
	public void updateFormBeanForBillingId () throws Exception {
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.BILLING);
        dataMap.put(MapConstant.CLASS_DATA, getModelBilling());
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
	
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
        	Billing modelUpdated = (Billing) resultMap.get(MapConstant.CLASS_DATA);
        	if (modelUpdated.getId()>0) {
	        	populateFormBeanBilling(modelUpdated);
        	}
        }
	}
	
	public void populateFormBeanBilling (Billing model) throws Exception {
		setBillingId(model.getId()); //id in patient bill table
		setPatientCaseSystemId(model.getPatientCaseSystemid());
		setCaseNo(model.getCaseNo());
		if (model.getTotalLaboratoryExamFee()!=null) {
			setTotalAmtLabExam(PIBSUtils.convertDoubleToStr(model.getTotalLaboratoryExamFee().doubleValue()));
		}
		if (model.getTotalMedsupplyFee()!=null) {
			setTotalAmtMedSupply(PIBSUtils.convertDoubleToStr(model.getTotalMedsupplyFee().doubleValue()));
		}
		if (model.getTotalRadiologyFee()!=null) {
			setTotalAmtRadiology(PIBSUtils.convertDoubleToStr(model.getTotalRadiologyFee().doubleValue()));
		}
		if (model.getTotalSurgeryFee()!=null) {
			setTotalAmtSurgery(PIBSUtils.convertDoubleToStr(model.getTotalSurgeryFee().doubleValue()));
		}
		if (model.getTotalAdditionalServicesFee()!=null) {
			setTotalAmtAddServices(PIBSUtils.convertDoubleToStr(model.getTotalAdditionalServicesFee().doubleValue()));
		}
		if (model.getTotalRoomFee()!=null) {
			setTotalAmtRoom(PIBSUtils.convertDoubleToStr(model.getTotalRoomFee().doubleValue()));
		}
		if (model.getTotalDoctorFee()!=null) {
			setTotalAmtDoctor(PIBSUtils.convertDoubleToStr(model.getTotalDoctorFee().doubleValue()));
		}
		if (model.getTotalFee()!=null) {
			setTotalAmtFee(PIBSUtils.convertDoubleToStr(model.getTotalFee().doubleValue()));
		}
		if (model.getTotalDiscountAmt()!=null) {
			setTotalAmtDiscount(PIBSUtils.convertDoubleToStr(model.getTotalDiscountAmt().doubleValue()));
		}
		//pending total tax amount
		if (model.getTotalBill()!=null) {
			setTotalAmtDue(PIBSUtils.convertDoubleToStr(model.getTotalBill().doubleValue()));
		}
		
	}
	
	public List<MonitorDoctor> getOtherDoctorList() {
		return otherDoctorList;
	}




	public void setOtherDoctorList(List<MonitorDoctor> otherDoctorList) {
		this.otherDoctorList = otherDoctorList;
	}




	public String getTotalAmtOtherDoctor() {
		return totalAmtOtherDoctor;
	}




	public void setTotalAmtOtherDoctor(String totalAmtOtherDoctor) {
		this.totalAmtOtherDoctor = totalAmtOtherDoctor;
	}




	public List<MonitorRoom> getOtherRoomList() {
		return otherRoomList;
	}




	public void setOtherRoomList(List<MonitorRoom> otherRoomList) {
		this.otherRoomList = otherRoomList;
	}




	public String getTotalAmtOtherRoom() {
		return totalAmtOtherRoom;
	}




	public void setTotalAmtOtherRoom(String totalAmtOtherRoom) {
		this.totalAmtOtherRoom = totalAmtOtherRoom;
	}

}
