package com.lrms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lrms.dao.PatientUrinalysisDao;
import com.lrms.model.PatientUrinalysis;
import com.lrms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientUrinalysisDaoImpl extends HibernateDaoUtil implements PatientUrinalysisDao{

	@Override
	public boolean saveOrUpdate(PatientUrinalysis entity) {
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
	public PatientUrinalysis findByPatientLabExamId(int id) {
		PatientUrinalysis model = new PatientUrinalysis();
		List<PatientUrinalysis> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from PatientUrinalysis where patientLabExam.id=" + id + "").list();
			for (PatientUrinalysis item: list) {
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
