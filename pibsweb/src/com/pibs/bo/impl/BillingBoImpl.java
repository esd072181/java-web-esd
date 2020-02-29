package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.BillingBo;
import com.pibs.dao.BillingDao;

public class BillingBoImpl implements BillingBo {

	private BillingDao dao;
	
	public BillingDao getBillingDao() {
		return dao;
	}

	public void setBillingDao(BillingDao dao) {
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
	public Map<String, Object> getDataByPatientCaseSystemId(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.getDataByPatientCaseSystemId(criteriaMap);
	}
	
	@Override
	public Map<String, Object> updateToCleared(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.updateToCleared(criteriaMap);
	}	
}
