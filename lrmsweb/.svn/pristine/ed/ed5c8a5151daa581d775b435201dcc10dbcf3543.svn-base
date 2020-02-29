package com.lrms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lrms.dao.PatientFecalysisDao;
import com.lrms.model.PatientFecalysis;
import com.lrms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientFecalysisDaoImpl extends HibernateDaoUtil implements PatientFecalysisDao{

	@Override
	public boolean saveOrUpdate(PatientFecalysis entity) {
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
	public PatientFecalysis findByPatientLabExamId(int id) {
		PatientFecalysis model = new PatientFecalysis();
		List<PatientFecalysis> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from PatientFecalysis where patientLabExam.id=" + id + "").list();
			for (PatientFecalysis item: list) {
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
