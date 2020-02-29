package com.crms.dao;

import com.crms.model.PatientBillPayment;

/**
 * 
 * @author dward
 *
 */
public interface PatientBillPaymentDao {

	boolean save(PatientBillPayment entity);
	PatientBillPayment getPatientBillPayment(int billId);
}
