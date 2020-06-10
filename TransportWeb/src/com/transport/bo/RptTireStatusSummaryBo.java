package com.transport.bo;

import java.util.HashMap;
import java.util.Map;

public interface RptTireStatusSummaryBo {

	Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception;
	
}
