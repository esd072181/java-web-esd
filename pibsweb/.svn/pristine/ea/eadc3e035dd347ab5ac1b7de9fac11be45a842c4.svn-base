package com.pibs.bo;

import java.util.HashMap;
import java.util.Map;

public interface PatientBo {
	
	 Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception;
	 Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception;
	 Map<String, Object> deleteRecord(HashMap<String, Object> dataMap) throws Exception;
	 Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception;
	 Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	 Map<String, Object> getActiveData() throws Exception;
	 Map<String, Object> getRecordsForAdmission(HashMap<String, Object> criteriaMap) throws Exception;
	 Map<String, Object> getAdmittedRecords(HashMap<String, Object> criteriaMap) throws Exception;
	 Map<String, Object> updateToAdmitted(HashMap<String, Object> dataMap) throws Exception;
	 Map<String, Object> updateToActive(HashMap<String, Object> dataMap) throws Exception;
	 Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception;
	 Map<String, Object> restoreRecord(HashMap<String, Object> dataMap) throws Exception;
}
