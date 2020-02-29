package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptSurgeryBo;
import com.pibs.dao.SurgeryDao;

public class RptSurgeryBoImpl implements RptSurgeryBo {
	
	private SurgeryDao surgeryDao;
	
	public SurgeryDao getSurgeryDao() {
		return surgeryDao;
	}

	public void setSurgeryDao(SurgeryDao surgeryDao) {
		this.surgeryDao = surgeryDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return surgeryDao.searchForListReport(criteriaMap);
	}
	
}
