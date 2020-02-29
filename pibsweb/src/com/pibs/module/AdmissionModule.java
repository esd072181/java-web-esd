package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.AdmissionBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

public class AdmissionModule implements PIBSModule {

	private final static Logger logger = Logger.getLogger(AdmissionModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			AdmissionBo bo = (AdmissionBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SAVE: returnMap = bo.addNewRecord(dataMap);
					break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
					break;
				case ActionConstant.SEARCHBY: returnMap = bo.getDataByCaseNo(dataMap);
					break;
				case ActionConstant.GET_DATA_BY_PATIENT_CASE_SYS_ID: returnMap = bo.getDataByPatientCaseSysId(dataMap);
					break;
				case ActionConstant.GET_DATA_BY_BILLING_ID: returnMap = bo.getDataByBillingId(dataMap);
					break;
				case ActionConstant.UPDATE_TO_DISCHARGED: returnMap = bo.updateToDischarged(dataMap);
					break;
				case ActionConstant.GET_DATA_BY_PATIENT_CASE_SYS_ID_FOR_BILLING_REPORT: returnMap = bo.getDataByPatientCaseSysIdForBillingReport(dataMap);
					break;
				default: break;
			};	
		}catch (Exception e) {
			PIBSUtils.writeLogInfo(logger, e.getMessage());
			e.printStackTrace();
		} finally {
			
		}

		return returnMap;
	}


}
