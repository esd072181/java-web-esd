package com.pibs.bo;

import java.util.HashMap;
import java.util.Map;

public interface PatientBillHistoryBo {

	Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception;
	Map<String, Object> getPatientBillHistory(HashMap<String, Object> criteriaMap) throws Exception;
}
