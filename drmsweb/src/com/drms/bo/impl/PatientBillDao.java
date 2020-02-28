package com.drms.bo.impl;

import com.drms.model.PatientBill;

/**
 * 
 * @author dward
 *
 */
public interface PatientBillDao {

	boolean save(PatientBill entity);
	boolean update(PatientBill entity);
	PatientBill getPatientBill(int consultId);
}
