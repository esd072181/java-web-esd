package com.lrms.bo;

import com.lrms.model.PatientBill;

public interface PatientBillBo {

	boolean save(PatientBill entity);
	boolean update(PatientBill entity);
	PatientBill getPatientBill(int labRequestId);
}

