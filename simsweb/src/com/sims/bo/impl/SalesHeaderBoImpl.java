package com.sims.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.SalesHeaderBo;
import com.sims.dao.SalesHeaderDao;
import com.sims.model.SalesHeader;

/**
 * 
 * @author dward
 *
 */
@Service
public class SalesHeaderBoImpl implements SalesHeaderBo{
	
	private final static Logger logger = Logger.getLogger(SalesHeaderBoImpl.class);

	@Autowired
	SalesHeaderDao salesHeaderDao;
	
	public void setSalesHeaderDao(SalesHeaderDao salesHeaderDao){
		this.salesHeaderDao = salesHeaderDao;
	}

	@Override
	@Transactional
	public boolean save(SalesHeader entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return  salesHeaderDao.save(entity);
	}

	@Override
	public boolean update(SalesHeader entity) {	
		
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);
		 
		return salesHeaderDao.update(entity);
	}

	@Override
	public SalesHeader getEntityByTransNo(String transNo) {
		return salesHeaderDao.getEntityByTransNo(transNo);
	}

	@Override
	public long getTotalCount() {
		return salesHeaderDao.getTotalCount();
	}

	@Override
	public SalesHeader findById(int criteria) {
		return salesHeaderDao.findById(criteria);
	}

	@Override
	public boolean delete(SalesHeader entity) {
		return salesHeaderDao.delete(entity);
	}


}
