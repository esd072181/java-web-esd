package com.sims.dao;

import com.sims.model.SalesHeader;

/**
 * 
 * @author dward
 *
 */
public interface SalesHeaderDao {

	boolean save(SalesHeader entity);
	boolean update(SalesHeader entity);
	boolean delete(SalesHeader entity);
	SalesHeader getEntityByTransNo(String transNo);
	SalesHeader findById(int criteria);
	long getTotalCount();
}
