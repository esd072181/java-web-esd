package com.sims.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sims.model.UserAccount;

@Component
public class UserAccountValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return UserAccount.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "userName", "username.empty");
		ValidationUtils.rejectIfEmpty(err, "password", "password.empty");
		
	}

}
