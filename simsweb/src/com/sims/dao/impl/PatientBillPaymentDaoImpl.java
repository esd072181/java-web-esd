package com.sims.dao.impl;


import org.springframework.stereotype.Repository;

import com.sims.dao.PatientBillPaymentDao;
import com.sims.model.PatientBillPayment;
import com.sims.util.HibernateDaoUtil;

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
