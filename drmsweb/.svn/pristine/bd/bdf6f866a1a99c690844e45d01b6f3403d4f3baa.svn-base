package com.drms.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drms.bo.ProfessionalBo;
import com.drms.dao.ProfessionalDao;
import com.drms.model.Professional;

@Service
public class ProfessionalBoImpl implements ProfessionalBo {
	
	private final static Logger logger = Logger.getLogger(ProfessionalBo.class);

	@Autowired
	ProfessionalDao professionalDao;
	
	public void setProfessionalDao(ProfessionalDao professionalDao){
		this.professionalDao = professionalDao;
	}

	@Override
	public List<Professional> getAllPhysician() {
		return professionalDao.getAllPhysician();
	}

	@Override
	@Transactional
	public boolean save(Professional entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return professionalDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(Professional entity) {
		
		Professional model = professionalDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setProfessionalType(entity.getProfessionalType());
		 model.setDesignation(entity.getDesignation());
		 model.setLastName(entity.getLastName());
		 model.setFirstName(entity.getFirstName());
		 model.setMiddleName(entity.getMiddleName());
		 model.setGender(entity.getGender());
		 model.setFee(entity.getFee());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return professionalDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(Professional entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return professionalDao.delete(entity);
	}
	
	@Override
	@Transactional
	public Map<Object, Object> findByLastName(Map<Object,Object> mapCriteria) {
		return professionalDao.findByLastName(mapCriteria);
	}
	

	@Override
	@Transactional
	public Professional findById(int criteria) {
		return professionalDao.findById(criteria);
	}

	@Override
	public List<Professional> getAllNonPhysician() {
		return professionalDao.getAllNonPhysician();
	}

	@Override
	public List<Professional> getAllWithNoUserAccount() {
		return professionalDao.getAllWithNoUserAccount();
	}

}
