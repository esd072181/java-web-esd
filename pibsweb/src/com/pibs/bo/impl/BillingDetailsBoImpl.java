package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.BillingDetailsBo;
import com.pibs.dao.BillingDetailsDao;

public class BillingDetailsBoImpl implements BillingDetailsBo {

	private BillingDetailsDao dao;
	
	public BillingDetailsDao getBillingDetailsDao() {
		return dao;
	}

	public void setBillingDetailsDao(BillingDetailsDao dao) {
		this.dao = dao;
	}


	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.search(criteriaMap);
	}

}
