package com.pibs.bo;

import java.util.HashMap;
import java.util.Map;

public interface RptPatientBo {

	Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception;
	
}
