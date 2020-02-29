package com.sims.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.CategoryBo;
import com.sims.dao.CategoryDao;
import com.sims.model.Category;

/**
 * 
 * @author dward
 *
 */
@Service
public class CategoryBoImpl implements CategoryBo {
	
	private final static Logger logger = Logger.getLogger(CategoryBoImpl.class);

	@Autowired
	CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}

	@Override
	@Transactional
	public boolean save(Category entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return categoryDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(Category entity) {
		
		 Category model = categoryDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setName(entity.getName());
		 model.setDescription(entity.getDescription());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);

		 logger.info("Update: " + model.toString());
		 
		return categoryDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(Category entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);		
		
		logger.info("Delete: id = " + entity.getId());
		
		return categoryDao.delete(entity);
	}

	@Override
	@Transactional
	public Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria) {
		return categoryDao.findByDescription(mapCriteria);
	}
	
	@Override
	@Transactional
    public List<Category> getAllEntity() {
        return categoryDao.getAllEntity();
    }

	@Override
	@Transactional
	public Category findById(int criteria) {
		return categoryDao.findById(criteria);
	}

}
