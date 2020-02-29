package com.sims.dao;

import java.util.List;
import java.util.Map;

import com.sims.model.PhysicalInventory;

public interface PhysicalInventoryDao {

	boolean save(PhysicalInventory entity);
	boolean update(PhysicalInventory entity);
	boolean delete(PhysicalInventory entity);
	PhysicalInventory findById(int criteria);
	List<PhysicalInventory> getAllEntity();
	Map<Object, Object> findByDateOfInventory(Map<Object, Object> mapCriteria);
	long getTotalCount();
	PhysicalInventory findByPINo(String criteria);
}
