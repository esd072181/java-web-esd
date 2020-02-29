package com.lrms.dao;


import com.lrms.model.PatientHematology;

/**
 * 
 * @author dward
 *
 */
public interface PatientHematologyDao {

	boolean saveOrUpdate(PatientHematology entity);
	PatientHematology findByPatientLabExamId(int id);
}
