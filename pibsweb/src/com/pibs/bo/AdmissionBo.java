package com.pibs.bo;

import java.util.HashMap;
import java.util.Map;

public interface AdmissionBo {

	Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataByCaseNo(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataByPatientCaseSysId(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataByBillingId(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> updateToDischarged(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataByPatientCaseSysIdForBillingReport(HashMap<String, Object> criteriaMap) throws Exception;
}
