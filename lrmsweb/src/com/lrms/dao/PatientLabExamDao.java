package com.lrms.dao;

import com.lrms.model.PatientLabExam;

/**
 * 
 * @author dward
 *
 */
public interface PatientLabExamDao {

	boolean save(PatientLabExam entity);
	boolean delete(PatientLabExam entity);
	PatientLabExam findById(int id);
}
