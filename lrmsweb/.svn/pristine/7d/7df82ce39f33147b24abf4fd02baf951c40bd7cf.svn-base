package com.lrms.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class DateUtils {
	
	/**
	 * format: MM/dd/yyyy (String)
	 * @param sqlDate
	 * @return
	 * @throws Exception
	 */
	public static String sqlDateToString(Date sqlDate) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(sqlDate);
	}
	
	/**
	 * format: yyyy-MM-dd (String)
	 * @param sqlDate
	 * @return
	 * @throws Exception
	 */
	public static String sqlDateToStringSQL(Date sqlDate) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(sqlDate);
	}
	
	/**
	 * format: SQL Date
	 * @param strDate
	 * @return
	 * @throws Exception
	 */
	public static Date strToSQLDate(String strDate) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date utilDate = sdf.parse(strDate);	
		Date sqlDate = new Date(utilDate.getTime());
		return sqlDate;
	}

	/**
	 * 
	 * @param strDate
	 * @return
	 * @throws Exception
	 */
	public static Timestamp strToSQLTimestamp(String strDateTime) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
		java.util.Date utilDate = sdf.parse(strDateTime);	
		Timestamp ts = new Timestamp(utilDate.getTime());
		return ts;
	}
	
	/**
	 * format: yyyy-MM-dd (String)
	 * @param sqlDate
	 * @return
	 * @throws Exception
	 */
	public static String sqlTimestampToStringDate(Timestamp sqlTimestamp) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date(sqlTimestamp.getTime()));
	}
	
	
	/**
	 * convert Util Date to SQL Timestamp
	 * @param date
	 * @return
	 */
	public static Timestamp getSQLTimestampFromUtilDate(java.util.Date date){ 
		return date == null ? null : new Timestamp(date.getTime()); 
	}
	

	/**
	 *  SQL Timstamp to Util Date
	 * @param timestamp
	 * @return
	 */
	public static Date getUtilDateFromSQLTimestamp(java.sql.Timestamp timestamp) {
	    Date date = new Date(timestamp.getTime());
	    return date;
	}
	
	/**
	 * get String Date from Timestamp
	 * @param timestamp
	 * @return
	 */
	public static String getStrDateFromSQLTimestamp(java.sql.Timestamp timestamp) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		String strDate= formatter.format(timestamp); 
	    return strDate;
	}
	
	/**
	 * get String time from Timestamp
	 * @param timestamp
	 * @return
	 */
	public static String getStrTimeFromSQLTimestamp(java.sql.Timestamp timestamp) {
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");  
		String strTime= formatter.format(timestamp); 
	    return strTime;
	}
	
	/**
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String getStrDateTimeFromSQLTimestamp(java.sql.Timestamp timestamp) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");  
		String strDate= formatter.format(timestamp); 
	    return strDate;
	}
	
	public static String getCurrentDate() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");  
		return df.format(date); 
	}

	public static java.sql.Date getSQLDateFromSQLTimestamp(java.sql.Timestamp timestamp) {
		java.sql.Date date = new java.sql.Date(timestamp.getTime());
	    return date;
	}
	
}
