package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 26Apr2020
 *
 */
public interface TireManagementBo {

	Map<String, Object> assignTire(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> removeTire(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> editTire(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getTireDetailsByLorryNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getTireDetailsBySerialNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getLatestOdometerBySerialNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getLorryHistory(HashMap<String, Object> dataMap) throws Exception;
}
