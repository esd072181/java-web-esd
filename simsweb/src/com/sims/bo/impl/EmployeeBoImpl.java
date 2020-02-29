package com.sims.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.bo.EmployeeBo;
import com.sims.dao.EmployeeDao;
import com.sims.model.Employee;

@Service
public class EmployeeBoImpl implements EmployeeBo {
	
	private final static Logger logger = Logger.getLogger(EmployeeBo.class);

	@Autowired
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao){
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public boolean save(Employee entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return employeeDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(Employee entity) {
		
		Employee model = employeeDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setEmpType(entity.getEmpType());
		 model.setLastName(entity.getLastName());
		 model.setFirstName(entity.getFirstName());
		 model.setMiddleName(entity.getMiddleName());
		 model.setGender(entity.getGender());
		 model.setContactNo(entity.getContactNo());
		 model.setAddress(entity.getAddress());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);
		 
		 logger.info("Update: " + model.toString());
		 
		return employeeDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(Employee entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return employeeDao.delete(entity);
	}
	
	@Override
	@Transactional
	public Map<Object, Object> findByLastName(Map<Object,Object> mapCriteria) {
		return employeeDao.findByLastName(mapCriteria);
	}
	

	@Override
	@Transactional
	public Employee findById(int criteria) {
		return employeeDao.findById(criteria);
	}


	@Override
	public List<Employee> getAllWithNoUserAccount() {
		return employeeDao.getAllWithNoUserAccount();
	}

}
