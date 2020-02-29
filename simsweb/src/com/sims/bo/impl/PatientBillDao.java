package com.sims.bo.impl;

import com.sims.model.SalesHeader;

/**
 * 
 * @author dward
 *
 */
public interface PatientBillDao {

	boolean save(SalesHeader entity);
	boolean update(SalesHeader entity);
	SalesHeader getPatientBill(int consultId);
}
