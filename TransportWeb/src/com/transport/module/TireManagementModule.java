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
 * DateUpdated: 26Apr2020
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
				case ActionConstant.SAVE: returnMap = bo.assignTire(dataMap);
					break;
				case ActionConstant.UPDATE: returnMap = bo.removeTire(dataMap);
					break;
				case ActionConstant.SEARCHALL: returnMap = bo.getTireDetailsByLorryNo(dataMap);
					break;
				case ActionConstant.SEARCHBY: returnMap = bo.getTireDetailsBySerialNo(dataMap);
					break;
				case ActionConstant.GET_DATA_BY_CRITERIA: returnMap = bo.getLatestOdometerBySerialNo(dataMap);
					break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
					break;
				case ActionConstant.UPDATE_2: returnMap = bo.editTire(dataMap);
					break;
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.getLorryHistory(dataMap);
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
