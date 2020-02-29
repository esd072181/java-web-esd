package com.crms.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crms.bo.UserAccountBo;
import com.crms.dao.UserAccountDao;
import com.crms.model.UserAccount;
import com.crms.util.EncryptUtil;

@Service
public class UserAccountBoImpl implements UserAccountBo {
	
	private final static Logger logger = Logger.getLogger(UserAccountBoImpl.class);

	@Autowired
	UserAccountDao userAccountDao;
	
	public void setUserAccountDao(UserAccountDao userAccountDao){
		this.userAccountDao = userAccountDao;
	}

	@Override
	public List<UserAccount> getAll() {
		return userAccountDao.getAll();
	}

	@Override
	@Transactional
	public boolean save(UserAccount entity) {
		
		try {
			entity.setPassword(EncryptUtil.encrypt(entity.getPassword()));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(1);
		entity.setActive(true);
		
		logger.info("Save: " + entity.toString());
		 
		return userAccountDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(UserAccount entity) {
		
		UserAccount model = userAccountDao.findById(entity.getId());	
		
		try {
			//update the fields of the model
			 model.setRole(entity.getRole());
			 model.setUserName(entity.getUserName());
			 model.setPassword(EncryptUtil.encrypt(entity.getPassword()));
			 model.setModifiedBy(entity.getModifiedBy());
			 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
			 model.setVersion(model.getVersion() + 1);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		logger.info("Update: " + model.toString());
		
		return userAccountDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(UserAccount entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);	
		
		logger.info("Delete: id = " + entity.getId());
		
		return userAccountDao.delete(entity);
	}

	@Override
	@Transactional
	public UserAccount findById(int criteria) {
		
		UserAccount model = userAccountDao.findById(criteria);
		try {
			model.setPassword(EncryptUtil.decrypt(model.getPassword()));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}

	@Override
	@Transactional
	public UserAccount findByUserNamePassword(String userName, String password) {
		return userAccountDao.findByUserNamePassword(userName, password);
	}

	@Override
	@Transactional
	public Map<Object, Object> findBy(Map<Object, Object> mapCriteria) {
		return userAccountDao.findBy(mapCriteria);
	}
	

}
