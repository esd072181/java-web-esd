package com.drms.bo;

import java.util.List;
import java.util.Map;

import com.drms.model.Patient;

public interface PatientBo {

	boolean save(Patient entity);
	boolean update(Patient entity);
	boolean delete(Patient entity);
	Patient findById(int criteria);
	Patient findByPatientNo(String criteria);
	Map<Object, Object> findByLastName(Map<Object,Object> mapCriteria);
	List<Patient> getAllEntity();
	long getPatientCount();
}

