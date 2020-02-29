package com.pibs.service;

import java.util.HashMap;
import java.util.Map;

public interface ServiceManager {

	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap) throws Exception;
	
}
