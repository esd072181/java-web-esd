package com.sims.dao;

import java.util.List;
import java.util.Map;

import com.sims.model.Category;

/**
 * 
 * @author dward
 *
 */
public interface CategoryDao {

	boolean save(Category entity);
	boolean update(Category entity);
	boolean delete(Category entity);
	Category findById(int criteria);
	Map<Object, Object> findByDescription(Map<Object, Object> mapCriteria);
	List<Category> getAllEntity();
}
