package com.crms.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.crms.model.LabExam;

@Component
public class LabExamValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return LabExam.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(err, "description", "description.empty");		
		
	}

}
