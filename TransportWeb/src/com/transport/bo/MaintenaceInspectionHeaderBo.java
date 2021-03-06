package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author edwarddavid
 * @since 23Mar2020
 * DateUpdated: 27Mar2020
 */
public interface MaintenaceInspectionHeaderBo {

	Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> deleteRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getActiveData() throws Exception;
	Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> restoreRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception;
}
