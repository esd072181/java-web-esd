package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.UserBo;
import com.transport.dao.UserDao;

public class UserBoImpl implements UserBo {

	private UserDao dao;
	
	public UserDao getUserDao() {
		return dao;
	}

	public void setUserDao(UserDao dao) {
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
	public Map<String, Object> deleteRecord(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(dataMap);
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
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
	public Map<String, Object> getActiveData()
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getActiveData();
	}	
	
	@Override
	public Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getInActiveData(criteriaMap);
	}	
	
	@Override
	public Map<String, Object> restoreRecord(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.restore(dataMap);
	}
	
	@Override
	public Map<String, Object> updateUsernamePassword(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateUsernamePassword(dataMap);
	}
	
	@Override
	public Map<String, Object> getDataByUsernamePassword(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataByUsernamePassword(criteriaMap);
	}

}
