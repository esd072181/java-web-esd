package com.crms.bo;

import java.util.Map;

import com.crms.model.PatientConsultation;

/**
 * 
 * @author edwarddavid
 * @since Jan2019
 * DateUpdated: 02Apr2020
 */
public interface PatientConsultationBo {

	boolean save(PatientConsultation entity);
	boolean update(PatientConsultation entity);
	long getRecordCount();
	PatientConsultation getPatientConsultation(String consultNo);
	Map<Object, Object> findByName(Map<Object,Object> mapCriteria);
	Map<Object, Object> findByPatientSystemId(Map<Object,Object> mapCriteria);
	PatientConsultation findById(Integer id);
}

