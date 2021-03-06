package com.transport.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 20Apr2020
 */
public interface TireDao {

	Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getActiveData() throws Exception;
	Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> updateRecapNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> updateAnalysisComments(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> restore(HashMap<String, Object> dataMap) throws Exception;
	Boolean updateLorryNoBySerialNo(HashMap<String, Object> dataMap) throws Exception;
	Boolean updateRetiredBySerialNo(HashMap<String, Object> dataMap) throws Exception;
	Map<String, Object> getTireStatusSummary(HashMap<String, Object> criteriaMap) throws Exception;
	
}
