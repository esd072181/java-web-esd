package com.sims.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sims.dao.ItemInventoryDetailsDao;
import com.sims.model.ItemInventory;
import com.sims.model.ItemInventoryDetails;
import com.sims.util.HibernateDaoUtil;

@Repository
public class ItemInventoryDetailsDaoImpl extends HibernateDaoUtil implements ItemInventoryDetailsDao{

	@Override
	public boolean save(ItemInventoryDetails entity) {
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
	public boolean update(ItemInventoryDetails entity) {
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
	public boolean delete(ItemInventoryDetails entity) {
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
	public List<ItemInventoryDetails> getAllEntity() {
		List<ItemInventoryDetails> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from ItemInventoryDetails order by id").list();
		 } catch (Exception e) {

		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

	@Override
	public ItemInventoryDetails findById(int criteria) {
		ItemInventoryDetails model = null;
		beginHibernateTransaction();
		try {
			model = session.get(ItemInventoryDetails.class, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemInventoryDetails> findByItemInventory(ItemInventory criteria) {
		List<ItemInventoryDetails> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from ItemInventoryDetails where itemInventory='" + criteria + "'").list();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}


	
	
}
