package com.sims.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sims.dao.ListValueDao;
import com.sims.model.ListValue;
import com.sims.util.HibernateDaoUtil;

@Repository
public class ListValueDaoImpl extends HibernateDaoUtil implements ListValueDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ListValue> getAllLOV() {
		List<ListValue> list = null;
		beginHibernateTransaction();
		try {
			list = session.createQuery("from ListValue").list();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			closeHibernateSession(session);
		 }
		return list;
	}

}
