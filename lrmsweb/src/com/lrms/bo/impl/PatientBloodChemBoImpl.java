package com.lrms.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrms.bo.PatientBloodChemBo;
import com.lrms.dao.PatientBloodChemDao;
import com.lrms.model.PatientBloodChem;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientBloodChemBoImpl implements PatientBloodChemBo{

	private final static Logger logger = Logger.getLogger(PatientBloodChemBoImpl.class);
	
	@Autowired
	PatientBloodChemDao patientBloodChemDao;
	
	public void setPatientBloodChemDao(PatientBloodChemDao patientBloodChemDao){
		this.patientBloodChemDao = patientBloodChemDao;
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(PatientBloodChem entity) {		
		
		logger.info("Save: " + entity.toString());
		
		return  patientBloodChemDao.saveOrUpdate(entity);
	}

	@Override
	public PatientBloodChem findByPatientLabExamId(int id) {
		return patientBloodChemDao.findByPatientLabExamId(id);
	}

	
}
