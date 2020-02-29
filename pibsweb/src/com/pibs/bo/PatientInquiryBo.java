package com.pibs.bo;

import java.util.HashMap;
import java.util.Map;

public interface PatientInquiryBo {

	Map<String, Object> search(HashMap<String, Object> dataMap) throws Exception;
}
