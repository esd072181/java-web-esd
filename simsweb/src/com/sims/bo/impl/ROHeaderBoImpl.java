package com.sims.bo.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.ROHeaderBo;
import com.sims.dao.ROHeaderDao;
import com.sims.model.ROHeader;

/**
 * 
 * @author dward
 *
 */
@Service
public class ROHeaderBoImpl implements ROHeaderBo {
	
	private final static Logger logger = Logger.getLogger(ROHeaderBoImpl.class);

	@Autowired
	ROHeaderDao rOHeaderDao;
	
	public void setROHeaderDao(ROHeaderDao rOHeaderDao){
		this.rOHeaderDao = rOHeaderDao;
	}

	@Override
	@Transactional
	public boolean save(ROHeader entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return  rOHeaderDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(ROHeader entity) {
		
		ROHeader model = rOHeaderDao.findById(entity.getId());
		
		model.setTotalAmount(entity.getTotalAmount());
		model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		model.setVersion(entity.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return  rOHeaderDao.update(model);
	}

	@Override
	@Transactional
	public boolean delete(ROHeader entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);
		
		logger.info("Delete: id = " + entity.getId());
		
		return rOHeaderDao.delete(entity);
	}
	
	@Override
	public ROHeader findById(int id) {
		return rOHeaderDao.findById(id);
	}

}
