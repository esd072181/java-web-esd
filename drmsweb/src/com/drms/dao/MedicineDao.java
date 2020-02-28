package com.drms.dao;

import java.util.List;
import java.util.Map;

import com.drms.model.Medicine;

/**
 * 
 * @author dward
 *
 */
public interface MedicineDao {

	boolean save(Medicine entity);
	boolean update(Medicine entity);
	boolean delete(Medicine entity);
	Medicine findById(int criteria);
	Map<Object, Object> findByDescription(Map<Object, Object> mapCriteria);
	List<Medicine> getAllEntity();
}
