package com.lrms.bo;

import com.lrms.model.PatientUrinalysis;

/**
 * 
 * @author dward
 *
 */
public interface PatientUrinalysisBo {

	boolean saveOrUpdate(PatientUrinalysis entity);
	PatientUrinalysis findByPatientLabExamId(int id);
}
