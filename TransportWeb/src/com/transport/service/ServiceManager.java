package com.transport.service;

import java.util.HashMap;
import java.util.Map;

public interface ServiceManager {

	Map<String, Object> executeRequest(HashMap<String, Object> dataMap) throws Exception;
	
}
