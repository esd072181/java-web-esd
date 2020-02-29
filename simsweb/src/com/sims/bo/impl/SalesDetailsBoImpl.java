package com.sims.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.SalesDetailsBo;
import com.sims.dao.SalesDetailsDao;
import com.sims.model.SalesDetails;
import com.sims.model.SalesHeader;

/**
 * 
 * @author dward
 *
 */
@Service
public class SalesDetailsBoImpl implements SalesDetailsBo{

	@Autowired
	SalesDetailsDao salesDetailsDao;
	
	public void setSalesDetailsDao(SalesDetailsDao salesDetailsDao){
		this.salesDetailsDao = salesDetailsDao;
	}

	@Override
	@Transactional
	public boolean save(SalesDetails entity) {
		return  salesDetailsDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(SalesDetails entity) {			 
		return salesDetailsDao.update(entity);
	}

	@Override
	@Transactional
	public boolean delete(SalesDetails entity) {			 
		return salesDetailsDao.delete(entity);
	}

	@Override
	public List<SalesDetails> getListBySalesHeader(SalesHeader salesHeader) {
		return salesDetailsDao.getListBySalesHeader(salesHeader);
	}

	@Override
	public SalesDetails findById(int criteria) {
		return salesDetailsDao.findById(criteria);
	}

//	@Override
//	public boolean deleteByHeader(SalesHeader salesHeader) {
//		return salesDetailsDao.deleteByHeader(salesHeader);
//	}



}
