package com.sims.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sims.dao.SalesHeaderDao;
import com.sims.model.SalesHeader;
import com.sims.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class SalesHeaderDaoImpl extends HibernateDaoUtil implements SalesHeaderDao{

	@Override
	public boolean save(SalesHeader entity) {
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
	public boolean update(SalesHeader entity) {
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
	public SalesHeader getEntityByTransNo(String transNo) {
		SalesHeader model = null;
		beginHibernateTransaction();
		try {
			
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<SalesHeader> query = builder.createQuery(SalesHeader.class);
			Root<SalesHeader> root = query.from(SalesHeader.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.equal(root.get("transNo"), transNo));
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			Query<SalesHeader> q = session.createQuery(query);
			List<SalesHeader> list = q.list();
			for (SalesHeader item: list) {
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
	
	@Override
	public long getTotalCount() {
		long count = 0;
		beginHibernateTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
		try {
			queryCount.select(builder.count(queryCount.from(SalesHeader.class)));
			Query<Long> qCount = session.createQuery(queryCount);
			count = qCount.getSingleResult();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return count;
	}

	@Override
	public SalesHeader findById(int criteria) {
		SalesHeader model = null;
		beginHibernateTransaction();
		try {
			model = session.get(SalesHeader.class, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@Override
	public boolean delete(SalesHeader entity) {
		beginHibernateTransaction();
		 try {
			 session.delete(entity);
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
