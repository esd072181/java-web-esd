package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

public interface RptVerificationBo {

	Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception;
	
}
