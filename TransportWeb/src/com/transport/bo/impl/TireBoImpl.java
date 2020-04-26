package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.TireBo;
import com.transport.constant.MapConstant;
import com.transport.dao.TireDao;
import com.transport.dao.TireManagementDao;

/**
 * 
 * @author dward
 * @since 21Aug2016
 * DateUpdated: 26Apr2020
 */
public class TireBoImpl implements TireBo {

	private TireDao dao;
	private TireManagementDao tireManagementDao;
	
	public TireDao getTireDao() {
		return dao;
	}

	public void setTireDao(TireDao dao) {
		this.dao = dao;
	}
	
	public TireManagementDao getTireManagementDao() {
		return tireManagementDao;
	}

	public void setTireManagementDao(TireManagementDao tireManagementDao) {
		this.tireManagementDao = tireManagementDao;
	}

	@Override
	//@transactional --> for SpringJDBCTemplate
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.save(dataMap);
	}

	@Override
	public Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception{
		
		Object recap =  dataMap.get(MapConstant.BOOLEAN_DATA);
		Object analysis =  dataMap.get(MapConstant.BOOLEAN_DATA_2);
		if (recap!=null) {
			return dao.updateRecapNo(dataMap);//for recap
		} else if (analysis!=null) {
			return dao.updateAnalysisComments(dataMap);//for analysis and comments
		} else {
			return dao.update(dataMap);
		}
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
	public Map<String, Object> getTireDetails(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return tireManagementDao.searchTireDetailsBySerialNo(dataMap);
	}

}
