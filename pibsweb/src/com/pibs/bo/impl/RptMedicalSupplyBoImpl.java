package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptMedicalSupplyBo;
import com.pibs.dao.MedicalSupplyDao;

public class RptMedicalSupplyBoImpl implements RptMedicalSupplyBo {
	
	private MedicalSupplyDao medicalSupplyDao;
	
	public MedicalSupplyDao getMedicalSupplyDao() {
		return medicalSupplyDao;
	}

	public void setMedicalSupplyDao(MedicalSupplyDao medicalSupplyDao) {
		this.medicalSupplyDao = medicalSupplyDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return medicalSupplyDao.searchForListReport(criteriaMap);
	}
	
}
