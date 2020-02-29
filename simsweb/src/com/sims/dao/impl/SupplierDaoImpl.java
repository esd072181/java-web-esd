package com.sims.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sims.dao.SupplierDao;
import com.sims.model.Supplier;
import com.sims.util.SIMSUtil;
import com.sims.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class SupplierDaoImpl extends HibernateDaoUtil implements SupplierDao{

	@Override
	public boolean save(Supplier entity) {
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
	public boolean update(Supplier entity) {
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
	public boolean delete(Supplier entity) {
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
	public Map<Object, Object> findByName(Map<Object, Object> mapCriteria) {
		
		Map<Object, Object> mapResult = new HashMap<Object, Object>();
		beginHibernateTransaction();
		try {
			
			//Get the search criteria
			String searchCriteria = (String) mapCriteria.get("search_criteria");
			int recordStart = (Integer) mapCriteria.get("record_start");
			int maxResult = (Integer) mapCriteria.get("max_result");
			
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Supplier> query = builder.createQuery(Supplier.class);
			Root<Supplier> root = query.from(Supplier.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.and(
							builder.like(builder.lower(root.get("name")), "%" + searchCriteria.toLowerCase() + "%"),
							builder.equal(root.get("active"), true)));
			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			query.orderBy(builder.asc(root.get("name")));
						
			Query<Supplier> q = session.createQuery(query);
			q.setFirstResult(recordStart); //Index start at 0 (first record)
			q.setMaxResults(maxResult);
			List<Supplier> list = q.list();
			
			//Get totalRecordsCount for pagination
			CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
			queryCount.select(builder.count(queryCount.from(Supplier.class)));
			queryCount.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			Query<Long> qCount = session.createQuery(queryCount);
			long totalNoOfRecords = qCount.getSingleResult();
			
			if (!list.isEmpty()) {
				mapResult.put("resultList", list);
			}
			
			mapResult.put("noOfPages", SIMSUtil.getTotalNoOfPages(totalNoOfRecords)); //need to query in hibernate total no of records / pagination size
			
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return mapResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getAllEntity() {
		List<Supplier> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from Supplier where active = true order by name").list();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@Override
	public Supplier findById(int criteria) {
		Supplier model = null;
		beginHibernateTransaction();
		try {
			model = session.get(Supplier.class, criteria);		
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	
}
