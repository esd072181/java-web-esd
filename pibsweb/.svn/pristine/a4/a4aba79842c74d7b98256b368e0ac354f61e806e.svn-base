package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.MonitorMedicalSupplyBo;
import com.pibs.dao.MonitorMedicalSupplyDao;

public class MonitorMedicalSupplyBoImpl implements MonitorMedicalSupplyBo {

	private MonitorMedicalSupplyDao dao;
	
	public MonitorMedicalSupplyDao getMonitorMedicalSupplyDao() {
		return dao;
	}

	public void setMonitorMedicalSupplyDao(MonitorMedicalSupplyDao dao) {
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
	public Map<String, Object> search(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.search(criteriaMap);
	}
	
	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataById(criteriaMap);
	}
	
	@Override
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.delete(dataMap);
	}
}
