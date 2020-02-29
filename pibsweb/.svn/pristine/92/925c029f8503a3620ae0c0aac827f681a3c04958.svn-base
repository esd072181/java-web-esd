package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.PatientInquiryBo;
import com.pibs.dao.PatientDao;

public class PatientInquiryBoImpl implements PatientInquiryBo {

	private PatientDao dao;
	
	public PatientDao getPatientDao() {
		return dao;
	}

	public void setPatientDao(PatientDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.searchForInquiry(criteriaMap);
	}
	
}
