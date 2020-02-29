package com.pibs.dao;

import java.util.HashMap;
import java.util.Map;

public interface BillingDao {

	Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getDataByPatientCaseSystemId(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> updateToCleared(HashMap<String, Object> criteriaMap) throws Exception;
}
