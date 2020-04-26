package com.transport.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 26Apr2020
 */
public interface TireManagementDao {

	Map<String, Object> saveTireDetails(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> updateTireDetails(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> updateTireDetailsRemove(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> searchTireDetailsByLorryNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> searchTireDetailsBySerialNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> searchLatestRecordBySerialNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getLatestOdometerBySerialNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getLorryHistory(HashMap<String, Object> dataMap) throws Exception;
}
