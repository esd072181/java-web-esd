package com.sims.dao;

import java.util.Map;

import com.sims.model.POHeader;

/**
 * 
 * @author dward
 *
 */
public interface POHeaderDao {

	boolean save(POHeader entity);
	boolean update(POHeader entity);
	boolean delete(POHeader entity);
	Map<Object, Object> findBySupplierName(Map<Object, Object> mapCriteria);
	POHeader findById(int id);
	long getTotalCount();
	POHeader findByPONo(String criteria);
}
