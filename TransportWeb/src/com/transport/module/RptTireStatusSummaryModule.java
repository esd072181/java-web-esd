package com.transport.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.bo.RptTireStatusSummaryBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 24Apr2020
 */
public class RptTireStatusSummaryModule implements TransportModule {
	
	private final static Logger logger = Logger.getLogger(RptTireStatusSummaryModule.class);

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap)
			throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			RptTireStatusSummaryBo bo = (RptTireStatusSummaryBo) dataMap.get(MapConstant.BEAN);
			
			switch(action) {
				case ActionConstant.GENERATE_REPORT: returnMap = bo.generateReport(dataMap);
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
