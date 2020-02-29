package com.sims.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sims.dao.ItemInventoryDao;
import com.sims.model.Item;
import com.sims.model.ItemInventory;
import com.sims.util.HibernateDaoUtil;

@Repository
public class ItemInventoryDaoImpl extends HibernateDaoUtil implements ItemInventoryDao{

	@Override
	public boolean save(ItemInventory entity) {
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
	public boolean update(ItemInventory entity) {
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
	public boolean delete(ItemInventory entity) {
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
	public List<ItemInventory> getAllEntity() {
		List<ItemInventory> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from ItemInventory order by item.description").list();
		 } catch (Exception e) {

		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@Override
	public ItemInventory findById(int criteria) {
		ItemInventory model = null;
		beginHibernateTransaction();
		try {
			model = session.get(ItemInventory.class, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@Override
	public List<ItemInventory> findByItem(Item criteria) {
		List<ItemInventory> list = new ArrayList<>();
		beginHibernateTransaction();
		try {
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<ItemInventory> query = builder.createQuery(ItemInventory.class);
			Root<ItemInventory> root = query.from(ItemInventory.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
						builder.and(builder.equal(root.get("item"), criteria), builder.equal(root.get("active"), true))
						);
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get("id")));

			Query<ItemInventory> q = session.createQuery(query);
		    list = q.list();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return list;
}

	@Override
	public boolean deleteByItem(Item criteria) {
		List<ItemInventory> list = null;
		beginHibernateTransaction();
		try {
			//Hibernate 5 below...
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<ItemInventory> query = builder.createQuery(ItemInventory.class);
			Root<ItemInventory> root = query.from(ItemInventory.class);
			query.select(root);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					builder.equal(root.get("item"), criteria));
			query.where(predicates.toArray(new Predicate[predicates.size()]));

			Query<ItemInventory> q = session.createQuery(query);
		    list = q.list();
		    
			for (ItemInventory itemInv: list) {
				itemInv.setActive(false);
				itemInv.setRemarks("Set to Inactive by Physical Inventory");
				itemInv.setModifiedBy(itemInv.getCreatedBy());
				itemInv.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
				itemInv.setVersion(itemInv.getVersion() + 1);
				session.update(itemInv);
			}
			tx.commit();
		 } catch (Exception e) {
			 tx.rollback();
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return txnIsSuccess;
	}


	
	
}
