package com.sims.dao;

import java.util.List;
import java.util.Map;

import com.sims.model.Item;

public interface ItemDao {

	boolean save(Item entity);
	boolean update(Item entity);
	boolean delete(Item entity);
	Item findById(int criteria);
	Item findByItemCode(String criteria);
	Map<Object, Object> findByDescription(Map<Object, Object> mapCriteria);
	List<Item> getAllEntity();
	long getItemCount();
}
