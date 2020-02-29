package com.pibs.bo.impl;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.pibs.bo.LoginBo;
import com.pibs.dao.LoginDao;
import com.pibs.model.User;

public class LoginBoImpl implements LoginBo {
	
	LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
    @Transactional
	public Map<String, Object> validateUserAccount(User user) throws Exception{
		// TODO Auto-generated method stub
		return loginDao.validateUserAccount(user);
	}

	
	
}
