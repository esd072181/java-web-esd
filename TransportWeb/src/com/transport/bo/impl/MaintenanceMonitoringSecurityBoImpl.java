package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.MaintenanceMonitoringSecurityBo;
import com.transport.dao.MaintenanceMonitoringSecurityDao;

/**
 * 
 * @author dward
 *
 */
public class MaintenanceMonitoringSecurityBoImpl implements MaintenanceMonitoringSecurityBo {

	private MaintenanceMonitoringSecurityDao dao;
	
	public MaintenanceMonitoringSecurityDao getMaintenanceMonitoringSecurityDao() {
		return dao;
	}

	public void setMaintenanceMonitoringSecurityDao(MaintenanceMonitoringSecurityDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> add(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.save(dataMap);
	}


	@Override
	public Map<String, Object> getDataByCriteria(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.searchDataByCriteria(criteriaMap);
	}

}
