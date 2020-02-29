package com.crms.bo;

import com.crms.model.PatientLabExam;

public interface PatientLabExamBo {

	boolean save(PatientLabExam entity);
	boolean delete(PatientLabExam entity);
	PatientLabExam findById(int id);
}

