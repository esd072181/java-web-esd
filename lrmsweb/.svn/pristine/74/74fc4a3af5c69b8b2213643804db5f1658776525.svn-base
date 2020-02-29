package com.lrms.dao.impl;


import org.springframework.stereotype.Repository;

import com.lrms.dao.PatientLabExamDao;
import com.lrms.model.PatientLabExam;
import com.lrms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientLabExamDaoImpl extends HibernateDaoUtil implements PatientLabExamDao{

	@Override
	public boolean save(PatientLabExam entity) {
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
	public PatientLabExam findById(int criteria) {
		PatientLabExam model = null;
		beginHibernateTransaction();
		try {
			model = session.get(PatientLabExam.class, criteria);		
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@Override
	public boolean delete(PatientLabExam entity) {
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
