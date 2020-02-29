package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptRadiologyBo;
import com.pibs.dao.RadiologyDao;

public class RptRadiologyBoImpl implements RptRadiologyBo {
	
	private RadiologyDao radiologyDao;
	
	public RadiologyDao getRadiologyDao() {
		return radiologyDao;
	}

	public void setRadiologyDao(RadiologyDao radiologyDao) {
		this.radiologyDao = radiologyDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return radiologyDao.searchForListReport(criteriaMap);
	}
	
}
