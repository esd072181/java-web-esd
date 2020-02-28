package com.drms.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.drms.model.Professional;

@Component
public class ProfessionalValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Professional.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "lastName", "lastname.empty");
		ValidationUtils.rejectIfEmpty(err, "firstName", "firstname.empty");
	}

}
