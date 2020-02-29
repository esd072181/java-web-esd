package com.pibs.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pibs.bo.ReportBo;
import com.pibs.constant.MapConstant;
import com.pibs.util.DateUtils;
import com.pibs.util.ReportUtils;

/**
 * 
 * @author dward
 * @since 17May2018
 */
public class ReportBoImpl implements ReportBo {
	
	@Override
	public Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Object> qryList = (ArrayList<Object>)criteriaMap.get(MapConstant.CLASS_LIST);
		@SuppressWarnings("unchecked")
		
		Map<String, Object> parameters = (HashMap<String, Object>)criteriaMap.get(MapConstant.REPORT_PARAM_MAP);
	    parameters.put("HospitalName", MapConstant.HOSPITAL_NAME);
		parameters.put("HospitalAddress", MapConstant.HOSPITAL_ADDRESS);
		parameters.put("HospitalTelNo", MapConstant.HOSPITAL_TEL_NO);
		parameters.put("DatePrepared", DateUtils.getCurrentDate());
		
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		
		boolean isReportGenerated = ReportUtils.generateReport(qryList, criteriaMap, parameters, localPath);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
	}
}
