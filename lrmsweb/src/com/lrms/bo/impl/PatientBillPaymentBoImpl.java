package com.lrms.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lrms.bo.PatientBillPaymentBo;
import com.lrms.dao.PatientBillPaymentDao;
import com.lrms.model.PatientBillPayment;

/**
 * 
 * @author dward
 *
 */
@Service
public class PatientBillPaymentBoImpl implements PatientBillPaymentBo{
	
	@Autowired
	PatientBillPaymentDao patientBillPaymentDao;

	
	public void setPatientBillPaymentDao(PatientBillPaymentDao patientBillPaymentDao){
		this.patientBillPaymentDao = patientBillPaymentDao;
	}

	@Override
	@Transactional
	public boolean save(PatientBillPayment entity) {
		 
		 entity.setDateOfPayment(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 		 
		return  patientBillPaymentDao.save(entity);
	}



}
