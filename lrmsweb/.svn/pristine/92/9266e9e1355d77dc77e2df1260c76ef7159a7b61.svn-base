package com.lrms.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrms.bo.ListValueBo;
import com.lrms.dao.ListValueDao;
import com.lrms.model.ListValue;

@Service
public class ListValueBOImpl implements ListValueBo {

	@Autowired
	ListValueDao listValueDao;
	
	public void setListValueDao(ListValueDao listValueDao){
		this.listValueDao = listValueDao;
	}
	
	@Override
	public List<ListValue> getAllLOV() {
		// TODO Auto-generated method stub
		return listValueDao.getAllLOV();
	}

}
