package com.crms.bo;

import com.crms.model.PatientBill;

public interface PatientBillBo {

	boolean save(PatientBill entity);
	boolean update(PatientBill entity);
	PatientBill getPatientBill(int consultId);
}

