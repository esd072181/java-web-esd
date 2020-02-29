package com.sims.bo.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.ItemInventoryBo;
import com.sims.dao.ItemInventoryDao;
import com.sims.model.Item;
import com.sims.model.ItemInventory;

@Service
public class ItemInventoryBoImpl implements ItemInventoryBo {
	
	private final static Logger logger = Logger.getLogger(ItemInventoryBoImpl.class);

	@Autowired
	ItemInventoryDao itemInventoryDao;
	
	public void setItemInventoryDao(ItemInventoryDao itemInventoryDao){
		this.itemInventoryDao = itemInventoryDao;
	}

	@Override
	@Transactional
	public boolean save(ItemInventory entity) {
		 
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return itemInventoryDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(ItemInventory entity) {
		
		 ItemInventory model = itemInventoryDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setRetailPrice(entity.getRetailPrice());
		 model.setWholesalePrice(entity.getWholesalePrice());
		 model.setStockOnHand(entity.getStockOnHand());
		 model.setRemarks(entity.getRemarks());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return itemInventoryDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(ItemInventory entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return itemInventoryDao.delete(entity);
	}

	
	@Override
	@Transactional
    public List<ItemInventory> getAllEntity() {
        return itemInventoryDao.getAllEntity();
    }

	@Override
	@Transactional
	public ItemInventory findById(int criteria) {
		return itemInventoryDao.findById(criteria);
	}

	@Override
	public List<ItemInventory> findByItem(Item criteria) {
		return itemInventoryDao.findByItem(criteria);
	}

	@Override
	public boolean deleteByItem(Item criteria) {
		return itemInventoryDao.deleteByItem(criteria);
	}


}
