package com.lrms.constant;

public class LRMSConstant {
	
	//Billing Reports - Orig Path
//	public static String PDF_REPORT_ORIG_PATH = null;
	
	//need to transfer report path to an external file
//	public static String PDF_REPORT_ORIG_PATH = "C:\\lrmsweb\\reports\\"; //test code for windows
	public static String PDF_REPORT_ORIG_PATH = "/Users/lrmsweb_reports/"; //test code for unix based
	
	//Report Parameters
//	public static String HOSPITAL_NAME = null;
//	public static String HOSPITAL_ADDRESS = null;
//	public static String HOSPITAL_TEL_NO = null;

	public static String LAB_NAME = "Arayat Medical Laboratory";
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
	public static final String RPT_BLOODCHEM_TITLE = "BLOOD CHEMISTRY";
	public static final String RPT_URINALYSIS_TITLE = "URINALYSIS";
	public static final String RPT_FECALYSIS_TITLE = "FECALYSIS";
	public static final String RPT_HEMATOLOGY_TITLE = "HEMATOLOGY";
	public static final String RPT_MISC_TITLE = "MISCELLANEOUS";
	public static final String RPT_BLOODCHEM_JASPER = "bloodchem.jasper";
	public static final String RPT_URINALYSIS_JASPER= "urinalysis.jasper";
	public static final String RPT_FECALYSIS_JASPER = "fecalysis.jasper";
	public static final String RPT_HEMATOLOGY_JASPER = "hematology.jasper";
	public static final String RPT_MISC_JASPER = "misc.jasper";

	//Reports - pdf
	public static final String PDF_BLOODCHEM_REPORT = "Bchem_";
	public static final String PDF_URINALYSIS_REPORT = "Urin_";
	public static final String PDF_FECALYSIS_REPORT = "Feca_";
	public static final String PDF_HEMATOLOGY_REPORT = "Hema_";
	public static final String PDF_MISC_REPORT = "Misc_";
	
	
	public static final String USER_VALID_SESSION = "User session is valid, Go to home";
	public static final String USER_INVALID_SESSION = "Invalid Session, Go to login";

	
	
}
