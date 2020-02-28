package com.drms.bo;

import java.util.Map;

import com.drms.model.PatientConsultation;

public interface PatientConsultationBo {

	boolean save(PatientConsultation entity);
	boolean update(PatientConsultation entity);
	long getRecordCount();
	PatientConsultation getPatientConsultation(String consultNo);
	Map<Object, Object> findByName(Map<Object,Object> mapCriteria);
	PatientConsultation findById(Integer id);
}

