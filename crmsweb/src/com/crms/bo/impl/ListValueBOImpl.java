package com.crms.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crms.bo.ListValueBo;
import com.crms.dao.ListValueDao;
import com.crms.model.ListValue;

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
