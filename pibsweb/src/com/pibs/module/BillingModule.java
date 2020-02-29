package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.BillingBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

public class BillingModule implements PIBSModule {

	private final static Logger logger = Logger.getLogger(BillingModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			BillingBo bo = (BillingBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SAVE: returnMap = bo.addNewRecord(dataMap);
					break;
				case ActionConstant.UPDATE: returnMap = bo.updateRecord(dataMap);
					break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataByPatientCaseSystemId(dataMap);
					break;
				case ActionConstant.UPDATE_TO_CLEARED: returnMap = bo.updateToCleared(dataMap);
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
