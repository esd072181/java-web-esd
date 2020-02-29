package com.pibs.bo;

import java.util.HashMap;
import java.util.Map;

public interface ListValueBo {
	
	Map<String, Object> getAllListValue() throws Exception;
	Map<String, Object> getDataByListType(HashMap<String, Object> criteriaMap) throws Exception;
}
