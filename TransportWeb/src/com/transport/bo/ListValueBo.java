package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

public interface ListValueBo {
	
	Map<String, Object> getDataByListType(HashMap<String, Object> criteriaMap) throws Exception;
}
