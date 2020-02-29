package com.sims.bo;

import java.util.List;

import com.sims.model.Item;
import com.sims.model.ItemInventory;

public interface ItemInventoryBo {

	boolean save(ItemInventory entity);
	boolean update(ItemInventory entity);
	boolean delete(ItemInventory entity);
	boolean deleteByItem(Item criteria);
	ItemInventory findById(int criteria);
	List<ItemInventory> getAllEntity();
	List<ItemInventory> findByItem(Item criteria);
}

