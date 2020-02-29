package com.pibs.dao;

import java.util.HashMap;
import java.util.Map;


public interface ListValueDao {

	Map<String, Object> getAllListValue() throws Exception;
	Map<String, Object> getDataByListType(HashMap<String, Object> criteriaMap) throws Exception;
}
