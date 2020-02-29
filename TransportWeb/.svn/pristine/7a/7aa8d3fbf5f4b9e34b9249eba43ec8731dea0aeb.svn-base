package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.MaintenanceMonitoringBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 25Mar2019
 * Date Updated: 25Mar2019
 */
public class MaintenanceMonitoringModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(MaintenanceMonitoringModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			MaintenanceMonitoringBo bo = (MaintenanceMonitoringBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SAVE: returnMap = bo.add(dataMap);
						break;
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.getActiveData(dataMap);
						break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
						break;
				case ActionConstant.UPDATE: returnMap = bo.update(dataMap);
						break;
				case ActionConstant.DELETE: returnMap = bo.delete(dataMap);
					    break;
				case ActionConstant.GENERATE_EXCEL_FILE: returnMap = bo.generateExcelFile(dataMap);
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
