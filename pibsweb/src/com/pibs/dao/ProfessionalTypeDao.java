package com.pibs.dao;

import java.util.HashMap;
import java.util.Map;

public interface ProfessionalTypeDao {

	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception;
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	public Map<String, Object> getActiveData() throws Exception;
	public Map<String, Object> getProfessionalTypeId(HashMap<String, Object> criteriaMap) throws Exception;

}
