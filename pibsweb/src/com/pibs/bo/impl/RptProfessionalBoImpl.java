package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptProfessionalBo;
import com.pibs.dao.ProfessionalDao;

public class RptProfessionalBoImpl implements RptProfessionalBo {
	
	private ProfessionalDao professionalDao;
	
	public ProfessionalDao getProfessionalDao() {
		return professionalDao;
	}

	public void setProfessionalDao(ProfessionalDao professionalDao) {
		this.professionalDao = professionalDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return professionalDao.searchForListReport(criteriaMap);
	}
	
}
