package com.lrms.bo;

import java.util.Map;

import com.lrms.model.PatientLabRequest;

public interface PatientLabRequestBo {

	boolean save(PatientLabRequest entity);
	boolean update(PatientLabRequest entity);
	long getRecordCount();
	PatientLabRequest getPatientLabRequest(String labRequestNo);
	Map<Object, Object> findByName(Map<Object,Object> mapCriteria);
	PatientLabRequest findById(Integer id);
}

