package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author edwarddavid
 * @since 23Mar2020
 */
public interface MaintenaceInspectionDetailsBo {

	Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> deleteRecord(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
}
