package com.pibs.bo;

import java.util.Map;

import com.pibs.model.User;

public interface LoginBo {

	public Map<String, Object> validateUserAccount(User user) throws Exception;
}
