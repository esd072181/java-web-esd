package com.lrms.dao.impl;

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

import com.lrms.dao.PatientDao;
import com.lrms.model.Patient;
import com.lrms.util.LRMSUtil;
import com.lrms.util.HibernateDaoUtil;

@Repository
public class PatientDaoImpl extends HibernateDaoUtil implements PatientDao{

	@Override
	public boolean save(Patient entity) {
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
	public boolean update(Patient entity) {
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
	public boolean delete(Patient entity) {
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
	public Patient findByPatientNo(String criteria) {
		Patient model = new Patient();
		List<Patient> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from Patient where patientNo='" + criteria + "'").list();
			for (Patient item: list) {
				model = item;
				break;
			}
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	
		
//		Map<Object, Object> mapResult = new HashMap<Object, Object>();
//		beginHibernateTransaction();
//		try {
////			@SuppressWarnings("rawtypes")
////			Query query = session.createQuery("from PatientEntity where patientNo like concat('%',:patientNo,'%') and active = true");
////			query.setParameter("patientNo", criteria);
////			@SuppressWarnings("unchecked")
////			List<PatientEntity> list = (List<PatientEntity>) query.list();
//			
//			@SuppressWarnings("deprecation")
////			Criteria crit = session.createCriteria(PatientEntity.class);
//////			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
////			crit.add(Restrictions.ilike("patientNo", "%"+criteria+"%"));
////			crit.add(Restrictions.eqOrIsNull("active", true));
////			crit.addOrder(Property.forName("lastName").asc());
////			crit.setFirstResult(0);
////			crit.setMaxResults(5); //still testing and not accurate
////
////			List<PatientEntity> list = crit.list();
//			
//			//test code esd
////			DetachedCriteria dc = DetachedCriteria.forClass(PatientEntity.class);
////			dc.add(Restrictions.ilike("patientNo", "%"+criteria+"%"));
////			dc.add(Restrictions.eqOrIsNull("active", true));
////			dc.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
//////			dc.setProjection(Projections.id());
////			//then create outer query
////			Criteria outer = session.createCriteria(PatientEntity.class);
////			outer.add(Subqueries.propertyIn("id", dc));
////			outer.setFirstResult(0);
////			outer.setMaxResults(5);
//////			
//////			
////			List<PatientEntity> list = outer.list();
//			
//			//Get the search criteria
//			String searchCriteria = (String) mapCriteria.get("search_criteria");
//			int recordStart = (Integer) mapCriteria.get("record_start");
//			int maxResult = (Integer) mapCriteria.get("max_result");
//			
//			//Hibernate 5 below...
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
//			Root<Patient> root = query.from(Patient.class);
//			query.select(root);
//			//query.select(root.get("patientNo")); //This is for selecting specific columns/fields
////			query.where(builder.and(builder.like(root.get("patientNo"), "%" + criteria + "%"), builder.equal(root.get("active"), true)));
//			//or can use predicates
//			List<Predicate> predicates = new ArrayList<>();
//			predicates.add(
//					builder.and(
//							builder.like(builder.upper(root.get("patientNo")), "" + searchCriteria.toUpperCase() + ""),
//							builder.equal(root.get("active"), true)));
////			predicates.add(builder.and(builder.equal(root.get("lastName"), "David"))); //can add more criteria
//			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
//			query.orderBy(builder.asc(root.get("lastName")), builder.asc(root.get("firstName")), builder.asc(root.get("middleName")));
//			
//			
//			Query<Patient> q = session.createQuery(query);
//			q.setFirstResult(recordStart); //Index start at 0 (first record)
//			q.setMaxResults(maxResult);
//			List<Patient> list2 = q.list();
//			
////			Set<PatientHistoryEntity> phSet = new HashSet<>();
////			for (PatientEntity p: list2) {
////				phSet =  p.getPatientHistoryRecords();	//LAZY Fetch
////				if (!phSet.isEmpty()) {
////					break;
////				}
////			}
////			System.out.println(phSet.size());
//			
//			//Get totalRecordsCount for pagination
//			CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
//			queryCount.select(builder.count(queryCount.from(Patient.class)));
//			queryCount.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
//			Query<Long> qCount = session.createQuery(queryCount);
//			long totalNoOfRecords = qCount.getSingleResult();
//			
//			if (!list2.isEmpty()) {
//				mapResult.put("resultList", list2);
//			}
//			
//			mapResult.put("noOfPages", LRMSUtil.getTotalNoOfPages(totalNoOfRecords)); //need to query in hibernate total no of records / pagination size
//			
//		 } catch (Exception e) {
//			 e.printStackTrace();
//		 } finally {
//			closeHibernateSession(session);
//		 }
//		return mapResult;
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
			CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
			Root<Patient> root = query.from(Patient.class);
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
			
			
			Query<Patient> q = session.createQuery(query);
			q.setFirstResult(recordStart); //Index start at 0 (first record)
			q.setMaxResults(maxResult);
			List<Patient> list2 = q.list();

			//Get totalRecordsCount for pagination
			CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
			queryCount.select(builder.count(queryCount.from(Patient.class)));
			queryCount.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			Query<Long> qCount = session.createQuery(queryCount);
			long totalNoOfRecords = qCount.getSingleResult();
			
			if (!list2.isEmpty()) {
				mapResult.put("resultList", list2);
			}
			
			mapResult.put("noOfPages", LRMSUtil.getTotalNoOfPages(totalNoOfRecords)); //need to query in hibernate total no of records / pagination size
			
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return mapResult;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getAllEntity() {
		List<Patient> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from Patient").list();
		 } catch (Exception e) {

		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@Override
	public Patient findById(int criteria) {
		Patient model = null;
		beginHibernateTransaction();
		try {
			model = session.get(Patient.class, criteria);
		
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

	@Override
	public long getPatientCount() {
		long count = 0;
		beginHibernateTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
		try {
			queryCount.select(builder.count(queryCount.from(Patient.class)));
			Query<Long> qCount = session.createQuery(queryCount);
			count = qCount.getSingleResult();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return count;
	}
	
	//Sample like
//	Session session = HibernateUtil.getSessionFactory().openSession();
//    Query query = session.createQuery("FROM Student WHERE studentName like concat('%',:studentName,'%')");
//    query.setParameter("studentName", likeStudentName);
//    List&lt;Student&gt; list = query.list();
//    if(list.size()==0)
//        return null;
//    return list;
	
}
