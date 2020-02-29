package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.MaintenanceMonitoringSecurityBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 25Oct2019
 */
public class MaintenanceMonitoringSecurityModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(MaintenanceMonitoringSecurityModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			MaintenanceMonitoringSecurityBo bo = (MaintenanceMonitoringSecurityBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SAVE: returnMap = bo.add(dataMap);
						break;
				case ActionConstant.GET_DATA_BY_CRITERIA: returnMap = bo.getDataByCriteria(dataMap);
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
