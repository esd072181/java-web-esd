package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.ListValueBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

public class ListValueModule implements PIBSModule {
	
	private final static Logger logger = Logger.getLogger(ListValueModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			ListValueBo bo = (ListValueBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.GET_DATA_BY_LIST_TYPE: returnMap = bo.getDataByListType(dataMap);
						break;
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.getAllListValue();
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
