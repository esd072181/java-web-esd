package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptEquipmentBo;
import com.pibs.dao.EquipmentDao;

public class RptEquipmentBoImpl implements RptEquipmentBo {
	
	private EquipmentDao equipmentDao;
	
	public EquipmentDao getEquipmentDao() {
		return equipmentDao;
	}

	public void setEquipmentDao(EquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return equipmentDao.searchForListReport(criteriaMap);
	}
	

	
}
