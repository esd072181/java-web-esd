package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.MonitorNurseryBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

public class NurseryModule implements PIBSModule {

	private final static Logger logger = Logger.getLogger(NurseryModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			MonitorNurseryBo bo = (MonitorNurseryBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SEARCHBY: returnMap = bo.search(dataMap);
					break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
					break;
				case ActionConstant.UPDATE: returnMap = bo.updateRecord(dataMap);
					break;
				case ActionConstant.DELETE: returnMap = bo.delete(dataMap);
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
