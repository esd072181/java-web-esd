package com.sims.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.BrandBo;
import com.sims.dao.BrandDao;
import com.sims.model.Brand;

/**
 * 
 * @author dward
 *
 */
@Service
public class BrandBoImpl implements BrandBo {
	
	private final static Logger logger = Logger.getLogger(BrandBoImpl.class);

	@Autowired
	BrandDao brandDao;
	
	public void setBrandDao(BrandDao brandDao){
		this.brandDao = brandDao;
	}

	@Override
	@Transactional
	public boolean save(Brand entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return brandDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(Brand entity) {
		
		 Brand model = brandDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setName(entity.getName());
		 model.setDescription(entity.getDescription());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);

		 logger.info("Update: " + model.toString());
		 
		return brandDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(Brand entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);		
		
		logger.info("Delete: id = " + entity.getId());
		
		return brandDao.delete(entity);
	}

	@Override
	@Transactional
	public Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria) {
		return brandDao.findByDescription(mapCriteria);
	}
	
	@Override
	@Transactional
    public List<Brand> getAllEntity() {
        return brandDao.getAllEntity();
    }

	@Override
	@Transactional
	public Brand findById(int criteria) {
		return brandDao.findById(criteria);
	}

}
