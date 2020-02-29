package com.sims.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.SubCategoryBo;
import com.sims.dao.SubCategoryDao;
import com.sims.model.SubCategory;

/**
 * 
 * @author dward
 *
 */
@Service
public class SubCategoryBoImpl implements SubCategoryBo {
	
	private final static Logger logger = Logger.getLogger(SubCategoryBoImpl.class);

	@Autowired
	SubCategoryDao subCategoryDao;
	
	public void setLabExamDao(SubCategoryDao subCategoryDao){
		this.subCategoryDao = subCategoryDao;
	}

	@Override
	@Transactional
	public boolean save(SubCategory entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return subCategoryDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(SubCategory entity) {
		
		 SubCategory model = subCategoryDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setCategory(entity.getCategory());
		 model.setName(entity.getName());
		 model.setDescription(entity.getDescription());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);

		 logger.info("Update: " + model.toString());
		 
		return subCategoryDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(SubCategory entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);		
		
		logger.info("Delete: id = " + entity.getId());
		
		return subCategoryDao.delete(entity);
	}

	@Override
	@Transactional
	public Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria) {
		return subCategoryDao.findByDescription(mapCriteria);
	}
	
	@Override
	@Transactional
    public List<SubCategory> getAllEntity() {
        return subCategoryDao.getAllEntity();
    }

	@Override
	@Transactional
	public SubCategory findById(int criteria) {
		return subCategoryDao.findById(criteria);
	}

}
