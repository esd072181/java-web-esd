package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.DriverTrainingProfileCommentsBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 16Sep2019
 */
public class DriverTrainingProfileCommentsSpotcheckModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(DriverTrainingProfileCommentsSpotcheckModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			DriverTrainingProfileCommentsBo bo = (DriverTrainingProfileCommentsBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SAVE: returnMap = bo.addNewRecord(dataMap);
						break;
				case ActionConstant.SEARCHALL: returnMap = bo.getDataByProfileId(dataMap);
						break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
						break;
				case ActionConstant.UPDATE: returnMap = bo.updateRecord(dataMap);
						break;
				case ActionConstant.DELETE: returnMap = bo.deleteRecord(dataMap);
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
