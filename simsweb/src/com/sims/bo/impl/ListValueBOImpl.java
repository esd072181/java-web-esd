package com.sims.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sims.bo.ListValueBo;
import com.sims.dao.ListValueDao;
import com.sims.model.ListValue;

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
