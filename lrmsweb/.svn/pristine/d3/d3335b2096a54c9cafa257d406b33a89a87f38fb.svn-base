package com.lrms.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrms.bo.PatientUrinalysisBo;
import com.lrms.dao.PatientUrinalysisDao;
import com.lrms.model.PatientUrinalysis;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientUrinalysisBoImpl implements PatientUrinalysisBo{
	
	private final static Logger logger = Logger.getLogger(PatientUrinalysisBoImpl.class);

	@Autowired
	PatientUrinalysisDao patientUrinalysisDao;
	
	public void setPatientUrinalysisDao(PatientUrinalysisDao patientUrinalysisDao){
		this.patientUrinalysisDao = patientUrinalysisDao;
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(PatientUrinalysis entity) {	
		
		logger.info("Save: " + entity.toString());
		
		return  patientUrinalysisDao.saveOrUpdate(entity);
	}

	@Override
	public PatientUrinalysis findByPatientLabExamId(int id) {
		return patientUrinalysisDao.findByPatientLabExamId(id);
	}

	
}
