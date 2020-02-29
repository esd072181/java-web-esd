package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.ProfessionalTypeBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

public class ProfessionalTypeModule implements PIBSModule {

	private final static Logger logger = Logger.getLogger(ProfessionalTypeModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			ProfessionalTypeBo bo = (ProfessionalTypeBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.SAVE: returnMap = bo.addNewRecord(dataMap);
						break;
				case ActionConstant.SEARCHALL: returnMap = bo.getRecords(dataMap);
						break;
				case ActionConstant.SEARCHBY: returnMap = bo.getRecords(dataMap);
						break;
				case ActionConstant.GET_DATA: returnMap = bo.getDataById(dataMap);
						break;
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.getActiveData();
						break;
				case ActionConstant.UPDATE: returnMap = bo.updateRecord(dataMap);
						break;
				case ActionConstant.DELETE: returnMap = bo.deleteRecord(dataMap);
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
