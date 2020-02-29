package com.crms.dao.impl;

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

import com.crms.dao.ProfessionalDao;
import com.crms.model.Professional;
import com.crms.util.CRMSUtil;
import com.crms.util.HibernateDaoUtil;

@Repository
public class ProfessionalDaoImpl extends HibernateDaoUtil implements ProfessionalDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> getAllPhysician() {
		List<Professional> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from Professional where professionaltypeid = 101").list();
		 } catch (Exception e) {

		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> getAllNonPhysician() {
		List<Professional> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from Professional where professionaltypeid <> 101").list();
		 } catch (Exception e) {

		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	
	@Override
	public boolean save(Professional entity) {
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
	public boolean update(Professional entity) {
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
	public boolean delete(Professional entity) {
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
	public Map<Object, Object> findByLastName(Map<Object, Object> mapCriteria) {
		
		Map<Object, Object> mapResult = new HashMap<Object, Object>();
		beginHibernateTransaction();
		try {
			
			//Get the search criteria
			String searchCriteria = (String) mapCriteria.get("search_criteria");
			int recordStart = (Integer) mapCriteria.get("record_start");
			int maxResult = (Integer) mapCriteria.get("max_result");
			
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Professional> query = builder.createQuery(Professional.class);
			Root<Professional> root = query.from(Professional.class);
			query.select(root);
			//query.select(root.get("patientNo")); //This is for selecting specific columns/fields
//			query.where(builder.and(builder.like(root.get("patientNo"), "%" + criteria + "%"), builder.equal(root.get("active"), true)));
			//or can use predicates
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.and(
							builder.or(builder.like(builder.upper(root.get("lastName")), "%" + searchCriteria.toUpperCase() + "%"), builder.like(builder.upper(root.get("firstName")), "%" + searchCriteria.toUpperCase() + "%")),
							builder.equal(root.get("active"), true)));
//			predicates.add(builder.and(builder.equal(root.get("lastName"), "David"))); //can add more criteria
			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			query.orderBy(builder.asc(root.get("lastName")), builder.asc(root.get("firstName")), builder.asc(root.get("middleName")));
			
			Query<Professional> q = session.createQuery(query);
			q.setFirstResult(recordStart); //Index start at 0 (first record)
			q.setMaxResults(maxResult);
			List<Professional> list2 = q.list();

			//Get totalRecordsCount for pagination
			CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
			queryCount.select(builder.count(queryCount.from(Professional.class)));
			queryCount.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			Query<Long> qCount = session.createQuery(queryCount);
			long totalNoOfRecords = qCount.getSingleResult();
			
			if (!list2.isEmpty()) {
				mapResult.put("resultList", list2);
			}
			
			mapResult.put("noOfPages", CRMSUtil.getTotalNoOfPages(totalNoOfRecords)); //need to query in hibernate total no of records / pagination size
			
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return mapResult;
	}

	@Override
	public Professional findById(int criteria) {
		Professional model = null;
		beginHibernateTransaction();
		try {
			model = session.get(Professional.class, criteria);
		
			//code below for calling namedquery setup in entity/model for function/stored procedure
//			Query query = session.getNamedQuery("callRetrievePatientFunction")
//						.setParameter("id", criteria);
//				List result = query.list();
//				for (Object obj: result) {
//					model = (PatientEntity) obj;
//				}
		
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> getAllWithNoUserAccount() {
		List<Professional> list = null;
//		List<Professional> filteredList = null;
		List<Integer> profIdWithUserAccountList = new ArrayList<>();
		beginHibernateTransaction();
		try {
			list = session.createQuery("from Professional where active = true").list();
//			filteredList = list;
			for(Professional item: list) {
				item.getUserAccountList();
				if (item.getUserAccountList().size() > 0) {
					profIdWithUserAccountList.add(item.getId());	
				}
			}
			
			for (Integer itemId: profIdWithUserAccountList) {
				for(Professional item: list) {
					if (itemId == item.getId()) {
						list.remove(item);
						break;
					}
				}
			}
			
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

}
