package com.sims.bo;

import java.util.List;
import java.util.Map;

import com.sims.model.Category;

/**
 * 
 * @author dward
 *
 */
public interface MedicineBo {

	boolean save(Category entity);
	boolean update(Category entity);
	boolean delete(int criteria);
	Category findById(int criteria);
	Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria);
	List<Category> getAllEntity();
}
