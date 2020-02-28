package com.drms.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drms.bo.PatientBo;
import com.drms.dao.PatientDao;
import com.drms.model.Patient;

@Service
public class PatientBoImpl implements PatientBo {
	
	private final static Logger logger = Logger.getLogger(PatientBoImpl.class);

	@Autowired
	PatientDao patientDao;
	
	public void setPatientDao(PatientDao patientDao){
		this.patientDao = patientDao;
	}

	@Override
	@Transactional
	public boolean save(Patient entity) {
		 
		 entity.setDateRegistered(new java.sql.Date(System.currentTimeMillis()));
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return patientDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(Patient entity) {
		
		 Patient model = patientDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setLastName(entity.getLastName());
		 model.setFirstName(entity.getFirstName());
		 model.setMiddleName(entity.getMiddleName());
		 model.setGender(entity.getGender());
		 model.setBirthday(entity.getBirthday());
		 model.setContactNo(entity.getContactNo());
		 model.setAddressLine1(entity.getAddressLine1());
		 model.setAddressLine2(entity.getAddressLine2());
		 model.setTown(entity.getTown());
		 model.setProvince(entity.getProvince());
		 model.setZipCode(entity.getZipCode());
		 model.setContactPerson(entity.getContactPerson());
		 model.setContactPersonNo(entity.getContactPersonNo());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return patientDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(Patient entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return patientDao.delete(entity);
	}

	@Override
	@Transactional
	public Patient findByPatientNo(String criteria) {
		return patientDao.findByPatientNo(criteria);
	}
	
	@Override
	@Transactional
	public Map<Object, Object> findByLastName(Map<Object,Object> mapCriteria) {
		return patientDao.findByLastName(mapCriteria);
	}
	
	@Override
	@Transactional
    public List<Patient> getAllEntity() {
        return patientDao.getAllEntity();
    }

	@Override
	@Transactional
	public Patient findById(int criteria) {
		return patientDao.findById(criteria);
	}

	@Override
	public long getPatientCount() {
		return patientDao.getPatientCount();
	}

}
