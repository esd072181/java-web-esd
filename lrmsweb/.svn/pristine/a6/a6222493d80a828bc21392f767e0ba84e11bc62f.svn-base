package com.lrms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lrms.dao.PatientBloodChemDao;
import com.lrms.model.PatientBloodChem;
import com.lrms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientBloodChemDaoImpl extends HibernateDaoUtil implements PatientBloodChemDao{

	@Override
	public boolean saveOrUpdate(PatientBloodChem entity) {
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
	public PatientBloodChem findByPatientLabExamId(int id) {
		PatientBloodChem model = new PatientBloodChem();
		List<PatientBloodChem> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from PatientBloodChem where patientLabExam.id=" + id + "").list();
			for (PatientBloodChem item: list) {
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
