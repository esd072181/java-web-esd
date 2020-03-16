package com.transport.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 25Mar2019
 * Date Updated: 16Mar2020
 */
public interface MaintenanceMonitoringDao {
	
	Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getActiveData(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	List<Integer> getMaintenanceCategoryData(HashMap<String, Object> criteriaMap) throws Exception;
}
