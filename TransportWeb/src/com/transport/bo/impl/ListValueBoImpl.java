package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.ListValueBo;
import com.transport.dao.ListValueDao;

public class ListValueBoImpl implements ListValueBo {
	
	private ListValueDao dao;
	
	public ListValueDao getListValueDao() {
		return dao;
	}

	public void setListValueDao(ListValueDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> getDataByListType(
			HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataByListType(dataMap);
	}

}
