package com.pibs.constant;

/**
 * 
 * @author dward
 * Enhanced String literal values to numeric String and boolean values
 */
public class MapConstant {

	//Report Parameters
	public static String HOSPITAL_NAME = null;
	public static String HOSPITAL_ADDRESS = null;
	public static String HOSPITAL_TEL_NO = null;
	
	public static void setReportParamValues(String[] configArr) {
		HOSPITAL_NAME = configArr[0];
		HOSPITAL_ADDRESS = configArr[1];
		HOSPITAL_TEL_NO = configArr[2];
	}
	
	//bean object
	public static final String BEAN = "1";
	
	//map 
	public static final String MODULE = "2";
	public static final String ACTION = "3";
	public static final String SEARCH_CRITERIA = "4";
	public static final String CLASS_DATA = "5";
	public static final String CLASS_LIST = "6";
	public static final String BOOLEAN_DATA = "7";
	public static final String USER_SESSION_DATA = "8";
	public static final String TRANSACTION_STATUS = "9";
	//pagination
	public static final String PAGINATION_LIMIT = "10";
	public static final String PAGINATION_OFFSET = "11";
	public static final String PAGINATION_TOTALRECORDS = "12";
	//map 
	public static final String JDBC_CONNECTION = "13";
	public static final String ENTITY = "14";//for category in Archive
	public static final String SEARCH_VALUE = "15";
	public static final String DATE_FROM_VALUE = "16";
	public static final String DATE_TO_VALUE = "17";
	//Report
	public static final String RPT_TITLE = "18";
	public static final String RPT_JASPER = "19";
	public static final String RPT_PDF = "20";
	//boolean
	public static final boolean TRUE = true;
	public static final boolean FALSE = false;
			
	public static final String REPORT_PARAM_MAP = "report_param_data";
	public static final String REPORT_LOCALPATH = "report_local_path";


	
}
