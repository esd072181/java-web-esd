package com.drms.dao.impl;


import org.springframework.stereotype.Repository;

import com.drms.dao.PatientMedDao;
import com.drms.model.PatientMed;
import com.drms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientMedDaoImpl extends HibernateDaoUtil implements PatientMedDao{

	@Override
	public boolean save(PatientMed entity) {
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
	
	@Override
	public PatientMed findById(int criteria) {
		PatientMed model = null;
		beginHibernateTransaction();
		try {
			model = session.get(PatientMed.class, criteria);		
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@Override
	public boolean delete(PatientMed entity) {
		beginHibernateTransaction();
		 try {			 
			 session.update(entity);
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
