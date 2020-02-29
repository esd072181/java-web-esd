package com.lrms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lrms.dao.PatientMiscDao;
import com.lrms.model.PatientMisc;
import com.lrms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientMiscDaoImpl extends HibernateDaoUtil implements PatientMiscDao{

	@Override
	public boolean saveOrUpdate(PatientMisc entity) {
		beginHibernateTransaction();
		 try {			 
			 session.saveOrUpdate(entity);
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

	@SuppressWarnings("unchecked")
	@Override
	public PatientMisc findByPatientLabExamId(int id) {
		PatientMisc model = new PatientMisc();
		List<PatientMisc> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from PatientMisc where patientLabExam.id=" + id + "").list();
			for (PatientMisc item: list) {
				model = item;
				break;
			}
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

}
