package com.pibs.dao;

import java.util.HashMap;
import java.util.Map;

public interface MonitorNurseryDao {

	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> delete(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> searchByPatientCaseSystemId(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> restore(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> searchForListReport(HashMap<String, Object> criteriaMap) throws Exception;
}
