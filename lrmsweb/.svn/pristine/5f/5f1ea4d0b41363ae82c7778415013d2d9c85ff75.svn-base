package com.lrms.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrms.bo.PatientHematologyBo;
import com.lrms.dao.PatientHematologyDao;
import com.lrms.model.PatientHematology;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientHematologyBoImpl implements PatientHematologyBo{
	
	private final static Logger logger = Logger.getLogger(PatientHematologyBoImpl.class);

	@Autowired
	PatientHematologyDao patientHematologyDao;
	
	public void setPatientHematologyDao(PatientHematologyDao patientHematologyDao){
		this.patientHematologyDao = patientHematologyDao;
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(PatientHematology entity) {
		
		logger.info("Save: " + entity.toString());
		
		return  patientHematologyDao.saveOrUpdate(entity);
	}

	@Override
	public PatientHematology findByPatientLabExamId(int id) {
		return patientHematologyDao.findByPatientLabExamId(id);
	}

	
}
