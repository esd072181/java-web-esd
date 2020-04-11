package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.TireManagementBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 10Apr2020
 */
public class TireManagementModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(TireManagementModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			TireManagementBo bo = (TireManagementBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SEARCHALL: returnMap = bo.getTireDetailsByLorryNo(dataMap);
						break;
				default: break;
			};	
		}catch (Exception e) {
			TransportUtils.writeLogInfo(logger, e.getMessage());
			e.printStackTrace();
		} finally {
			
		}

		return returnMap;
	}

}
