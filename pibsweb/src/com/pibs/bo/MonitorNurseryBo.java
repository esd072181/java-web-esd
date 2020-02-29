package com.pibs.bo;

import java.util.HashMap;
import java.util.Map;

public interface MonitorNurseryBo {
	
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> delete(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> searchByPatientCaseSystemId(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> restoreRecord(HashMap<String, Object> criteriaMap) throws Exception;
}
