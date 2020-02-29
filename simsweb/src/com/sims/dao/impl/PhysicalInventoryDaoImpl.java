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

import com.sims.dao.PhysicalInventoryDao;
import com.sims.model.PhysicalInventory;
import com.sims.util.HibernateDaoUtil;
import com.sims.util.SIMSUtil;

@Repository
public class PhysicalInventoryDaoImpl extends HibernateDaoUtil implements PhysicalInventoryDao{

	@Override
	public boolean save(PhysicalInventory entity) {
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
	public boolean update(PhysicalInventory entity) {
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
	public boolean delete(PhysicalInventory entity) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<PhysicalInventory> getAllEntity() {
		List<PhysicalInventory> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from PhysicalInventory order by dateOfInventory").list();
		 } catch (Exception e) {

		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@Override
	public PhysicalInventory findById(int criteria) {
		PhysicalInventory model = null;
		beginHibernateTransaction();
		try {
			model = session.get(PhysicalInventory.class, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@Override
	public Map<Object, Object> findByDateOfInventory(Map<Object, Object> mapCriteria) {
		Map<Object, Object> mapResult = new HashMap<Object, Object>();
		beginHibernateTransaction();
		try {
			
			//Get the search criteria
			String searchCriteria = (String) mapCriteria.get("search_criteria");
			int recordStart = (Integer) mapCriteria.get("record_start");
			int maxResult = (Integer) mapCriteria.get("max_result");
			
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PhysicalInventory> query = builder.createQuery(PhysicalInventory.class);
			Root<PhysicalInventory> root = query.from(PhysicalInventory.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			if (!"01/01/1901".equals(searchCriteria)) {
				predicates.add(
						builder.and(
								builder.like(builder.upper(root.get("dateOfInventory")), "%" + searchCriteria.toUpperCase() + "%"),
								builder.equal(root.get("active"), true)));				
			} else {
				predicates.add(builder.equal(root.get("active"), true));				
			}
			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			query.orderBy(builder.desc(root.get("dateOfInventory")));
						
			Query<PhysicalInventory> q = session.createQuery(query);
			q.setFirstResult(recordStart); //Index start at 0 (first record)
			q.setMaxResults(maxResult);
			List<PhysicalInventory> list = q.list();
			
			//Get totalRecordsCount for pagination
			CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
			queryCount.select(builder.count(queryCount.from(PhysicalInventory.class)));
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

	@Override
	public long getTotalCount() {
		long count = 0;
		beginHibernateTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
		try {
			queryCount.select(builder.count(queryCount.from(PhysicalInventory.class)));
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
	public PhysicalInventory findByPINo(String criteria) {

		PhysicalInventory model = null;
		beginHibernateTransaction();
		try {
			
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PhysicalInventory> query = builder.createQuery(PhysicalInventory.class);
			Root<PhysicalInventory> root = query.from(PhysicalInventory.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.equal(builder.upper(root.get("piNo")), "" + criteria.toUpperCase() + ""));
			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

			Query<PhysicalInventory> q = session.createQuery(query);
			model = q.getSingleResult();

		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	
	}
	
	
}
