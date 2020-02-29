package com.sims.bo;

import java.util.List;
import java.util.Map;

import com.sims.model.UserAccount;

public interface UserAccountBo {

	boolean save(UserAccount entity);
	boolean update(UserAccount entity);
	boolean delete(UserAccount entity);
	UserAccount findById(int criteria);
	UserAccount findByUserNamePassword(String userName, String password);
	Map<Object, Object> findBy(Map<Object,Object> mapCriteria);
	List<UserAccount> getAll();
}

