package com.drms.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateDaoUtil {
	
	protected Session session;
	protected Transaction tx;
	protected boolean txnIsSuccess;
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	protected Session getHibernateSession() {
		session = sessionFactory.openSession();
		return session;
	}
	
	protected void beginHibernateTransaction() {
		tx = getHibernateSession().beginTransaction();
	}
	
	protected void closeHibernateSession(Session session) {
		session.close();
	}
	
	
	
}
