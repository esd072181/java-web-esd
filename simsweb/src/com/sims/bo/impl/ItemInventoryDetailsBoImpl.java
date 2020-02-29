package com.sims.bo.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.ItemInventoryDetailsBo;
import com.sims.dao.ItemInventoryDetailsDao;
import com.sims.model.ItemInventory;
import com.sims.model.ItemInventoryDetails;

@Service
public class ItemInventoryDetailsBoImpl implements ItemInventoryDetailsBo {
	
	private final static Logger logger = Logger.getLogger(ItemInventoryDetailsBoImpl.class);

	@Autowired
	ItemInventoryDetailsDao itemInventoryDetailsDao;
	
	public void setItemInventoryDetailsDao(ItemInventoryDetailsDao itemInventoryDetailsDao){
		this.itemInventoryDetailsDao = itemInventoryDetailsDao;
	}

	@Override
	@Transactional
	public boolean save(ItemInventoryDetails entity) {
		 
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return itemInventoryDetailsDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(ItemInventoryDetails entity) {
		
		 ItemInventoryDetails model = itemInventoryDetailsDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setPhysicalQty(entity.getPhysicalQty());
		 model.setInQty(entity.getInQty());
		 model.setOutQty(entity.getOutQty());
		 model.setUpdatedQty(entity.getUpdatedQty());
		 model.setModule(entity.getModule());
		 model.setTransRefNo(entity.getTransRefNo());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return itemInventoryDetailsDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(ItemInventoryDetails entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return itemInventoryDetailsDao.delete(entity);
	}

	
	@Override
	@Transactional
    public List<ItemInventoryDetails> getAllEntity() {
        return itemInventoryDetailsDao.getAllEntity();
    }

	@Override
	@Transactional
	public ItemInventoryDetails findById(int criteria) {
		return itemInventoryDetailsDao.findById(criteria);
	}

	@Override
	public List<ItemInventoryDetails> findByItemInventory(ItemInventory criteria) {
		return itemInventoryDetailsDao.findByItemInventory(criteria);
	}


}
