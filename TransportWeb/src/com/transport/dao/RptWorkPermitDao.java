package com.transport.dao;

import java.util.HashMap;
import java.util.Map;

public interface RptWorkPermitDao {
	
	Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception;

}
