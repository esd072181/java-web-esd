package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 10Apr2020
 *
 */
public interface TireManagementBo {

	Map<String, Object> getTireDetailsByLorryNo(HashMap<String, Object> dataMap) throws Exception;
	
}
