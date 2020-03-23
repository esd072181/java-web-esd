package com.transport.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author edwarddavid
 * @since 23Mar2020
 */
public interface MaintenanceInspectionDetailsDao {

	Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
}
