package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.PatientBillHistoryBo;
import com.pibs.dao.PatientDao;

public class PatientBillHistoryBoImpl implements PatientBillHistoryBo {

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
	public Map<String, Object> getPatientBillHistory(
			HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		return patientDao.getPatientBillHistory(criteriaMap);
	}

	
}
