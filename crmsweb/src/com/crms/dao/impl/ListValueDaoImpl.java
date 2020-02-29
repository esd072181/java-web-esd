package com.crms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crms.dao.ListValueDao;
import com.crms.model.ListValue;
import com.crms.util.HibernateDaoUtil;

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
