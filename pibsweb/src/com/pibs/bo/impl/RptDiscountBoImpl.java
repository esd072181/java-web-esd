package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptDiscountBo;
import com.pibs.dao.DiscountDao;

public class RptDiscountBoImpl implements RptDiscountBo {
	
	private DiscountDao discountDao;
	
	public DiscountDao getDiscountDao() {
		return discountDao;
	}

	public void setDiscountDao(DiscountDao discountDao) {
		this.discountDao = discountDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return discountDao.searchForListReport(criteriaMap);
	}
	
}
