package com.drms.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Period;

import org.springframework.ui.ModelMap;

import com.drms.constant.DRMSConstant;

/**
 * 
 * @author edwarddavid
 * @since Feb2019
 * DateUpdated: 09May2020
 */
public class DRMSUtil {
	
	public static int getRecordStartIndex(int page) {
		return (page-1) * DRMSConstant.RECORDS_PER_PAGE; 	
	}
	
	public static int getTotalNoOfPages(long totalNoOfRecords) {
		return (int) Math.ceil(totalNoOfRecords * 1.0 / DRMSConstant.RECORDS_PER_PAGE);
	}
	
	public static int getAge(java.time.LocalDate dob) {
		java.time.LocalDate curDate = java.time.LocalDate.now();
		return Period.between(dob, curDate).getYears();
	}
	
	public static boolean isUserSessionValid(ModelMap model) {
		return model.get("userid")!=null;
	}
	
	public static Integer getUserIdFromSession(ModelMap model) {
		return model.get("userid")!=null ? Integer.parseInt(model.get("userid").toString()) : 0;
	}

	/**
	 * 
	 * @param numStr
	 * @return
	 * @throws ParseException
	 */
	public static Double convertNumStrWithCommaToDouble(String numStr) throws ParseException{
		NumberFormat format = NumberFormat.getInstance();
		Number num = format.parse(numStr);
		return num.doubleValue();
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 * @throws NumberFormatException
	 */
	public static String convertBigDecimalToStrWithComma(BigDecimal num) throws NumberFormatException{
		NumberFormat numfFormat = NumberFormat.getInstance();
		return numfFormat.format(num.doubleValue());
	}
	
	/**
	 * 
	 * @param amount
	 * @return
	 */
	public static String convertDoubleToStr(Double amount) {
		DecimalFormat f = new DecimalFormat("###,###.00");
		return f.format(BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	
	

}
