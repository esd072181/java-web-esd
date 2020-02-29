package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.UserAccessBo;
import com.pibs.dao.UserAccessDao;


public class UserAccessBoImpl implements UserAccessBo {

	private UserAccessDao dao;
	
	public UserAccessDao getUserAccessDao() {
		return dao;
	}

	public void setUserAccessDao(UserAccessDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.save(dataMap);
	}

	@Override
	public Map<String, Object> deleteRecord(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.delete(dataMap);
	}

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.search(criteriaMap);
	}
	
	@Override
	public Map<String, Object> getDataByUserId(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataByUserId(criteriaMap);
	}
	
	@Override
	public Map<String, Object> isAccessExistsForUser(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.isAccessExistsForUser(criteriaMap);
	}
	
	
}
