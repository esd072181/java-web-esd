package com.sims.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sims.model.PhysicalInventory;
import com.sims.util.DateUtils;

@Component
public class PhysicalInventoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return PhysicalInventory.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(err, "dateOfInventory", "dateofinventory.empty");
		
		PhysicalInventory model  = (PhysicalInventory) obj;
		
		try {
			if (model.getDateOfInventory()!=null && DateUtils.sqlDateToString(model.getDateOfInventory()).equals("01/01/1901")) {
				err.rejectValue("dateOfInventory", "date.invalid.format");
			}	

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
