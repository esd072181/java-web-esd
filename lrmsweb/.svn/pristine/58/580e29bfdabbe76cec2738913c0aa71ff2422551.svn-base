package com.lrms.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrms.bo.PatientMiscBo;
import com.lrms.dao.PatientMiscDao;
import com.lrms.model.PatientMisc;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientMiscBoImpl implements PatientMiscBo{
	
	private final static Logger logger = Logger.getLogger(PatientMiscBoImpl.class);

	@Autowired
	PatientMiscDao patientMiscDao;
	
	public void setPatientMiscDao(PatientMiscDao patientMiscDao){
		this.patientMiscDao = patientMiscDao;
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(PatientMisc entity) {
		
		logger.info("Save: " + entity.toString());
		
		return  patientMiscDao.saveOrUpdate(entity);
	}

	@Override
	public PatientMisc findByPatientLabExamId(int id) {
		return patientMiscDao.findByPatientLabExamId(id);
	}

	
}
