package com.pibs.bo;

import java.util.HashMap;
import java.util.Map;

public interface ProfessionalTypeBo {
	
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> deleteRecord(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> getActiveData() throws Exception;

}
