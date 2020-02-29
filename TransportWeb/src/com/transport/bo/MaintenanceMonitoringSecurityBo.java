package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 21Oct2019
 */
public interface MaintenanceMonitoringSecurityBo {
	
	Map<String, Object> add(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getDataByCriteria(HashMap<String, Object> criteriaMap) throws Exception;
}
