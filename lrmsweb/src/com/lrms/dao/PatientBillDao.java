package com.lrms.dao;

import com.lrms.model.PatientBill;

/**
 * 
 * @author dward
 *
 */
public interface PatientBillDao {

	boolean save(PatientBill entity);
	boolean update(PatientBill entity);
	PatientBill getPatientBill(int labRequestId);
}
