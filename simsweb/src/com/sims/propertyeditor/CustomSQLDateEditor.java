package com.sims.propertyeditor;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;

import com.sims.util.DateUtils;

public class CustomSQLDateEditor extends CustomDateEditor {
	
	private final static Logger logger = Logger.getLogger(CustomSQLDateEditor.class);
	
	public CustomSQLDateEditor(DateFormat dateFormat, boolean allowEmpty) {
		super(dateFormat, allowEmpty);
	}
	
	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		String dateStr = null;
		try {
			if (getValue()!=null) {
				dateStr = DateUtils.sqlDateToString((Date)getValue());	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateStr;
	}

	@Override
	public void setAsText(String dateStr) throws IllegalArgumentException {
		if (StringUtils.isEmpty(dateStr)) {
			setValue(null);
		} else {
			//check if it in valid MM/dd/yyyy format
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				java.util.Date utilDate = sdf.parse(dateStr);	
				//if no error then proceed... it is a valid date format MM/dd/yyyy
				setValue(new Date(utilDate.getTime()));
			} catch (Exception e) {
				logger.debug("Invalid date format (MM/dd/yyyy)");
				try {
					setValue(DateUtils.strToSQLDate("01/01/1901"));	//this is for the validator default value
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}			
		}
	}
	
	

}
