package com.pibs.bo.impl;

import java.util.Map;
import com.pibs.bo.ListTypeBo;
import com.pibs.dao.ListTypeDao;

public class ListTypeBoImpl implements ListTypeBo {
	
	private ListTypeDao dao;
	
	public ListTypeDao getListTypeDao() {
		return dao;
	}

	public void setListTypeDao(ListTypeDao dao) {
		this.dao = dao;
	}

	@Override
	public  Map<String, Object> getAllListType() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllListType();
	}
	

}
