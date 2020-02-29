package com.lrms.dao;

import java.util.List;
import java.util.Map;

import com.lrms.model.Professional;

public interface ProfessionalDao {

	boolean save(Professional entity);
	boolean update(Professional entity);
	boolean delete(Professional entity);
	Professional findById(int criteria);
	Map<Object, Object> findByLastName(Map<Object, Object> mapCriteria);
	List<Professional> getAllPhysician();
	List<Professional> getAllNonPhysician();
	List<Professional> getAllWithNoUserAccount();
}
