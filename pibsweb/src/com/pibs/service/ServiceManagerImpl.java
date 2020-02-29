package com.pibs.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.config.SpringConfig;
import com.pibs.constant.BeanConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.module.AdditionalServicesCategoryModule;
import com.pibs.module.AdditionalServicesModule;
import com.pibs.module.AdmissionModule;
import com.pibs.module.BillingDetailsModule;
import com.pibs.module.BillingDiscountModule;
import com.pibs.module.BillingModule;
import com.pibs.module.BillingPaymentModule;
import com.pibs.module.BuildingModule;
import com.pibs.module.DiagnosisModule;
import com.pibs.module.DiscountModule;
import com.pibs.module.EmployeeModule;
import com.pibs.module.EquipmentModule;
import com.pibs.module.LaboratoryExaminationModule;
import com.pibs.module.ListTypeModule;
import com.pibs.module.ListValueModule;
import com.pibs.module.LoginModule;
import com.pibs.module.MedicalAbstractModule;
import com.pibs.module.MedicalSupplyModule;
import com.pibs.module.MedicationStatementModule;
import com.pibs.module.MonitorAdditionalServicesModule;
import com.pibs.module.MonitorDoctorModule;
import com.pibs.module.MonitorEquipmentModule;
import com.pibs.module.MonitorLaboratoryExaminationModule;
import com.pibs.module.MonitorMedicalSupplyModule;
import com.pibs.module.MonitorNurseryModule;
import com.pibs.module.MonitorPhysicalExaminationModule;
import com.pibs.module.MonitorRadiologyModule;
import com.pibs.module.MonitorRoomModule;
import com.pibs.module.MonitorRoomTransferModule;
import com.pibs.module.MonitorSurgeryModule;
import com.pibs.module.NurseryModule;
import com.pibs.module.PIBSModule;
import com.pibs.module.PatientBillHistoryModule;
import com.pibs.module.PatientHistoryModule;
import com.pibs.module.PatientInquiryModule;
import com.pibs.module.PatientModule;
import com.pibs.module.ProfessionalModule;
import com.pibs.module.ProfessionalTypeModule;
import com.pibs.module.PrognosisModule;
import com.pibs.module.ReportModule;
import com.pibs.module.RoomCategoryModule;
import com.pibs.module.RoomInquiryModule;
import com.pibs.module.RoomModule;
import com.pibs.module.RptAdditionalServicesModule;
import com.pibs.module.RptDiscountModule;
import com.pibs.module.RptEmployeeModule;
import com.pibs.module.RptEquipmentModule;
import com.pibs.module.RptLaboratoryExaminationModule;
import com.pibs.module.RptMedicalSupplyModule;
import com.pibs.module.RptNurseryModule;
import com.pibs.module.RptPatientHistoryModule;
import com.pibs.module.RptPatientModule;
import com.pibs.module.RptProfessionalModule;
import com.pibs.module.RptRadiologyModule;
import com.pibs.module.RptRoomModule;
import com.pibs.module.RptSurgeryModule;
import com.pibs.module.SpecializationModule;
import com.pibs.module.RadiologyModule;
import com.pibs.module.SurgeryModule;
import com.pibs.module.UserAccessModule;
import com.pibs.module.UserModule;
import com.pibs.util.PIBSUtils;

public class ServiceManagerImpl implements ServiceManager {
	
	private final static Logger logger = Logger.getLogger(ServiceManagerImpl.class);
	
	public Map<String, Object> executeRequest(HashMap<String,Object> dataMap) throws Exception{
		
		PIBSModule module = null;
		Object bo = null;
		int moduleId = 0;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			moduleId = (int) dataMap.get(MapConstant.MODULE);
			
			bo = SpringConfig.getSpringXMLConfig().getBean(BeanConstant.getBeanId(moduleId));
			
			dataMap.put(MapConstant.BEAN, bo); //put object bean into dataMap
			
			switch(moduleId) {

				case ModuleConstant.LOGIN : 
					module = new LoginModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.BUILDING :
					module = new BuildingModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.ROOM_CATEGORY :
					module = new RoomCategoryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.ROOM :
					module = new RoomModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.EQUIPMENT :
					module = new EquipmentModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.SPECIALIZATION :
					module = new SpecializationModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.ADDITIONAL_SERVICES :
					module = new AdditionalServicesModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.ADDITIONAL_SERVICES_CATEGORY :
					module = new AdditionalServicesCategoryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.RADIOLOGY :
					module = new RadiologyModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.LABORATORY_EXAMINATION :
					module = new LaboratoryExaminationModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MEDICAL_SUPPLY:
					module = new MedicalSupplyModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PROFESSIONAL_TYPE:
					module = new ProfessionalTypeModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.SURGERY:
					module = new SurgeryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PROFESSIONAL:
					module = new ProfessionalModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.LIST_VALUE :
					module = new ListValueModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.LIST_TYPE :
					module = new ListTypeModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.DISCOUNT:
					module = new DiscountModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PATIENT:
					module = new PatientModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.ADMISSION:
					module = new AdmissionModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.DIAGNOSIS:
					module = new DiagnosisModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MEDICATION_STATEMENT:
					module = new MedicationStatementModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PROGNOSIS:
					module = new PrognosisModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_LABORATORY_EXAMINATION:
					module = new MonitorLaboratoryExaminationModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_MEDICAL_SUPPLY:
					module = new MonitorMedicalSupplyModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_RADIOLOGY:
					module = new MonitorRadiologyModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_SURGERY:
					module = new MonitorSurgeryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_ADDITIONAL_SERVICES:
					module = new MonitorAdditionalServicesModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_EQUIPMENT:
					module = new MonitorEquipmentModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_PHYSICAL_EXAMINATION:
					module = new MonitorPhysicalExaminationModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.BILLING:
					module = new BillingModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.BILLING_DISCOUNT:
					module = new BillingDiscountModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.BILLING_DETAILS:
					module = new BillingDetailsModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.BILLING_PAYMENT:
					module = new BillingPaymentModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.EMPLOYEE :
					module = new EmployeeModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.USER :
					module = new UserModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.USER_ACCESS :
					module = new UserAccessModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_DOCTOR:
					module = new MonitorDoctorModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_ROOM:
					module = new MonitorRoomModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_ROOM_TRANSFER:
					module = new MonitorRoomTransferModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MONITOR_NURSERY:
					module = new MonitorNurseryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PATIENT_INQUIRY:
					module = new PatientInquiryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.ROOM_INQUIRY:
					module = new RoomInquiryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PATIENT_HISTORY:
					module = new PatientHistoryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MEDICAL_ABSTRACT:
					module = new MedicalAbstractModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.NURSERY_INQUIRY:
					module = new NurseryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PATIENT_BILL_HISTORY:
					module = new PatientBillHistoryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.REPORT:
					module = new ReportModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PATIENT_LIST_REPORT:
					module = new RptPatientModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.MEDICAL_SUPPLY_LIST_REPORT:
					module = new RptMedicalSupplyModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.EQUIPMENT_LIST_REPORT:
					module = new RptEquipmentModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.LABORATORY_EXAMINATION_LIST_REPORT:
					module = new RptLaboratoryExaminationModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.RADIOLOGY_LIST_REPORT:
					module = new RptRadiologyModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.SURGERY_LIST_REPORT:
					module = new RptSurgeryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.ADDITIONAL_SERVICES_LIST_REPORT:
					module = new RptAdditionalServicesModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.DISCOUNT_LIST_REPORT:
					module = new RptDiscountModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PROFESSIONAL_LIST_REPORT:
					module = new RptProfessionalModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.ROOM_LIST_REPORT:
					module = new RptRoomModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.EMPLOYEE_LIST_REPORT:
					module = new RptEmployeeModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.NURSERY_LIST_REPORT:
					module = new RptNurseryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				case ModuleConstant.PATIENT_HISTORY_REPORT:
					module = new RptPatientHistoryModule();
					returnMap = module.executeRequest(dataMap);
					break;
				default: 
					PIBSUtils.writeLogInfo(logger, "This module ("+module+") is not configured for service!");
					break;
			}
									
		} catch (Exception e) {
			PIBSUtils.writeLogInfo(logger, e.getMessage());
		} finally {
			if (module!=null) {
				module = null;	
			}
		}
		return returnMap;
	}
	
}
