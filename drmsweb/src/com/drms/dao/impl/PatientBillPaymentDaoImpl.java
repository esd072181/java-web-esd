package com.drms.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.drms.dao.PatientBillPaymentDao;
import com.drms.model.PatientBill;
import com.drms.model.PatientBillPayment;
import com.drms.util.HibernateDaoUtil;

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

	@Override
	public PatientBillPayment getPatientBillPayment(int billId) {
		PatientBillPayment model = null;
		beginHibernateTransaction();
		try {
			
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PatientBillPayment> query = builder.createQuery(PatientBillPayment.class);
			Root<PatientBillPayment> root = query.from(PatientBillPayment.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.equal(root.get("patientBill"), new PatientBill(billId)));
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			Query<PatientBillPayment> q = session.createQuery(query);
			List<PatientBillPayment> list = q.list();
			for (PatientBillPayment item: list) {
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
