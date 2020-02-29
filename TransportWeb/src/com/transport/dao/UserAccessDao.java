package com.transport.dao;

import java.util.HashMap;
import java.util.Map;

public interface UserAccessDao {

	Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataByUserId(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> isAccessExistsForUser(HashMap<String, Object> criteriaMap) throws Exception;
}
