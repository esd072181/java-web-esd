package com.sims.bo;

import java.util.List;
import java.util.Map;

import com.sims.model.Supplier;

/**
 * 
 * @author dward
 *
 */
public interface SupplierBo {

	boolean save(Supplier entity);
	boolean update(Supplier entity);
	boolean delete(Supplier entity);
	Supplier findById(int criteria);
	Map<Object, Object> findByName(Map<Object,Object> mapCriteria);
	List<Supplier> getAllEntity();
}
