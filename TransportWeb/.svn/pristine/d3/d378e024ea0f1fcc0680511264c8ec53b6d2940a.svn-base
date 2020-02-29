package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.DriverTrainingProfileCommentsBo;
import com.transport.dao.DriverTrainingProfileCommentsDao;

public class DriverTrainingProfileCommentsIncabBoImpl implements DriverTrainingProfileCommentsBo {

	private DriverTrainingProfileCommentsDao dao;
	
	public DriverTrainingProfileCommentsDao getDriverTrainingProfileCommentsIncabDao() {
		return dao;
	}

	public void setDriverTrainingProfileCommentsIncabDao(DriverTrainingProfileCommentsDao dao) {
		this.dao = dao;
	}

	@Override
	//@transactional --> for SpringJDBCTemplate
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
	public Map<String, Object> getDataByProfileId(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.getDataByProfileId(criteriaMap);
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataById(criteriaMap);
	}


	

}
