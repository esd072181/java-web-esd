package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.RptProfessionalBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

/**
 * 
 * @author dward
 * @since 19May2018
 */
public class RptProfessionalModule implements PIBSModule {
	
	private final static Logger logger = Logger.getLogger(RptProfessionalModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			RptProfessionalBo bo = (RptProfessionalBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.GET_DATA: returnMap = bo.getRecords(dataMap);
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
