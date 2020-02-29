package com.lrms.dao.impl;


import org.springframework.stereotype.Repository;

import com.lrms.dao.PatientBillPaymentDao;
import com.lrms.model.PatientBillPayment;
import com.lrms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientBillPaymentDaoImpl extends HibernateDaoUtil implements PatientBillPaymentDao{

	@Override
	public boolean save(PatientBillPayment entity) {
		beginHibernateTransaction();
		 try {			 
			 session.save(entity);
			 tx.commit();
			 txnIsSuccess = true;
		 } catch (Exception e) {
			 tx.rollback();
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		 return txnIsSuccess;
	}
	
}
