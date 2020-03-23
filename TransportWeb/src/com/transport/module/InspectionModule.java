package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.InspectionBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 22Mar2020
 */
public class InspectionModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(InspectionModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			InspectionBo bo = (InspectionBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.getActiveData(); 
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
