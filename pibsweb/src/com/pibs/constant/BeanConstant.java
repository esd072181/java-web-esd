package com.pibs.constant;

/**
 * This file defines the names of Spring beans in Spring.xml
 * 
 * @author dward
 * @since 01Mar2015
 * LastDateUpdated: 23May2018
 *
 */
public class BeanConstant {

	//Security
	private static final String LoginBeanId = "loginBo";
	//Master Files
	private static final String BuildingBeanId = "buildingBo";//Building
	private static final String RoomCategoryBeanId = "roomCategoryBo";//Room Category
	private static final String RoomBeanId = "roomBo";//Room
	private static final String EquipmentBeanId = "equipmentBo";//Equipment
	private static final String SpecializationBeanId = "specializationBo";//Specialization
	private static final String AdditionalServicesBeanId = "additionalServicesBo";//Additional Services
	private static final String AdditionalServicesCategoryBeanId = "additionalServicesCategoryBo";//Additional Services Category
	private static final String RadiologyBeanId = "radiologyBo";//Radiology
	private static final String ListValueBeanId = "listValueBo";//List Value //LOV
	private static final String ListTypeBeanId = "listTypeBo";//List Value //LOV
	private static final String SurgeryBeanId = "surgeryBo";//Surgery
	private static final String LaboratoryExaminationBeanId = "laboratoryExaminationBo";//Laboratory Examination
	private static final String MedicalSupplyBeanId = "medicalSupplyBo";//Medical Supply
	private static final String ProfessionalTypeBeanId = "professionalTypeBo";//Professional Type
	private static final String ProfessionalBeanId = "professionalBo";//Professional
	private static final String DiscountBeanId = "discountBo";//Discount
	private static final String PatientBeanId = "patientBo";//Patient and Patient Registration
	private static final String EmployeeBeanId = "employeeBo";//Employee
	private static final String UserBeanId = "userBo";//User
	private static final String UserAccessBeanId = "userAccessBo";//User Access
	//Transaction
	private static final String AdmissionBeanId = "admissionBo";
	private static final String BillingBeanId = "billingBo";
	private static final String PatientInquiryBeanId = "patientInquiryBo";
	private static final String RoomInquiryBeanId = "roomInquiryBo";
	private static final String PatientHistoryBeanId = "patientHistoryBo";
	private static final String MedicalAbstractBeanId = "medicalAbstractBo";
	private static final String PatientBillHistoryBeanId = "patientBillHistoryBo";
	
	//Reports
	private static final String ReportBeanId = "reportBo";
	private static final String RptPatientBeanId = "rptPatientBo";
	private static final String RptMedicalSupplyBeanId = "rptMedicalSupplyBo";
	private static final String RptEquipmentBeanId = "rptEquipmentBo";
	private static final String RptLaboratoryExaminationBeanId = "rptLaboratoryExaminationBo";
	private static final String RptRadiologyBeanId = "rptRadiologyBo";
	private static final String RptSurgeryBeanId = "rptSurgeryBo";
	private static final String RptAdditionalServicesBeanId = "rptAdditionalServicesBo";
	private static final String RptDiscountBeanId = "rptDiscountBo";
	private static final String RptProfessionalBeanId = "rptProfessionalBo";
	private static final String RptRoomBeanId = "rptRoomBo";
	private static final String RptEmployeeBeanId = "rptEmployeeBo";
	private static final String RptNurseryBeanId = "rptNurseryBo";
	private static final String RptPatientHistoryBeanId = "rptPatientHistoryBo";
	
	//Child bean for MonitorPatient
	private static final String DiagnosisBeanId = "diagnosisBo";
	private static final String MedicationStatementBeanId = "medicationStatementBo";
	private static final String PrognosisBeanId = "prognosisBo";
	private static final String MonitorLaboratoryExaminationBeanId = "monitorLaboratoryExaminationBo";
	private static final String MonitorMedicalSupplyBeanId = "monitorMedicalSupplyBo";
	private static final String MonitorRadiologyBeanId = "monitorRadiologyBo";
	private static final String MonitorSurgeryBeanId = "monitorSurgeryBo";
	private static final String MonitorAdditionalServicesBeanId = "monitorAdditionalServicesBo";
	private static final String MonitorEquipmentBeanId = "monitorEquipmentBo";
	private static final String MonitorPhysicalExaminationBeanId = "monitorPhysicalExaminationBo";
	private static final String MonitorDoctorBeanId = "monitorDoctorBo";
	private static final String MonitorRoomBeanId = "monitorRoomBo";
	private static final String MonitorRoomTransferBeanId = "monitorRoomTransferBo";
	private static final String MonitorNurseryBeanId = "monitorNurseryBo";
	
	//Child bean for Billing
	private static final String BillingDiscountBeanId = "billingDiscountBo";
	private static final String BillingDetailsBeanId = "billingDetailsBo";
	private static final String BillingPaymentBeanId = "billingPaymentBo";
	
	
	
	public static String getBeanId(int module) {
		String beanId=null;
		switch(module) {
			case ModuleConstant.LOGIN: beanId = LoginBeanId;
			  break;
			case ModuleConstant.BUILDING: beanId = BuildingBeanId;
			  break;
			case ModuleConstant.ROOM_CATEGORY: beanId = RoomCategoryBeanId;
			  break;
			case ModuleConstant.ROOM: beanId = RoomBeanId;
			  break;
			case ModuleConstant.EQUIPMENT: beanId = EquipmentBeanId;
			  break;
			case ModuleConstant.SPECIALIZATION: beanId = SpecializationBeanId;
			  break;
			case ModuleConstant.ADDITIONAL_SERVICES: beanId = AdditionalServicesBeanId;
			  break;
			case ModuleConstant.ADDITIONAL_SERVICES_CATEGORY: beanId = AdditionalServicesCategoryBeanId;
			  break;
			case ModuleConstant.RADIOLOGY: beanId = RadiologyBeanId;
			  break;
			case ModuleConstant.LIST_VALUE: beanId = ListValueBeanId;
			  break;
			case ModuleConstant.LIST_TYPE: beanId = ListTypeBeanId;
			  break;
			case ModuleConstant.SURGERY: beanId = SurgeryBeanId;
			  break;
			case ModuleConstant.MEDICAL_SUPPLY: beanId = MedicalSupplyBeanId;
			  break;
			case ModuleConstant.LABORATORY_EXAMINATION: beanId = LaboratoryExaminationBeanId;
			  break;
			case ModuleConstant.PROFESSIONAL_TYPE: beanId = ProfessionalTypeBeanId;
			  break;
			case ModuleConstant.PROFESSIONAL: beanId = ProfessionalBeanId;
			  break;
			case ModuleConstant.DISCOUNT: beanId = DiscountBeanId;
			  break;
			case ModuleConstant.PATIENT: beanId = PatientBeanId;
			  break;
			case ModuleConstant.ADMISSION: beanId = AdmissionBeanId;
			  break;
			case ModuleConstant.DIAGNOSIS: beanId = DiagnosisBeanId;
			  break;
			case ModuleConstant.MEDICATION_STATEMENT: beanId = MedicationStatementBeanId;
			  break;
			case ModuleConstant.PROGNOSIS: beanId = PrognosisBeanId;
			  break;
			case ModuleConstant.MONITOR_LABORATORY_EXAMINATION: beanId = MonitorLaboratoryExaminationBeanId;
			  break;
			case ModuleConstant.MONITOR_MEDICAL_SUPPLY: beanId = MonitorMedicalSupplyBeanId;
			  break;
			case ModuleConstant.MONITOR_RADIOLOGY: beanId = MonitorRadiologyBeanId;
			  break;
			case ModuleConstant.MONITOR_SURGERY: beanId = MonitorSurgeryBeanId;
			  break;
			case ModuleConstant.MONITOR_ADDITIONAL_SERVICES: beanId = MonitorAdditionalServicesBeanId;
			  break;
			case ModuleConstant.MONITOR_EQUIPMENT: beanId = MonitorEquipmentBeanId;
			  break;
			case ModuleConstant.MONITOR_PHYSICAL_EXAMINATION: beanId = MonitorPhysicalExaminationBeanId;
			  break;
			case ModuleConstant.MONITOR_DOCTOR: beanId = MonitorDoctorBeanId;
			  break;
			case ModuleConstant.MONITOR_ROOM: beanId = MonitorRoomBeanId;
			  break;
			case ModuleConstant.MONITOR_ROOM_TRANSFER: beanId = MonitorRoomTransferBeanId;
			  break;
			case ModuleConstant.MONITOR_NURSERY: beanId = MonitorNurseryBeanId;
			  break;
			case ModuleConstant.BILLING: beanId = BillingBeanId;
			  break;
			case ModuleConstant.BILLING_DISCOUNT: beanId = BillingDiscountBeanId;
			  break;
			case ModuleConstant.BILLING_DETAILS: beanId = BillingDetailsBeanId;
			  break;
			case ModuleConstant.BILLING_PAYMENT: beanId = BillingPaymentBeanId;
			  break;
			case ModuleConstant.EMPLOYEE: beanId = EmployeeBeanId;
			  break;
			case ModuleConstant.USER: beanId = UserBeanId;
			  break;
			case ModuleConstant.USER_ACCESS: beanId = UserAccessBeanId;
			  break;
			case ModuleConstant.PATIENT_INQUIRY: beanId = PatientInquiryBeanId;
			  break;
			case ModuleConstant.ROOM_INQUIRY: beanId = RoomInquiryBeanId;
			  break;
			case ModuleConstant.PATIENT_HISTORY: beanId = PatientHistoryBeanId;
			  break;
			case ModuleConstant.MEDICAL_ABSTRACT: beanId = MedicalAbstractBeanId;
			  break;
			case ModuleConstant.NURSERY_INQUIRY: beanId = MonitorNurseryBeanId; //re-use the MonitorNurseryBeanId
			  break;
			case ModuleConstant.PATIENT_BILL_HISTORY: beanId = PatientBillHistoryBeanId;
			  break;
			case ModuleConstant.REPORT: beanId = ReportBeanId;
			  break;
			case ModuleConstant.PATIENT_LIST_REPORT: beanId = RptPatientBeanId;
			  break;
			case ModuleConstant.MEDICAL_SUPPLY_LIST_REPORT: beanId = RptMedicalSupplyBeanId;
			  break;
			case ModuleConstant.EQUIPMENT_LIST_REPORT: beanId = RptEquipmentBeanId;
			  break;
			case ModuleConstant.LABORATORY_EXAMINATION_LIST_REPORT: beanId = RptLaboratoryExaminationBeanId;
			  break;
			case ModuleConstant.RADIOLOGY_LIST_REPORT: beanId = RptRadiologyBeanId;
			  break;
			case ModuleConstant.SURGERY_LIST_REPORT: beanId = RptSurgeryBeanId;
			  break;
			case ModuleConstant.ADDITIONAL_SERVICES_LIST_REPORT: beanId = RptAdditionalServicesBeanId;
			  break;
			case ModuleConstant.DISCOUNT_LIST_REPORT: beanId = RptDiscountBeanId;
			  break;
			case ModuleConstant.PROFESSIONAL_LIST_REPORT: beanId = RptProfessionalBeanId;
			  break;
			case ModuleConstant.ROOM_LIST_REPORT: beanId = RptRoomBeanId;
			  break;
			case ModuleConstant.EMPLOYEE_LIST_REPORT: beanId = RptEmployeeBeanId;
			  break;
			case ModuleConstant.NURSERY_LIST_REPORT: beanId = RptNurseryBeanId;
			  break;
			case ModuleConstant.PATIENT_HISTORY_REPORT: beanId = RptPatientHistoryBeanId;
			  break;
			default: break;
		} 
		return beanId;
	}
	
}
