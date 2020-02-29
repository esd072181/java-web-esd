package com.crms.dao;

import java.util.List;
import java.util.Map;

import com.crms.model.UserAccount;

public interface UserAccountDao {

	boolean save(UserAccount entity);
	boolean update(UserAccount entity);
	boolean delete(UserAccount criteria);
	UserAccount findById(int criteria);
	UserAccount findByUserNamePassword(String userName, String password);
	Map<Object, Object> findBy(Map<Object,Object> mapCriteria);
	List<UserAccount> getAll();
}

