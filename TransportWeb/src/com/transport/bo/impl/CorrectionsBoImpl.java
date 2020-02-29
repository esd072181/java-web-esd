package com.transport.bo.impl;

/**
 *  * The @Transactional is used for SPringJDBC Transaction Management
 *  
 */
import java.util.HashMap;
import java.util.Map;

import com.transport.bo.CorrectionsBo;
import com.transport.dao.CorrectionsDao;

public class CorrectionsBoImpl implements CorrectionsBo {

	private CorrectionsDao dao;
	
	public CorrectionsDao getCorrectionsDao() {
		return dao;
	}

	public void setCorrectionsDao(CorrectionsDao dao) {
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
	public Map<String, Object> getNoClosureData()
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getNoClosureData();
	}	
	@Override
	public Map<String, Object> getCorrectionsByRootCause(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.getCorrectionsByRootCause(criteriaMap);
	}

}
