package com.transport.bo;

import java.util.Map;

import com.transport.model.User;

public interface LoginBo {

	Map<String, Object> validateUserAccount(User user) throws Exception;
}
