package com.sims.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.SupplierBo;
import com.sims.dao.SupplierDao;
import com.sims.model.Supplier;

/**
 * 
 * @author dward
 *
 */
@Service
public class SupplierBoImpl implements SupplierBo {
	
	private final static Logger logger = Logger.getLogger(SupplierBoImpl.class);

	@Autowired
	SupplierDao supplierDao;
	
	public void setLabExamDao(SupplierDao supplierDao){
		this.supplierDao = supplierDao;
	}

	@Override
	@Transactional
	public boolean save(Supplier entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return supplierDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(Supplier entity) {
		
		 Supplier model = supplierDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setName(entity.getName());
		 model.setAddress(entity.getAddress());
		 model.setContactPerson(entity.getContactPerson());
		 model.setContactNo(entity.getContactNo());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);

		 logger.info("Update: " + model.toString());
		 
		return supplierDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(Supplier entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);		
		
		logger.info("Delete: id = " + entity.getId());
		
		return supplierDao.delete(entity);
	}

	@Override
	@Transactional
	public Map<Object, Object> findByName(Map<Object,Object> mapCriteria) {
		return supplierDao.findByName(mapCriteria);
	}
	
	@Override
	@Transactional
    public List<Supplier> getAllEntity() {
        return supplierDao.getAllEntity();
    }

	@Override
	@Transactional
	public Supplier findById(int criteria) {
		return supplierDao.findById(criteria);
	}

}
