package com.drms.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drms.bo.PatientMedBo;
import com.drms.dao.PatientMedDao;
import com.drms.model.PatientMed;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientMedBoImpl implements PatientMedBo{
	
	private final static Logger logger = Logger.getLogger(PatientMedBoImpl.class);

	@Autowired
	PatientMedDao patientMedDao;
	
	public void setPatientMedDao(PatientMedDao patientMedDao){
		this.patientMedDao = patientMedDao;
	}

	@Override
	@Transactional
	public boolean save(PatientMed entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return  patientMedDao.save(entity);
	}

	@Override
	public PatientMed findById(int id) {
		return patientMedDao.findById(id);
	}

	@Override
	public boolean delete(PatientMed entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);
		
		logger.info("Delete: id = " + entity.getId());
		
		return patientMedDao.delete(entity);
	}



}
