package com.transport.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.transport.bo.RptTireStatusSummaryBo;
import com.transport.constant.MapConstant;
import com.transport.dao.TireDao;
import com.transport.util.ReportUtils;

/**
 * 
 * @author edwarddavid
 * @since 24Apr2020
 */
public class RptTireStatusSummaryBoImpl implements RptTireStatusSummaryBo {
	
	private TireDao dao;
	
	public TireDao getTireDao() {
		return dao;
	}

	public void setTireDao(TireDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		
		Map<String, Object> returnMap = dao.getTireStatusSummary(criteriaMap);
		@SuppressWarnings("unchecked")
		List<Object> qryList = (ArrayList<Object>)returnMap.get(MapConstant.CLASS_LIST);
		@SuppressWarnings("unchecked")
		Map<String, Object> parameters = (HashMap<String, Object>)criteriaMap.get(MapConstant.REPORT_PARAM_MAP);
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		
		boolean isReportGenerated = ReportUtils.generateReport(qryList, criteriaMap, parameters, localPath);
		
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
	}
}
