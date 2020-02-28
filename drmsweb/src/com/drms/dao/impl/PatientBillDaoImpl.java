package com.drms.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.drms.dao.PatientBillDao;
import com.drms.model.PatientBill;
import com.drms.model.PatientConsultation;
import com.drms.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PatientBillDaoImpl extends HibernateDaoUtil implements PatientBillDao{

	@Override
	public boolean save(PatientBill entity) {
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
	public boolean update(PatientBill entity) {
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
	
	@Override
	public PatientBill getPatientBill(int consultId) {
		PatientBill model = null;
		beginHibernateTransaction();
		try {
			
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PatientBill> query = builder.createQuery(PatientBill.class);
			Root<PatientBill> root = query.from(PatientBill.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.equal(root.get("patientConsultation"), new PatientConsultation(consultId)));
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			Query<PatientBill> q = session.createQuery(query);
			List<PatientBill> list = q.list();
			for (PatientBill item: list) {
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
