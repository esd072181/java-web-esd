package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.MaintenaceInspectionHeaderBo;
import com.transport.constant.MapConstant;
import com.transport.dao.MaintenanceInspectionDetailsDao;
import com.transport.dao.MaintenanceInspectionHeaderDao;
import com.transport.model.InspectionHeader;

/**
 * 
 * @author edwarddavid
 * @since 23Mar2020
 */
public class MaintenanceInspectionHeaderBoImpl implements MaintenaceInspectionHeaderBo {

	private  MaintenanceInspectionHeaderDao dao;
	private  MaintenanceInspectionDetailsDao detailsDao;
	
	public MaintenanceInspectionHeaderDao getMaintenanceInspectionHeaderDao() {
		return dao;
	}

	public void setMaintenanceInspectionHeaderDao(MaintenanceInspectionHeaderDao dao) {
		this.dao = dao;
	}
	
	public MaintenanceInspectionDetailsDao getMaintenanceInspectionDetailsDao() {
		return detailsDao;
	}

	public void setMaintenanceInspectionDetailsDao(MaintenanceInspectionDetailsDao detailsDao) {
		this.detailsDao = detailsDao;
	}

	@Override
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception{
		Map<String, Object> returnMap = dao.save(dataMap);//Header
		boolean tranctionStatus = (boolean) returnMap.get(MapConstant.TRANSACTION_STATUS);
		if (tranctionStatus) {
			//Save the details
			dataMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, returnMap.get(MapConstant.FIELD_CRITERIA_ENTITY_ID));
			returnMap.clear();
			Map<String, Object> detailsMap = detailsDao.save(dataMap);
			returnMap.put(MapConstant.TRANSACTION_STATUS, detailsMap.get(MapConstant.TRANSACTION_STATUS));
			//get the latest details to show after saved
			InspectionHeader model = new InspectionHeader();
			model.setId((Integer)dataMap.get(MapConstant.FIELD_CRITERIA_ENTITY_ID));
			dataMap.put(MapConstant.CLASS_DATA, model);
			detailsMap = detailsDao.getDataById(dataMap);
			returnMap.put(MapConstant.CLASS_LIST, detailsMap.get(MapConstant.CLASS_LIST));
		}
		return returnMap;
	}

	@Override
	public Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception{
		
		Map<String, Object> returnMap = dao.update(dataMap);//Header
		boolean tranctionStatus = (boolean) returnMap.get(MapConstant.TRANSACTION_STATUS);
		if (tranctionStatus) {
			//Update the details
			returnMap.clear();
			Map<String, Object> detailsMap = detailsDao.update(dataMap);
			returnMap.put(MapConstant.TRANSACTION_STATUS, detailsMap.get(MapConstant.TRANSACTION_STATUS));
			detailsMap.clear();
			detailsMap = detailsDao.getDataById(dataMap);
			returnMap.put(MapConstant.CLASS_LIST, detailsMap.get(MapConstant.CLASS_LIST));
		}
		return returnMap;
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
		
		Map<String, Object> returnMap = dao.getDataById(criteriaMap);
		Map<String, Object> detailsMap = detailsDao.getDataById(criteriaMap);
		
		returnMap.put(MapConstant.TRANSACTION_STATUS, detailsMap.get(MapConstant.TRANSACTION_STATUS));
		returnMap.put(MapConstant.CLASS_LIST, detailsMap.get(MapConstant.CLASS_LIST));
		return returnMap;
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
	

}
