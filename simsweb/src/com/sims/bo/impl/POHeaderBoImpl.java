package com.sims.bo.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.POHeaderBo;
import com.sims.dao.POHeaderDao;
import com.sims.model.POHeader;

/**
 * 
 * @author dward
 *
 */
@Service
public class POHeaderBoImpl implements POHeaderBo{
	
	private final static Logger logger = Logger.getLogger(POHeaderBoImpl.class);

	@Autowired
	POHeaderDao pOHeaderDao;
	
	public void setPOHeaderDao(POHeaderDao pOHeaderDao){
		this.pOHeaderDao = pOHeaderDao;
	}

	@Override
	@Transactional
	public boolean save(POHeader entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return  pOHeaderDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(POHeader entity) {
		
		POHeader model = pOHeaderDao.findById(entity.getId());
		
		model.setSupplier(entity.getSupplier());
		model.setTotalAmount(entity.getTotalAmount());
		model.setStatus(entity.getStatus());
		model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		model.setVersion(entity.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return  pOHeaderDao.update(model);
	}

	@Override
	@Transactional
	public boolean delete(POHeader entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);
		
		logger.info("Delete: id = " + entity.getId());
		
		return pOHeaderDao.delete(entity);
	}
	
	@Override
	public POHeader findById(int id) {
		return pOHeaderDao.findById(id);
	}

	@Override
	public Map<Object, Object> findBySupplierName(Map<Object, Object> mapCriteria) {
		return pOHeaderDao.findBySupplierName(mapCriteria);
	}

	@Override
	public long getTotalCount() {
		return pOHeaderDao.getTotalCount();
	}

	@Override
	public POHeader findByPONo(String criteria) {
		// TODO Auto-generated method stub
		return pOHeaderDao.findByPONo(criteria);
	}

}
