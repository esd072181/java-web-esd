package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptPatientHistoryBo;
import com.pibs.dao.PatientDao;

public class RptPatientHistoryBoImpl implements RptPatientHistoryBo {

	private PatientDao patientDao;
	
	public PatientDao getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return patientDao.search(criteriaMap);
	}

	@Override
	public Map<String, Object> getPatientHistory(
			HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		return patientDao.getPatientHistory(criteriaMap);
	}

	
}
