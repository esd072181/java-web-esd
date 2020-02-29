package com.sims.dao;

import com.sims.model.ROHeader;

/**
 * 
 * @author dward
 *
 */
public interface ROHeaderDao {

	boolean save(ROHeader entity);
	boolean update(ROHeader entity);
	boolean delete(ROHeader entity);
	ROHeader findById(int id);
}
