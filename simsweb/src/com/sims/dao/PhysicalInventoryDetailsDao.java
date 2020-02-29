package com.sims.dao;

import java.util.List;

import com.sims.model.Item;
import com.sims.model.PhysicalInventory;
import com.sims.model.PhysicalInventoryDetails;

public interface PhysicalInventoryDetailsDao {

	boolean save(PhysicalInventoryDetails entity);
	boolean update(PhysicalInventoryDetails entity);
	boolean delete(PhysicalInventoryDetails entity);
	PhysicalInventoryDetails findById(int criteria);
	List<PhysicalInventoryDetails> findByPhysicalInventory(PhysicalInventory criteria);
	boolean deleteByPhysicalInventoryAndItem(PhysicalInventory pi, Item item);
}
