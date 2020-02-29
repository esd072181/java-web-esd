package com.crms.dao;

import com.crms.model.PatientBill;

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
