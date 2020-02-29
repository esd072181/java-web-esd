package com.crms.constant;

public class CRMSConstant {
	
	//Billing Reports - Orig Path
//	public static String PDF_REPORT_ORIG_PATH = null;
	public static String PDF_REPORT_ORIG_PATH = "C:\\crmsweb\\reports\\"; //test code
	//Report Parameters
//	public static String HOSPITAL_NAME = null;
//	public static String HOSPITAL_ADDRESS = null;
//	public static String HOSPITAL_TEL_NO = null;

	public static String LAB_NAME = "Arayat Medical Clinic";
	public static String LAB_ADDRESS = "Plazang Luma, Arayat Pampanga";
	public static String LAB_TEL_NO = "(045)961-89-89";

	
	public static void setConfigValues(String[] configArr) {
		LAB_NAME = configArr[0];
		LAB_ADDRESS = configArr[1];
		LAB_TEL_NO = configArr[2];
		PDF_REPORT_ORIG_PATH = configArr[3];
	}

	//pagination
	public static final int RECORDS_PER_PAGE = 10;
	
	//Reports - jasper
	public static final String RPT_PRESCRIPTION_TITLE = "PRESCRIPTION";
	public static final String RPT_PRESCRIPTION_JASPER = "prescription.jasper";


	//Reports - pdf
	public static final String PDF_PRESCRIPTION_REPORT = "Presc_";
	
	
	public static final String USER_VALID_SESSION = "User session is valid, Go to home";
	public static final String USER_INVALID_SESSION = "Invalid Session, Go to login";

	
	
}
