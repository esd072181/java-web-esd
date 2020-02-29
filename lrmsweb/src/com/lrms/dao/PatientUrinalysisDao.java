package com.lrms.dao;


import com.lrms.model.PatientUrinalysis;

/**
 * 
 * @author dward
 *
 */
public interface PatientUrinalysisDao {

	boolean saveOrUpdate(PatientUrinalysis entity);
	PatientUrinalysis findByPatientLabExamId(int id);
}
