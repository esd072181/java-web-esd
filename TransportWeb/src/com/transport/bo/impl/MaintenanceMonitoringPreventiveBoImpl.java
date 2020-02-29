package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.MaintenanceMonitoringPreventiveBo;
import com.transport.dao.MaintenanceMonitoringPreventiveDao;
/**
 * 
 * @author dward
 * @since 25April2019
 * Date Updated: 25April2019
 */
public class MaintenanceMonitoringPreventiveBoImpl implements MaintenanceMonitoringPreventiveBo {

	private MaintenanceMonitoringPreventiveDao dao;
	
	public MaintenanceMonitoringPreventiveDao getMaintenanceMonitoringPreventiveDao() {
		return dao;
	}

	public void setMaintenanceMonitoringPreventiveDao(MaintenanceMonitoringPreventiveDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.update(dataMap);
	}

	@Override
	public Map<String, Object> getActiveData(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.getActiveData(criteriaMap);
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataById(criteriaMap);
	}

}
