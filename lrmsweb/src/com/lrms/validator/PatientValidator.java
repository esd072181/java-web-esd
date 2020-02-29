package com.lrms.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lrms.model.Patient;
import com.lrms.util.DateUtils;

@Component
public class PatientValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Patient.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(err, "lastName", "lastname.empty");
		ValidationUtils.rejectIfEmpty(err, "firstName", "firstname.empty");
		
		Patient patient  = (Patient) obj;
		
		try {
			if (patient.getBirthday()!=null && DateUtils.sqlDateToString(patient.getBirthday()).equals("01/01/1901")) {
				err.rejectValue("birthday", "date.invalid.format");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
