package com.crms.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crms.bo.PatientLabExamBo;
import com.crms.dao.PatientLabExamDao;
import com.crms.model.PatientLabExam;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientLabExamBoImpl implements PatientLabExamBo{
	
	private final static Logger logger = Logger.getLogger(PatientLabExamBoImpl.class);

	@Autowired
	PatientLabExamDao patientLabExamDao;
	
	public void setPatientLabExamDao(PatientLabExamDao patientLabExamDao){
		this.patientLabExamDao = patientLabExamDao;
	}

	@Override
	@Transactional
	public boolean save(PatientLabExam entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return  patientLabExamDao.save(entity);
	}

	@Override
	public PatientLabExam findById(int id) {
		return patientLabExamDao.findById(id);
	}

	@Override
	public boolean delete(PatientLabExam entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);
		
		logger.info("Delete: id = " + entity.getId());
		
		return patientLabExamDao.delete(entity);
	}



}
