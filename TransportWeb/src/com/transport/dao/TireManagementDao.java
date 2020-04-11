package com.transport.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 10Apr2020
 */
public interface TireManagementDao {

	Map<String, Object> searchTireDetailsByLorryNo(HashMap<String, Object> dataMap) throws Exception;
}
