package com.lrms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lrms.dao.PatientHematologyDao;
import com.lrms.model.PatientHematology;
import com.lrms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientHematologyDaoImpl extends HibernateDaoUtil implements PatientHematologyDao{

	@Override
	public boolean saveOrUpdate(PatientHematology entity) {
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
	public PatientHematology findByPatientLabExamId(int id) {
		PatientHematology model = new PatientHematology();
		List<PatientHematology> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from PatientHematology where patientLabExam.id=" + id + "").list();
			for (PatientHematology item: list) {
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
