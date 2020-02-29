package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.MaintenanceMonitoringPreventiveBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 25April2019
 * Date Updated: 25April2019
 */
public class MaintenanceMonitoringPreventiveModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(MaintenanceMonitoringPreventiveModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			MaintenanceMonitoringPreventiveBo bo = (MaintenanceMonitoringPreventiveBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.getActiveData(dataMap);
						break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
						break;
				case ActionConstant.UPDATE: returnMap = bo.update(dataMap);
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
