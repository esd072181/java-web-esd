package com.transport.bo.impl;

import java.util.Map;

import com.transport.bo.InspectionBo;
import com.transport.dao.InspectionDao;

/**
 * 
 * @author edwarddavid
 * @since 21Mar2020
 */
public class InspectionBoImpl implements InspectionBo {
	
	private InspectionDao dao;
	
	public InspectionDao getInspectionDao() {
		return dao;
	}

	public void setInspectionDao(InspectionDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> getActiveData() throws Exception {
		return dao.getActiveData();
	}

}
