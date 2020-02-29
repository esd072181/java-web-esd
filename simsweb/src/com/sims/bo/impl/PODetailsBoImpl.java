package com.sims.bo.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.PODetailsBo;
import com.sims.dao.PODetailsDao;
import com.sims.model.PODetails;
import com.sims.model.POHeader;

/**
 * 
 * @author dward
 *
 */
@Service
public class PODetailsBoImpl implements PODetailsBo{
	
	private final static Logger logger = Logger.getLogger(PODetailsBoImpl.class);

	@Autowired
	PODetailsDao pODetailsDao;
	
	public void setPODetailsDao(PODetailsDao pODetailsDao){
		this.pODetailsDao = pODetailsDao;
	}

	@Override
	@Transactional
	public boolean save(PODetails entity) {
		
		logger.info("Save: " + entity.toString()); 
		return  pODetailsDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(PODetails entity) {
		
		PODetails model = pODetailsDao.findById(entity.getId());
		
		model.setItem(entity.getItem());
		model.setQty(entity.getQty());
		model.setPrice(entity.getPrice());
		model.setAmount(entity.getAmount());
	
	    logger.info("Update: " + model.toString());
		 
		return  pODetailsDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(PODetails entity) {
		
		logger.info("Delete: id = " + entity.getId());
		
		return pODetailsDao.delete(entity);
	}

	@Override
	public PODetails findById(int id) {
		return pODetailsDao.findById(id);
	}

	@Override
	public List<PODetails> getListByPOHeader(POHeader poHeader) {
		return pODetailsDao.getListByPOHeader(poHeader);
	}




}
