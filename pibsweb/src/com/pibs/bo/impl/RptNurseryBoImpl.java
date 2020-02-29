package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptNurseryBo;
import com.pibs.dao.MonitorNurseryDao;

public class RptNurseryBoImpl implements RptNurseryBo {
	
	private MonitorNurseryDao monitorNurseryDao;
	
	public MonitorNurseryDao getMonitorNurseryDao() {
		return monitorNurseryDao;
	}

	public void setMonitorNurseryDao(MonitorNurseryDao monitorNurseryDao) {
		this.monitorNurseryDao = monitorNurseryDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return monitorNurseryDao.searchForListReport(criteriaMap);
	}
	
}
