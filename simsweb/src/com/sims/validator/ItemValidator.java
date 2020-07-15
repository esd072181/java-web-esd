package com.sims.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sims.model.Item;
//import com.sims.util.DateUtils;

/**
 * 
 * @author edwarddavid
 * @since Sep2017
 * DateUpdated: 15Jul2020
 */
@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Item.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(err, "description", "description.empty");
		ValidationUtils.rejectIfEmpty(err, "itemCode", "itemcode.empty");
		
		
//		Item item  = (Item) obj;
//		
//		try {
//			if (item.getManufacturedDate()!=null && DateUtils.sqlDateToString(item.getManufacturedDate()).equals("01/01/1901")) {
//				err.rejectValue("manufacturedDate", "date.invalid.format");
//			}	
//			if (item.getExpiryDate()!=null && DateUtils.sqlDateToString(item.getExpiryDate()).equals("01/01/1901")) {
//				err.rejectValue("manufacturedDate", "date.invalid.format");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		
	}

}
