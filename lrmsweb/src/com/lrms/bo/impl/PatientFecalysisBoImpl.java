package com.lrms.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrms.bo.PatientFecalysisBo;
import com.lrms.dao.PatientFecalysisDao;
import com.lrms.model.PatientFecalysis;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientFecalysisBoImpl implements PatientFecalysisBo{
	
	private final static Logger logger = Logger.getLogger(PatientFecalysisBoImpl.class);

	@Autowired
	PatientFecalysisDao patientFecalysisDao;
	
	public void setPatientFecalysisDao(PatientFecalysisDao patientFecalysisDao){
		this.patientFecalysisDao = patientFecalysisDao;
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(PatientFecalysis entity) {
		
		logger.info("Save: " + entity.toString());
		
		return  patientFecalysisDao.saveOrUpdate(entity);
	}

	@Override
	public PatientFecalysis findByPatientLabExamId(int id) {
		return patientFecalysisDao.findByPatientLabExamId(id);
	}

	
}
