package com.drms.dao;

import java.util.Map;

import com.drms.model.PatientConsultation;

/**
 * 
 * @author dward
 * @since Jan2019
 * Date Updated: 01Apr2020
 */
public interface PatientConsultationDao {

	boolean save(PatientConsultation entity);
	boolean update(PatientConsultation entity);
	long getRecordCount();
	PatientConsultation getPatientConsultation(String consultNo);
	Map<Object, Object> findByPatientSystemId(Map<Object,Object> mapCriteria);
	Map<Object, Object> findByName(Map<Object,Object> mapCriteria);
    PatientConsultation findById(Integer id);
}
