package com.sims.dao;

import java.util.List;

import com.sims.model.ItemInventory;
import com.sims.model.ItemInventoryDetails;

public interface ItemInventoryDetailsDao {

	boolean save(ItemInventoryDetails entity);
	boolean update(ItemInventoryDetails entity);
	boolean delete(ItemInventoryDetails entity);
	ItemInventoryDetails findById(int criteria);
	List<ItemInventoryDetails> findByItemInventory(ItemInventory criteria);
	List<ItemInventoryDetails> getAllEntity();
}
