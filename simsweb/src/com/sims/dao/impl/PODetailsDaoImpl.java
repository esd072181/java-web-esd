package com.sims.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sims.dao.PODetailsDao;
import com.sims.model.PODetails;
import com.sims.model.POHeader;
import com.sims.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class PODetailsDaoImpl extends HibernateDaoUtil implements PODetailsDao{

	@Override
	public boolean save(PODetails entity) {
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
	public PODetails findById(int criteria) {
		PODetails model = null;
		beginHibernateTransaction();
		try {
			model = session.get(PODetails.class, criteria);		
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@Override
	public boolean delete(PODetails entity) {
		beginHibernateTransaction();
		 try {			 
			 session.delete(entity); //permanent delete for PODetails
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
	public boolean update(PODetails entity) {
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
	public List<PODetails> getListByPOHeader(POHeader poHeader) {
			List<PODetails> list = new ArrayList<>();
			beginHibernateTransaction();
			try {
				//Hibernate 5 below...
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<PODetails> query = builder.createQuery(PODetails.class);
				Root<PODetails> root = query.from(PODetails.class);
				query.select(root);
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(
						builder.equal(root.get("poHeader"), poHeader));
				query.where(predicates.toArray(new Predicate[predicates.size()]));

				Query<PODetails> q = session.createQuery(query);
			    list = q.list();
			 } catch (Exception e) {
				 e.printStackTrace();
			 } finally {
				closeHibernateSession(session);
			 }
			return list;
	}
	
}
