package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.RoomInquiryBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

public class RoomInquiryModule implements PIBSModule {

	private final static Logger logger = Logger.getLogger(RoomInquiryModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			RoomInquiryBo bo = (RoomInquiryBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.search(dataMap);
					break;
				case ActionConstant.SEARCHALL: returnMap = bo.searchAll(dataMap);
					break;
				case ActionConstant.GET_AVAILABLE_ROOMS: returnMap = bo.getAvailableRooms(dataMap);
					break;
				case ActionConstant.GET_OCCUPIED_ROOMS: returnMap = bo.getOccupiedRooms(dataMap);
					break;
				default: break;
			};	
		}catch (Exception e) {
			PIBSUtils.writeLogInfo(logger, e.getMessage());
			e.printStackTrace();
		} finally {
			
		}

		return returnMap;
	}


}
