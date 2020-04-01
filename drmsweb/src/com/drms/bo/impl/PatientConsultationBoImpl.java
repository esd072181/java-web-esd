package com.drms.bo.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drms.bo.PatientBillBo;
import com.drms.bo.PatientConsultationBo;
import com.drms.dao.PatientConsultationDao;
import com.drms.model.ListValue;
import com.drms.model.PatientBill;
import com.drms.model.PatientConsultation;

/**
 * 
 * @author dward
 * @since Jan2019
 * DateUpdated: 01Apr2020
 */
@Service
public class PatientConsultationBoImpl implements PatientConsultationBo {

	@Autowired
	PatientConsultationDao patientConsultationDao;
	@Autowired
	PatientBillBo patientBillBo;
	
	public void setPatientConsultationDao(PatientConsultationDao patientConsultationDao){
		this.patientConsultationDao = patientConsultationDao;
	}

	@Override
	@Transactional
	public boolean save(PatientConsultation entity) {
		 boolean transactionStatus = false;
		 entity.setConsultDate(new java.sql.Date(System.currentTimeMillis()));
		 entity.setStatus(new ListValue(201));//Default to In-Progress Status
		 entity.setPaymentStatus(new ListValue(301));//Default to Pending Status
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 if (patientConsultationDao.save(entity)) {
			     PatientConsultation model = getPatientConsultation(entity.getConsultNo());
				 //save the bill
				 PatientBill billModel = new PatientBill();
				 billModel.setPatientConsultation(model);
				 billModel.setConsultFee(model.getProfessional().getFee()!=null ? model.getProfessional().getFee() : new BigDecimal(0));
				 billModel.setTotalBill(model.getProfessional().getFee()!=null ? model.getProfessional().getFee() : new BigDecimal(0));
				 billModel.setDateProcessed(new java.sql.Timestamp(System.currentTimeMillis()));
				 billModel.setCleared(false);//default to false
				 billModel.setCreatedBy(entity.getCreatedBy());
				 
				 transactionStatus = patientBillBo.save(billModel);
			 }
		 
		return transactionStatus;
	}

	@Override
	public long getRecordCount() {
		return patientConsultationDao.getRecordCount();
	}

	@Override
	public PatientConsultation getPatientConsultation(String consultNo) {
		return patientConsultationDao.getPatientConsultation(consultNo);
	}

	@Override
	public Map<Object, Object> findByName(Map<Object, Object> mapCriteria) {
		return patientConsultationDao.findByName(mapCriteria);
	}

	@Override
	public PatientConsultation findById(Integer id) {
		return patientConsultationDao.findById(id);
	}

	@Override
	public boolean update(PatientConsultation entity) {
		
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);
		
		return patientConsultationDao.update(entity);
	}

	@Override
	public Map<Object, Object> findByPatientSystemId(Map<Object, Object> mapCriteria) {
		return patientConsultationDao.findByPatientSystemId(mapCriteria);
	}


}
