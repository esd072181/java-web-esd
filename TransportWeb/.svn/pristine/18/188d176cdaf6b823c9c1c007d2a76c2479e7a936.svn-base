package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.FindingsBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.SubActionConstant;
import com.transport.util.TransportUtils;

public class FindingsModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(FindingsModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			FindingsBo bo = (FindingsBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SAVE: returnMap = bo.addNewRecord(dataMap);
						break;
				case ActionConstant.SEARCHALL: returnMap = bo.getRecords(dataMap);
						break;
				case ActionConstant.SEARCHBY: returnMap = bo.getRecords(dataMap);
						break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
						break;
				case ActionConstant.GET_ACTIVE_DATA: 
					int subAction = TransportUtils.getSubAction(dataMap);
					if (subAction!=0 && subAction == SubActionConstant.GET_FINDINGS_BY_ITEM) {
							returnMap = bo.getFindingsByItem(dataMap);	
						} else {
							returnMap = bo.getActiveData();	
						}
						break;
				case ActionConstant.UPDATE: returnMap = bo.updateRecord(dataMap);
						break;
				case ActionConstant.DELETE: returnMap = bo.deleteRecord(dataMap);
					    break;
				case ActionConstant.GET_INACTIVE_DATA: returnMap = bo.getInActiveData(dataMap);
						break;
				case ActionConstant.RESTORE: returnMap = bo.restoreRecord(dataMap);
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
