package com.sims.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sims.dao.PhysicalInventoryDetailsDao;
import com.sims.model.Item;
import com.sims.model.PhysicalInventoryDetails;
import com.sims.model.PhysicalInventory;
import com.sims.util.HibernateDaoUtil;

@Repository
public class PhysicalInventoryDetailsDaoImpl extends HibernateDaoUtil implements PhysicalInventoryDetailsDao{

	@Override
	public boolean save(PhysicalInventoryDetails entity) {
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
	public boolean update(PhysicalInventoryDetails entity) {
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
	public boolean delete(PhysicalInventoryDetails entity) {
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
	public PhysicalInventoryDetails findById(int criteria) {
		PhysicalInventoryDetails model = null;
		beginHibernateTransaction();
		try {
			model = session.get(PhysicalInventoryDetails.class, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhysicalInventoryDetails> findByPhysicalInventory(PhysicalInventory criteria) {
		List<PhysicalInventoryDetails> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from PhysicalInventoryDetails where physicalInventory='" + criteria + "'").list();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@Override
	public boolean deleteByPhysicalInventoryAndItem(PhysicalInventory pi, Item item) {
		List<PhysicalInventoryDetails> list = null;
		beginHibernateTransaction();
		try {
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PhysicalInventoryDetails> query = builder.createQuery(PhysicalInventoryDetails.class);
			Root<PhysicalInventoryDetails> root = query.from(PhysicalInventoryDetails.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.and(builder.equal(root.get("physicalInventory"), pi),builder.equal(root.get("item"), item)));
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			Query<PhysicalInventoryDetails> q = session.createQuery(query);
		    list = q.list();
		    
			for (PhysicalInventoryDetails piDetails: list) {
				piDetails.setActive(false);
				piDetails.setModifiedBy(piDetails.getCreatedBy());
				piDetails.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
				piDetails.setVersion(piDetails.getVersion() + 1);
				session.update(piDetails);
				tx.commit();
			}
		 } catch (Exception e) {
			 tx.rollback();
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return txnIsSuccess;
	}


	
	
}
