package com.sims.bo.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.RODetailsBo;
import com.sims.dao.RODetailsDao;
import com.sims.model.RODetails;
import com.sims.model.ROHeader;

/**
 * 
 * @author dward
 *
 */
@Service
public class RODetailsBoImpl implements RODetailsBo{
	
	private final static Logger logger = Logger.getLogger(RODetailsBoImpl.class);

	@Autowired
	RODetailsDao rODetailsDao;
	
	public void setRODetailsDao(RODetailsDao rODetailsDao){
		this.rODetailsDao = rODetailsDao;
	}

	@Override
	@Transactional
	public boolean save(RODetails entity) {
		
		logger.info("Save: " + entity.toString()); 
		return  rODetailsDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(RODetails entity) {
		
		RODetails model = rODetailsDao.findById(entity.getId());
		
		model.setItem(entity.getItem());
		model.setQty(entity.getQty());
		model.setPrice(entity.getPrice());
		model.setAmount(entity.getAmount());
	
	    logger.info("Update: " + model.toString());
		 
		return  rODetailsDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(RODetails entity) {
		
		logger.info("Delete: id = " + entity.getId());
		
		return rODetailsDao.delete(entity);
	}

	@Override
	public RODetails findById(int id) {
		return rODetailsDao.findById(id);
	}

	@Override
	public List<RODetails> getListByROHeader(ROHeader roHeader) {
		return rODetailsDao.getListByROHeader(roHeader);
	}




}
