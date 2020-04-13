package com.transport.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 12Apr2020
 */
public interface TireManagementDao {

	Map<String, Object> saveTireDetails(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> searchTireDetailsByLorryNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> searchLatestRecordBySerialNo(HashMap<String, Object> dataMap) throws Exception;
}
