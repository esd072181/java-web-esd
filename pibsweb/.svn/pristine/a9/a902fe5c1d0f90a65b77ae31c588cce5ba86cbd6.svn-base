package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptAdditionalServicesBo;
import com.pibs.dao.AdditionalServicesDao;

public class RptAdditionalServicesBoImpl implements RptAdditionalServicesBo {
	
	private AdditionalServicesDao additionalServicesDao;
	
	public AdditionalServicesDao getSAdditionalServicesDao() {
		return additionalServicesDao;
	}

	public void setAdditionalServicesDao(AdditionalServicesDao additionalServicesDao) {
		this.additionalServicesDao = additionalServicesDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return additionalServicesDao.searchForListReport(criteriaMap);
	}
	
}
