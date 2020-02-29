package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.bo.PatientInquiryBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.util.PIBSUtils;

public class PatientInquiryModule implements PIBSModule {

	private final static Logger logger = Logger.getLogger(PatientInquiryModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			PatientInquiryBo bo = (PatientInquiryBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.GET_ACTIVE_DATA: returnMap = bo.search(dataMap);
					break;
				case ActionConstant.SEARCH_ALL_PATIENT_ADMITTED: returnMap = bo.search(dataMap);
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
