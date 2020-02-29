package com.sims.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.PhysicalInventoryBo;
import com.sims.dao.PhysicalInventoryDao;
import com.sims.model.PhysicalInventory;

@Service
public class PhysicalInventoryBoImpl implements PhysicalInventoryBo {
	
	private final static Logger logger = Logger.getLogger(PhysicalInventoryBoImpl.class);

	@Autowired
	PhysicalInventoryDao physicalInventoryDao;
	
	public void setPhysicalInventoryDao(PhysicalInventoryDao physicalInventoryDao){
		this.physicalInventoryDao = physicalInventoryDao;
	}

	@Override
	@Transactional
	public boolean save(PhysicalInventory entity) {
		 
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return physicalInventoryDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(PhysicalInventory entity) {
		
		 PhysicalInventory model = physicalInventoryDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setDateOfInventory(entity.getDateOfInventory());
		 model.setInventoryBy(entity.getInventoryBy());
		 model.setRemarks(entity.getRemarks());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return physicalInventoryDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(PhysicalInventory entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return physicalInventoryDao.delete(entity);
	}

	
	@Override
	@Transactional
    public List<PhysicalInventory> getAllEntity() {
        return physicalInventoryDao.getAllEntity();
    }

	@Override
	@Transactional
	public PhysicalInventory findById(int criteria) {
		return physicalInventoryDao.findById(criteria);
	}

	@Override
	@Transactional
	public Map<Object, Object> findByDateOfInventory(Map<Object, Object> mapCriteria) {
		return physicalInventoryDao.findByDateOfInventory(mapCriteria);
	}

	@Override
	public long getTotalCount() {
		return physicalInventoryDao.getTotalCount();
	}

	@Override
	public PhysicalInventory findByPINo(String criteria) {
		return physicalInventoryDao.findByPINo(criteria);
	}


}
