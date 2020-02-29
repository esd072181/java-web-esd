package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptPatientBo;
import com.pibs.dao.PatientDao;

public class RptPatientBoImpl implements RptPatientBo {
	
	private PatientDao patientDao;
	
	public PatientDao getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return patientDao.searchForListReport(criteriaMap);
	}
	
}
