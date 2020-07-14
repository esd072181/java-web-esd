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

import com.sims.dao.BrandDao;
import com.sims.model.Brand;
import com.sims.util.SIMSUtil;
import com.sims.util.HibernateDaoUtil;

/**
 * 
 * @author dward
 *
 */
@Repository
public class BrandDaoImpl extends HibernateDaoUtil implements BrandDao{

	@Override
	public boolean save(Brand entity) {
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
	public boolean update(Brand entity) {
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
	public boolean delete(Brand entity) {
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
	public Map<Object, Object> findByDescription(Map<Object, Object> mapCriteria) {
		
		Map<Object, Object> mapResult = new HashMap<Object, Object>();
		beginHibernateTransaction();
		try {
			
			//Get the search criteria
			String searchCriteria = (String) mapCriteria.get("search_criteria");
			int recordStart = (Integer) mapCriteria.get("record_start");
			int maxResult = (Integer) mapCriteria.get("max_result");
			
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Brand> query = builder.createQuery(Brand.class);
			Root<Brand> root = query.from(Brand.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.and(
							builder.like(builder.lower(root.get("name")), "%" + searchCriteria.toLowerCase() + "%"),
							builder.equal(root.get("active"), true)));
			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			query.orderBy(builder.asc(root.get("name")));
						
			Query<Brand> q = session.createQuery(query);
			q.setFirstResult(recordStart); //Index start at 0 (first record)
			q.setMaxResults(maxResult);
			List<Brand> list = q.list();
			
			//Get totalRecordsCount for pagination
			CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
			queryCount.select(builder.count(queryCount.from(Brand.class)));
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
	public List<Brand> getAllEntity() {
		List<Brand> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from Brand where active = true order by name").list();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@Override
	public Brand findById(int criteria) {
		Brand model = null;
		beginHibernateTransaction();
		try {
			model = session.get(Brand.class, criteria);		
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	
}
