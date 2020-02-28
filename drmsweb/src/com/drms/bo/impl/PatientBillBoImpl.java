package com.drms.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drms.bo.PatientBillBo;
import com.drms.dao.PatientBillDao;
import com.drms.model.PatientBill;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientBillBoImpl implements PatientBillBo{
	
	private final static Logger logger = Logger.getLogger(PatientBillBoImpl.class);

	@Autowired
	PatientBillDao patientBillDao;
	
	public void setPatientBillDao(PatientBillDao patientBillDao){
		this.patientBillDao = patientBillDao;
	}

	@Override
	@Transactional
	public boolean save(PatientBill entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return  patientBillDao.save(entity);
	}

	@Override
	public PatientBill getPatientBill(int consultId) {
		return patientBillDao.getPatientBill(consultId);
	}

	@Override
	public boolean update(PatientBill entity) {	
		
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);
		 
		return patientBillDao.update(entity);
	}



}
