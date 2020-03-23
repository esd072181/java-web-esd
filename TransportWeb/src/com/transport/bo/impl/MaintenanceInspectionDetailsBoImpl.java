package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.MaintenaceInspectionDetailsBo;
import com.transport.dao.MaintenanceInspectionDetailsDao;

/**
 * 
 * @author edwarddavid
 * @since 23Mar2020
 */
public class MaintenanceInspectionDetailsBoImpl implements MaintenaceInspectionDetailsBo {

	private  MaintenanceInspectionDetailsDao dao;
	
	public MaintenanceInspectionDetailsDao getMaintenanceInspectionDetailsDao() {
		return dao;
	}

	public void setMaintenanceInspectionDetailsDao(MaintenanceInspectionDetailsDao dao) {
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
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataById(criteriaMap);
	}
	

}
