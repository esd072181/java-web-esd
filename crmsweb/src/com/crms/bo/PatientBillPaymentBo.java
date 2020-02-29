package com.crms.bo;

import com.crms.model.PatientBillPayment;

public interface PatientBillPaymentBo {

	boolean save(PatientBillPayment entity);
	PatientBillPayment getPatientBillPayment(int billId);
}

