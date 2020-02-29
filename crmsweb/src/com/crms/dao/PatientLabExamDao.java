package com.crms.dao;

import com.crms.model.PatientLabExam;

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
