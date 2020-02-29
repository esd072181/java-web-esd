package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.MaintenanceMonitoringTotalPendingBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 03Sep2019
 */
public class MaintenanceMonitoringTotalPendingModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(MaintenanceMonitoringTotalPendingModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			MaintenanceMonitoringTotalPendingBo bo = (MaintenanceMonitoringTotalPendingBo) dataMap.get(MapConstant.BEAN);
			
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
