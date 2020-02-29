package com.sims.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sims.dao.SalesDetailsDao;
import com.sims.model.SalesDetails;
import com.sims.model.SalesHeader;
import com.sims.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class SalesDetailsDaoImpl extends HibernateDaoUtil implements SalesDetailsDao{

	@Override
	public boolean save(SalesDetails entity) {
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
	public boolean update(SalesDetails entity) {
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
	public boolean delete(SalesDetails entity) {
		beginHibernateTransaction();
		 try {
			 session.delete(entity); //Permanent delete for SalesDetails
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
	public List<SalesDetails> getListBySalesHeader(SalesHeader salesHeader) {
		List<SalesDetails> list = new ArrayList<>();
		beginHibernateTransaction();
		try {
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<SalesDetails> query = builder.createQuery(SalesDetails.class);
			Root<SalesDetails> root = query.from(SalesDetails.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.equal(root.get("salesHeader"), salesHeader));
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			Query<SalesDetails> q = session.createQuery(query);
		    list = q.list();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@Override
	public SalesDetails findById(int criteria) {
		SalesDetails model = null;
		beginHibernateTransaction();
		try {
			model = session.get(SalesDetails.class, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

//	@Override
//	public boolean deleteByHeader(SalesHeader salesHeader) {
//		beginHibernateTransaction();
//		 try {
//			 @SuppressWarnings("rawtypes")
//			 Query q = session.createQuery("delete SalesDetails where salesHeader = " + salesHeader.getId());
//			 q.executeUpdate();
//			 tx.commit();
//			 txnIsSuccess = true;
//		 } catch (Exception e) {
//			 tx.rollback();
//			 e.printStackTrace();
//		 } finally {
//			closeHibernateSession(session);
//		 }
//		 return txnIsSuccess;
//	}

}
