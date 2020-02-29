package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.MedicationStatementBo;
import com.pibs.dao.MedicationStatementDao;

public class MedicationStatementBoImpl implements MedicationStatementBo {

	private MedicationStatementDao dao;
	
	public MedicationStatementDao getMedicationStatementDao() {
		return dao;
	}

	public void setMedicationStatementDao(MedicationStatementDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.save(dataMap);
	}

	@Override
	public Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.update(dataMap);
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataById(criteriaMap);
	}
	

}
