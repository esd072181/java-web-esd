package com.sims.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.ItemBo;
import com.sims.dao.ItemDao;
import com.sims.model.Item;

@Service
public class ItemBoImpl implements ItemBo {
	
	private final static Logger logger = Logger.getLogger(ItemBoImpl.class);

	@Autowired
	ItemDao itemDao;
	
	public void setPatientDao(ItemDao itemDao){
		this.itemDao = itemDao;
	}

	@Override
	@Transactional
	public boolean save(Item entity) {
		 
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return itemDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(Item entity) {
		
		 Item model = itemDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setItemCode(entity.getItemCode());
		 model.setDescription(entity.getDescription());
		 model.setType(entity.getType());
		 model.setBrand(entity.getBrand());
		 model.setCategory(entity.getCategory());
		 model.setSubCategory(entity.getSubCategory());
		 model.setUom(entity.getUom());
		 model.setRetailOrigPrice(entity.getRetailOrigPrice());
		 model.setRetailMarkupPercent(entity.getRetailMarkupPercent());
		 model.setRetailMarkupPrice(entity.getRetailMarkupPrice());
		 model.setRetailSellingPrice(entity.getRetailSellingPrice());
		 model.setWholesaleOrigPrice(entity.getWholesaleOrigPrice());
		 model.setWholesaleMarkupPercent(entity.getWholesaleMarkupPercent());
		 model.setWholesaleMarkupPrice(entity.getWholesaleMarkupPrice());
		 model.setWholesaleSellingPrice(entity.getWholesaleSellingPrice());
		 model.setDiscountPercent(entity.getDiscountPercent());
		 model.setDiscountAmount(entity.getDiscountAmount());
		 model.setManufacturedDate(entity.getManufacturedDate());
		 model.setExpiryDate(entity.getExpiryDate());
		 model.setCriticalLevel(entity.getCriticalLevel());
		 model.setOptimumLevel(entity.getOptimumLevel());
		 model.setMaximumLevel(entity.getMaximumLevel());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return itemDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(Item entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return itemDao.delete(entity);
	}

	@Override
	@Transactional
	public Item findByItemCode(String criteria) {
		return itemDao.findByItemCode(criteria);
	}
	
	@Override
	@Transactional
	public Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria) {
		return itemDao.findByDescription(mapCriteria);
	}
	
	@Override
	@Transactional
    public List<Item> getAllEntity() {
        return itemDao.getAllEntity();
    }

	@Override
	@Transactional
	public Item findById(int criteria) {
		return itemDao.findById(criteria);
	}

	@Override
	public long getItemCount() {
		return itemDao.getItemCount();
	}

}
