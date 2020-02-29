package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.RoomBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

public class RoomModule implements PIBSModule {
	
	private final static Logger logger = Logger.getLogger(RoomModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			RoomBo bo = (RoomBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SAVE: returnMap = bo.addNewRecord(dataMap);
						break;
				case ActionConstant.SEARCHALL: returnMap = bo.getRecords(dataMap);
						break;
				case ActionConstant.SEARCHBY: returnMap = bo.getRecords(dataMap);
						break;
				case ActionConstant.SEARCH_AVAILABLE_ROOMS: returnMap = bo.searchAvailableRooms(dataMap);
						break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
						break;
				case ActionConstant.UPDATE: returnMap = bo.updateRecord(dataMap);
						break;
				case ActionConstant.DELETE: returnMap = bo.deleteRecord(dataMap);
					    break;
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.getActiveData();
						break;
				case ActionConstant.GET_AVAILABLE_ROOMS: returnMap = bo.getAvailableRooms();
						break;
				case ActionConstant.UPDATE_AVAILABLE_BEDS: returnMap = bo.updateAvailableBeds(dataMap);
						break;
				case ActionConstant.UPDATE_AVAILABLE_BEDS_AFTER_PAYMENT_OR_ROOM_TRANSFER: returnMap = bo.updateAvailableBedsAfterPaymentOrRoomTransfer(dataMap);
						break;
				case ActionConstant.GET_INACTIVE_DATA: returnMap = bo.getInActiveData(dataMap);
						break;
				case ActionConstant.RESTORE: returnMap = bo.restoreRecord(dataMap);
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
