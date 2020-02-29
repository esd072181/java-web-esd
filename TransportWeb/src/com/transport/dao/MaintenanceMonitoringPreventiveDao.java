package com.transport.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 25April2019
 * Date Updated: 25April2019
 */
public interface MaintenanceMonitoringPreventiveDao {
	
	Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getActiveData(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
}
