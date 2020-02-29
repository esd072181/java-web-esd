package com.sims.bo.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.PhysicalInventoryDetailsBo;
import com.sims.dao.PhysicalInventoryDetailsDao;
import com.sims.model.Item;
import com.sims.model.PhysicalInventory;
import com.sims.model.PhysicalInventoryDetails;

@Service
public class PhysicalInventoryDetailsBoImpl implements PhysicalInventoryDetailsBo {
	
	private final static Logger logger = Logger.getLogger(PhysicalInventoryDetailsBoImpl.class);

	@Autowired
	PhysicalInventoryDetailsDao physicalInventoryDetailsDao;
	
	public void setPhysicalInventoryDetailsDao(PhysicalInventoryDetailsDao physicalInventoryDetailsDao){
		this.physicalInventoryDetailsDao = physicalInventoryDetailsDao;
	}

	@Override
	@Transactional
	public boolean save(PhysicalInventoryDetails entity) {
		 
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return physicalInventoryDetailsDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(PhysicalInventoryDetails entity) {
		
		 PhysicalInventoryDetails model = physicalInventoryDetailsDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setSystemQty(entity.getSystemQty());
		 model.setPhysicalCount(entity.getPhysicalCount());
		 model.setQtyVariance(entity.getQtyVariance());
		 model.setVariance(entity.getVariance());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return physicalInventoryDetailsDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(PhysicalInventoryDetails entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return physicalInventoryDetailsDao.delete(entity);
	}

	@Override
	@Transactional
	public PhysicalInventoryDetails findById(int criteria) {
		return physicalInventoryDetailsDao.findById(criteria);
	}

	@Override
	public List<PhysicalInventoryDetails> findByPhysicalInventory(PhysicalInventory criteria) {
		return physicalInventoryDetailsDao.findByPhysicalInventory(criteria);
	}

	@Override
	public boolean deleteByPhysicalInventoryAndItem(PhysicalInventory pi, Item item) {
		return physicalInventoryDetailsDao.deleteByPhysicalInventoryAndItem(pi, item);
	}


}
