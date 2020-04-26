package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 20Aug2016
 *
 */
public interface TireBo {

	Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> deleteRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getActiveData() throws Exception;
	Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> restoreRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getTireDetails(HashMap<String, Object> dataMap) throws Exception;
}
