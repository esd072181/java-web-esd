package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptLaboratoryExaminationBo;
import com.pibs.dao.LaboratoryExaminationDao;

public class RptLaboratoryExaminationBoImpl implements RptLaboratoryExaminationBo {
	
	private LaboratoryExaminationDao laboratoryExaminationDao;
	
	public LaboratoryExaminationDao getLaboratoryExaminationDao() {
		return laboratoryExaminationDao;
	}

	public void setLaboratoryExaminationDao(LaboratoryExaminationDao laboratoryExaminationDao) {
		this.laboratoryExaminationDao = laboratoryExaminationDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return laboratoryExaminationDao.searchForListReport(criteriaMap);
	}
	
}
