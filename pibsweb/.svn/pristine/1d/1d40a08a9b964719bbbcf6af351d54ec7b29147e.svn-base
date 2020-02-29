package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.BillingPaymentBo;
import com.pibs.dao.BillingPaymentDao;

public class BillingPaymentBoImpl implements BillingPaymentBo {

	private BillingPaymentDao dao;
	
	public BillingPaymentDao getBillingPaymentDao() {
		return dao;
	}

	public void setBillingPaymentDao(BillingPaymentDao dao) {
		this.dao = dao;
	}


	@Override
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.save(dataMap);
	}


	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.search(criteriaMap);
	}
}
