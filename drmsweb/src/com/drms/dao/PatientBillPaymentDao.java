package com.drms.dao;

import com.drms.model.PatientBillPayment;

/**
 * 
 * @author dward
 *
 */
public interface PatientBillPaymentDao {

	boolean save(PatientBillPayment entity);
	PatientBillPayment getPatientBillPayment(int billId);
}
