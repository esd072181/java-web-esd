package com.drms.bo;

import com.drms.model.PatientBill;

public interface PatientBillBo {

	boolean save(PatientBill entity);
	boolean update(PatientBill entity);
	PatientBill getPatientBill(int consultId);
}

