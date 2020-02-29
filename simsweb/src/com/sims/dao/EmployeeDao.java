package com.sims.dao;

import java.util.List;
import java.util.Map;

import com.sims.model.Employee;

public interface EmployeeDao {

	boolean save(Employee entity);
	boolean update(Employee entity);
	boolean delete(Employee entity);
	Employee findById(int criteria);
	Map<Object, Object> findByLastName(Map<Object, Object> mapCriteria);
	List<Employee> getAllWithNoUserAccount();
}
