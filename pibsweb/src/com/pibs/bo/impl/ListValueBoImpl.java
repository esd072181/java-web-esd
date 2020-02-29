package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;
import com.pibs.bo.ListValueBo;
import com.pibs.dao.ListValueDao;

public class ListValueBoImpl implements ListValueBo {
	
	private ListValueDao dao;
	
	public ListValueDao getListValueDao() {
		return dao;
	}

	public void setListValueDao(ListValueDao dao) {
		this.dao = dao;
	}

	@Override
	public  Map<String, Object> getAllListValue() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllListValue();
	}
	
	@Override
	public Map<String, Object> getDataByListType(
			HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataByListType(dataMap);
	}

}
