package com.drms.bo;

import com.drms.model.PatientBillPayment;

public interface PatientBillPaymentBo {

	boolean save(PatientBillPayment entity);
	PatientBillPayment getPatientBillPayment(int billId);
}

