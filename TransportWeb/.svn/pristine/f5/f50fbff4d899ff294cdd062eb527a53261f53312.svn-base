package com.transport.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.transport.bo.RptWorkPermitBo;
import com.transport.constant.MapConstant;
import com.transport.dao.RptWorkPermitDao;
import com.transport.util.ReportUtils;

public class RptWorkPermitBoImpl implements RptWorkPermitBo {
	
	private RptWorkPermitDao dao;
	
	public RptWorkPermitDao getRptWorkPermitDao() {
		return dao;
	}

	public void setRptWorkPermitDao(RptWorkPermitDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.search(criteriaMap);
	}
	
	@Override
	public Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Object> qryList = (ArrayList<Object>)criteriaMap.get(MapConstant.CLASS_LIST);
		@SuppressWarnings("unchecked")
		Map<String, Object> parameters = (HashMap<String, Object>)criteriaMap.get(MapConstant.REPORT_PARAM_MAP);
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		
		boolean isReportGenerated = ReportUtils.generateReport(qryList, criteriaMap, parameters, localPath);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
	}
}
