package com.sims.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sims.dao.RODetailsDao;
import com.sims.model.RODetails;
import com.sims.model.ROHeader;
import com.sims.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class RODetailsDaoImpl extends HibernateDaoUtil implements RODetailsDao{

	@Override
	public boolean save(RODetails entity) {
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
	public RODetails findById(int criteria) {
		RODetails model = null;
		beginHibernateTransaction();
		try {
			model = session.get(RODetails.class, criteria);		
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@Override
	public boolean delete(RODetails entity) {
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
	public boolean update(RODetails entity) {
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
	public List<RODetails> getListByROHeader(ROHeader roHeader) {
			List<RODetails> list = new ArrayList<>();
			beginHibernateTransaction();
			try {
				//Hibernate 5 below...
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<RODetails> query = builder.createQuery(RODetails.class);
				Root<RODetails> root = query.from(RODetails.class);
				query.select(root);
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(
						builder.equal(root.get("roHeader"), roHeader));
				query.where(predicates.toArray(new Predicate[predicates.size()]));

				Query<RODetails> q = session.createQuery(query);
			    list = q.list();
			 } catch (Exception e) {
				 e.printStackTrace();
			 } finally {
				closeHibernateSession(session);
			 }
			return list;
	}
	
}
